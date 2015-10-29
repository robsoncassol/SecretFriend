angular.module('services', ['ngResource'])
    .factory('PersonService', function($resource) {
    	
    	var editingPerson = {};
    	
        return $resource('/person/:id', null, {
            'update': { method:'PUT' },
            'editingPerson':editingPerson
        });
        
    }
);