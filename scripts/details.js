var fs = require('fs');
var jquery = require('jquery');
var cheerio = require('cheerio');
var _ = require('underscore');
var Q = require('q');
var detailKeys = require('./detail_key').keys;

var file = process.argv[2];

var getDetails = function ($page) {
    //var props = $page('table.prop-list tbody tr td table tbody tr');
    var props = $page('table.prop-list table tr');
    var details = {};
    _.each(props, function (p) {
        var $p = $page(p);
        var label = $p.find('td.label').text();
        var value = $p.find('td.value').text();
        if (detailKeys[label]) {
            details[detailKeys[label]] = value;
        }
    });

    return details;
};

var toFileName = function (str) {
    while (str.indexOf("/") != -1) {
        str = str.replace("/", "_");
    }
    return str;
}

var indexDir = "output/index";
//var files = fs.readdirSync(indexDir);
var files = [file];

var fails = {};

_.each(files, function (f) {
    var content = JSON.parse(fs.readFileSync(indexDir + "/" + f));
    var makeName = content.name;

    _.each(content.models, function (model) {
        var modelName = model.name;
        var fileName = "output/details/" + toFileName(modelName) + "_" + f;
        if (!fs.existsSync(fileName)) {
            var result = Q.resolve([]);

            _.each(model.variants, function (v) {
                var url = v.url;
                if (url.indexOf("http://www.redbook.com.au") == -1) {
                    url = "http://www.redbook.com.au" + url;
                }

                result = result.then(function (results) {
                    var deferred = Q.defer();
                    jquery.get(url)
                        .done(function (page) {
                            var details = getDetails(cheerio.load(page));
                            console.log(v.name);
                            deferred.resolve(_.union(results, [details]));
                        })
                        .fail(function () {
                            if (!fails[url]) {
                                fails[url] = 1;
                            } else {
                                fails[url] =  fails[url] + 1;
                            }
                            if (fails[url] >= 5) {
                                console.log("Failed getting: " + url);
                                deferred.reject(new Error("fail", arguments));
                            }
                        });
                    return deferred.promise;
                });
            });
            
            result.then(function (details) {
                    fs.writeFileSync(fileName, JSON.stringify(details));
            })
            .catch(function () {
                console.log("Totally failed " + modelName, arguments);
            });
        } else {
            console.log("Skipping " + modelName);
        }
    });
});
