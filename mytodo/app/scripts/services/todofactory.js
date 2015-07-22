'use strict';

/**
 * @ngdoc service
 * @name mytodoApp.TodoFactory
 * @description
 * # TodoFactory
 * Factory in the mytodoApp.
 */
angular.module('mytodoApp')
  .factory('TodoFactory', ["$resource", function ($resource) {
      
    return $resource("http://localhost:8080/spring-rest/todo/:id", null,
                     {
                        'update': { method:'PUT' },
						'save': { method:'POST' },
						'delete': { method:'DELETE',
									params: {id:'@id'},
									isArray: false }
                     });
  }]);
