'use strict';

angular.module('frontendApp', ['frontendApp.resources'])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/car.html',
        controller: 'CarCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);
