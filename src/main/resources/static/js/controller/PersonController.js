app.controller('PersonController', function($scope, PersonService) {

	$scope.people = [];
	$scope.person = {};
	
	function listPersons(){
		PersonService.query(function(retorno) {
	        $scope.people = retorno;
	    });
	};
	
	listPersons();
	
	$scope.remove = function(person) {
		PersonService.delete({id: person.id}, function(status) {
			listPersons();
        });
    };
    
    $scope.save = function() {
		PersonService.save($scope.person, function(status) {
			$scope.person = {};
			listPersons();
        });
    };
    
    $scope.edit = function(person){
    	$scope.person = person;
    }
	
    
});