

angular.module('frontendApp.resources', ['ngResource'])
    .factory('Car', function ($resource) {
        var Car = $resource('/api/car/:id');

        return Car;
    });