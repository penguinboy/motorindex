var fs = require('fs');
var http = require('http');
var async = require('async');
var _ = require('underscore');
var secret = require('./secret').secret;


var detailsDir = "output/details";

var files = fs.readdirSync(detailsDir);

var tasks = [];

var options = {
  hostname: '127.0.0.1',
  port: 8888,
  path: '/api/dev/car?secret=' + secret,
  method: 'POST'
};


var uploadJson = function (str, retries, cb) {
    if (retries > 5) {
        cb("Upload failed");
    }
    else if (str == "[]") {
        // Empty, dont bother sending
        cb(null, true);
    } else {
        var errored = false;
        var op = _.extend(options, { headers: { 'Content-length': str.length, 'Content-Type': 'application/json' } });
        var req = http.request(op, function(res) {
            res.setEncoding('utf8');

            if (!errored && (res.statusCode == 200 || res.statusCode == 202)) {
                cb(null, true);
            } else {
                uploadJson(str, retries + 1, cb);
            }
            res.on('data', function (chunk) {});
        });

        req.on('error', function(e) {
            errored = true;
            console.log('Problem with request: ' + e.message);
            uploadJson(str, retries + 1, cb);
        });

        req.setTimeout(10000, function () {
            console.log('timeout');
            req.abort();
        });

        req.write(str + "\n");
        req.end();
    }
};

var complete = 0;

_.each(files, function (f) {
    tasks.push(function (cb) {
        if (f != ".DS_Store") {
            fs.readFile(detailsDir + "/" + f, function (error, result) {
                if (error) {
                    cb(error);
                } else {
                    uploadJson(result, 0, function (error, result) {
                        console.log(Math.floor((complete++ / files.length) * 100) + "%");
                        cb(error, result);
                    });
                }
            });
        } else {
            cb(null, true);
        }
    });
});

console.log("Starting");
async.parallelLimit(tasks, 10, function (err, results) {
    if (err) {
        console.log(err);
    } else {
        console.log("Done!");
    }
});