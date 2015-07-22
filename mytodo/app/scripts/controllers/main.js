'use strict';

angular.module('mytodoApp')
  .controller('MainCtrl', ["$scope", "TodoFactory", function ($scope, TodoFactory) {
	  
	$scope.getAll = function(){
		$scope.todos = TodoFactory.query();
	}
	
	$scope.getAll();
	
	$scope.addSuccessCallback = function(data){
		$scope.todos.push(data);
		$scope.todo = '';
	};
	 
    $scope.addTodo = function() {
		var newTodo = {
				"todo":$scope.todo
			};
		
        TodoFactory.save(JSON.stringify(newTodo),$scope.addSuccessCallback);
    };
      
    $scope.updateTodo = function(todo) {
        todo.$update();
    };
	  
  	$scope.removeSuccessCallback = function(data){
		$scope.todos.splice($scope.todos.indexOf(data), 1);
	};
	  
    $scope.removeTodo = function(todo) {
		todo.$delete(todo.id, $scope.removeSuccessCallback);
    };
  }]);