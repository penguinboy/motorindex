'use strict';

angular.module('frontendApp')
    .controller('CarCtrl', ['$scope', '$routeParams', '$location', 'Car', function ($scope, $routeParams, $location, Car) {
        var options = {};
        _.each($routeParams, function (val, key) {
            if (!val) {
                return;
            }
            if (_.isString(val) && val.indexOf(',') != -1) {
                var vals = val.split(',');
                options[key] = {};
                _.each(vals, function (v) {
                    if (v != "") {
                        options[key][v] = true;
                    }
                });
            } else {
                var numberVal = parseFloat(val);
                if (numberVal != NaN) {
                    options[key] = numberVal;
                } else {
                    options[key] = val;
                }
            }
        });

        var toQueryObject = function (form) {
            var searchParams = {};
            _.each(form, function (val, key) {
                if (val === undefined) {
                    return;
                }

                if (_.isObject(val)) {
                    var arrayVal = "";
                    _.each(val, function (obVal, obKey) {
                        if (obVal == true) {
                            arrayVal += obKey + ",";
                        }
                    })
                    searchParams[key] = arrayVal;
                } else {
                    searchParams[key] = val;
                }
            });
            return searchParams;
        };

        // Setup default search params
        $scope.form = _.extend({
            "driveType": {
                "FOURWD": true,
                "RWD": true,
                "FWD": true,
            },
            "yearLow": 1990,
            "weightKerbLow": undefined,
            "weightKerbHigh": undefined,
            "powerLow": undefined,
            "powerHigh": undefined,
        }, options);

        $scope.loading = true;
        $scope.cars = Car.query(toQueryObject($scope.form), function () {
            $scope.loading = false;
        });

        $scope.search = function () {
            $location.search(toQueryObject($scope.form));
        };
    }]);
