'use strict';

describe('Controller: CarControllerCtrl', function () {

  // load the controller's module
  beforeEach(module('frontendApp'));

  var CarControllerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CarControllerCtrl = $controller('CarControllerCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
