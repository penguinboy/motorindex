
var readline = require('readline');
var fs = require('fs');
var _ = require('underscore');
var Q = require('q');
var async = require('async');

var detailsDir = "output/details";

var files = fs.readdirSync(detailsDir);

console.log('need ' + files.length);

var tasks = [];

_.each(files, function (f) {
    tasks.push(function (cb) {
        if (f != ".DS_Store") {
            console.log('Opening');
            fs.readFile(detailsDir + "/" + f, function (error, result) {
                console.log("Read " + f);
                if (error) {
                    cb(error);
                } else {
                    var content = JSON.parse(result);
                    cb(null, content);
                }
            });
        } else {
            cb(null, []);
        }
    });
});

async.parallelLimit(tasks, 100, function (err, results) {
    console.log("Done");
    
    ask(results);
});

var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var ask = function (all) {
    console.log('asking');
    rl.question("Find? ", function(answer) {
        var results = [];
        _.each(all, function (set) {
            results = _.union(results, _.pluck(set, answer));
            results = _.uniq(results);
        });
        console.log(results);

        ask(all);
    });
};