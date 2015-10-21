angular.module('services', ['ngResource'])
    .factory('PersonService', function($resource) {
        return $resource('/person/:id');
    }
);