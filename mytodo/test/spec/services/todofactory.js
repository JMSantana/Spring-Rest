'use strict';

describe('Service: TodoFactory', function () {

  // load the service's module
  beforeEach(module('mytodoApp'));

  // instantiate service
  var TodoFactory;
  beforeEach(inject(function (_TodoFactory_) {
    TodoFactory = _TodoFactory_;
  }));

  it('should do something', function () {
    expect(!!TodoFactory).toBe(true);
  });

});
