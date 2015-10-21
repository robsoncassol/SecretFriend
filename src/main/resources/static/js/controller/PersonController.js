app.controller('PersonController', function($scope, PersonService) {

	$scope.people = []
	
	function listPersons(){
		PersonService.query(function(retorno) {
	        $scope.people = retorno;
	    });
	}
	
	listPersons();
	
	$scope.remove = function(person) {
		PersonService.delete({id: person.id}, function(status) {
			listPersons();
        });
    };
	
    
});