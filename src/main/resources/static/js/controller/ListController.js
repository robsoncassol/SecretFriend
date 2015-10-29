app.controller('ListController', function($scope, PersonService, $location) {
	$scope.persons = [];
	
	function listPersons(){
		PersonService.query(function(retorno) {
	        $scope.persons = retorno;
	    });
	};
	
	listPersons();
    
    $scope.edit = function(){
    	PersonService.editingPerson = this.person;
    	$location.path("/form");
    }
    
    $scope.add = function(){
    	PersonService.editingPerson = {};
    	$location.path("/form");
    }
    
	$scope.remove = function(person, e) {
		PersonService.delete({id: person.id}, function(status) {
			listPersons();
			$scope.person = {};
        });
		event.stopPropagation();
    };
	
});