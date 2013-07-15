var fs = require('fs');
var $ = require('jquery');
var _ = require('underscore');
var Q = require('q');

var outputDir = "output/make";
if (fs.existsSync(outputDir)) {
    var files = fs.readdirSync(outputDir);
    _.each(files, function (f) {
        fs.unlinkSync(outputDir + "/" + f);
    });
    fs.rmdirSync(outputDir);
}
fs.mkdirSync(outputDir);

var Make = function (name, url) {
    this.name = name;
    this.url = url;
    this.models = [];
};

var Model = function (name, url) {
    this.name = name;
    this.url = url;
    this.variants = [];
};

var Variant = function (name, attrs, url) {
    this.name = name;
    this.attrs = attrs;
    this.url = url;
};


var getRefineLinks = function ($page, title) {
    var $refines = $page.find('.jq-collapsible');

    return $(_.find($refines, function (refine) {
        var header = $(refine).find("li.header").first();
        return header.text() == title;
    }));
};

var getMoreLink = function ($refineSection, kind) {
    var deferred = Q.defer();

    var moreLink = $refineSection.find("ul li.refine-item a.expand-link.link-button").first();

    var url = "http://www.redbook.com.au/ajax/execute.ashx?ajaxMN=AjaxGet&ajaxCN=EndecaSearchProvider,Endeca.Toolkit.Extension&dim=" + kind + "&refurl=%3F"
        + moreLink.data('refurl').substring(1);

    $.get(url)
        .done(function (data) {
            deferred.resolve(JSON.parse(data));
        })
        .fail(function () {
            deferred.reject(new Error(arguments[2]));
        });
    return deferred.promise;
};

var getMakes = function () {
    var deferred = Q.defer();
    var url = "http://www.redbook.com.au/cars/research";
    $.get(url)
        .done(function (page) {
            var $page = $(page);

            var $makeRefine = getRefineLinks($page, "Make");

            deferred.resolve(getMoreLink($makeRefine, "Make"));
        })
        .fail(function () {
            deferred.reject(new Error("Getting makes: " + url + " : " + arguments[2]));
        });
    return deferred.promise;
};

var getModels = function (url) {
    var deferred = Q.defer();
    var url = "http://www.redbook.com.au" + url;
    $.get(url)
        .done(function (page) {
            var $page = $(page);

            var $modelRefine = getRefineLinks($page, "Model");

            if ($modelRefine.find("ul li.refine-item a.expand-link.link-button").length > 0) {
                deferred.resolve(getMoreLink($modelRefine, "Model"));
            } else {
                deferred.resolve(_.map($modelRefine.find(".refine-item a"), function (el) {
                    var $el = $(el);
                    return {
                        Text: $el.text(),
                        Attributes: {
                            RefineUrl: $el.attr('href')
                        }
                    };
                }));
            }
        })
        .fail(function () {
            deferred.reject(new Error("Getting models: " + url + " : " + arguments[2]));
        });
    return deferred.promise;
};

var getResults = function ($page) {
    var resultsRaw = $page.find(".csn-results .content a.item");
    var toReturn = _.map(resultsRaw, function (item) {
        var $item = $(item);
        var $desc = $item.find(".desc");

        return new Variant($desc.find("> h3").text(), {}, $item.attr("href"));
    });
    return toReturn;
};

var getVariants = function (url, year) {
    var deferred = Q.defer();

    if (url.indexOf("http://www.redbook.com.au") == -1) {
        url = "http://www.redbook.com.au" + url;
    }

    var hasQuery = _.contains(url, "?");
    if (!hasQuery) {
        url = url + "?Range=Year:" + year + "," + year;
    } else {
        url = url + "&Range=Year:" + year + "," + year;
    }
    $.get(url)
        .done(function (page) {
            var $page = $(page);
            deferred.resolve(getResults($page));
        })
        .fail(function () {
            deferred.reject(new Error("Getting vars: " + url + " : " + arguments[2]));
        });
    return deferred.promise;
};

var makeWhitelist = ["Audi", "BMW", "Citroen", "Datsun", "Ferrari", "Fiat", "Ford", "Great Wall", "Holden", "Holden Special Vehicles",
    "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", "Lamborghini", "Lancia", "Land Rover", "Lexus", "Lotus", "M.G", "Maserati", "Mazda",
    "Mini", "Mclaren", "Mercedes-Benz", "Mitsubishi", "Nissan", "Opel", "Pagani", "Peugeot", "Porsche", "Renault", "Rover", "Rolls Royce",
    "Saab", "Seat", "Skoda", "Smart", "Ssangyong", "Subaru", "Suzuki", "Tesla", "Toyota", "TRD", "Triumph", "TVR", "Vauxhall", "Volkswagen",
    "Volvo", "Honda"];

getMakes()
    .then(function (makes) {
        _.each(makes, function (makeOb) {
            if (_.contains(makeWhitelist, makeOb.Text)) {
                getModels(makeOb.Attributes.RefineUrl)
                    .then(function (models) {
                        _.each(_.range(1990, 2013), function (year) {
                            var make = new Make(makeOb.Text, makeOb.Attributes.RefineUrl);
                            var result = Q.resolve(make);

                            _.each(models, function (model) {
                                result = result.then(function (make) {
                                    return getVariants(model.Attributes.RefineUrl, year)
                                        .then(function (vars) {
                                            var modelToAdd = new Model(model.Text, model.Attributes.RefineUrl);
                                            modelToAdd.variants = vars;
                                            make.models.push(modelToAdd);
                                            return make;
                                        });
                                });
                            });

                            result.then(function (result) {
                                console.log("Done: " + year + " " + makeOb.Text);
                                fs.writeFileSync(outputDir + "/" + makeOb.Text + "_" + year + ".json", JSON.stringify(result));
                            }).catch(function (error) {
                                console.log("Failed: " + year + " " + makeOb.Text, error);
                            });
                        })
                    })
            };
        });
    });