app.controller('PersonController', function($scope, PersonService, focus) {

	$scope.people = [];
	$scope.person = {};
	
	focus("input-name");
	
	function listPersons(){
		PersonService.query(function(retorno) {
	        $scope.people = retorno;
	    });
	};
	
	listPersons();
	
	$scope.remove = function(person) {
		PersonService.delete({id: person.id}, function(status) {
			listPersons();
			$scope.person = {};
        });
    };
    
    $scope.merge = function() {
    	if($scope.person.id){
    		PersonService.update({id: $scope.person.id},$scope.person, function(status) {
				$scope.person = {};
				focus("input-name");
	        });
    	}else{
    		PersonService.save($scope.person, function(status) {
				listPersons();
				$scope.person = {};
				focus("input-name");
	        });
    	}	
    };
    
    $scope.edit = function(person){
    	$scope.person = person;
    }
    
   
	
    
});