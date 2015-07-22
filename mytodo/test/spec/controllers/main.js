'use strict';

describe('Controller: MainCtrl', function () {

    // load the controller's module
    beforeEach(module('mytodoApp'));

    var MainCtrl,
        TodoFactory,
    	scope,
		httpBackend;

    // Initialize the controller and a mock scope
    beforeEach(inject(function ($controller, $rootScope, _TodoFactory_, $httpBackend) {
        scope = $rootScope.$new();
        TodoFactory = _TodoFactory_;
		httpBackend = $httpBackend;
        MainCtrl = $controller('MainCtrl', {
            $scope: scope,
            TodoFactory: _TodoFactory_
        });
		
    }));

    it('should get all todos when starting', function () {
        //given
		spyOn(TodoFactory, 'query');
		
		//when
		scope.getAll();
				
		//and
		expect(TodoFactory.query).toHaveBeenCalled();
    });

    it('should add todo', function () {
		 //given
		spyOn(TodoFactory, 'save');
		
		//and
		spyOn(scope, 'addSuccessCallback');
		
		//and:
		scope.todo = 'test';
					
		//when
		scope.addTodo();
				
		//and
		expect(TodoFactory.save).toHaveBeenCalledWith(JSON.stringify({'todo': 'test'}), scope.addSuccessCallback);
		
    });

    
	it('should update todo', function () {
        //given
		var todo = {$update : jasmine.createSpy()};
				
		//when
		scope.updateTodo(todo);
				
		//and
		expect(todo.$update).toHaveBeenCalled();
    });
	
	it('should delete todo', function () {
        //given
		var todo = {'id':'007', $delete : jasmine.createSpy()};
		
		//and
		spyOn(scope, 'removeSuccessCallback');
				
		//when
		scope.removeTodo(todo);
				
		//and
		expect(todo.$delete).toHaveBeenCalledWith(todo.id, scope.removeSuccessCallback);
    });
});