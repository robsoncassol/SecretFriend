app.controller('PersonController', function($scope, PersonService, alertsManager, $location) {

	$scope.person = PersonService.editingPerson;
	
    $scope.merge = function() {
    	if($scope.person.id){
    		PersonService.update({id: $scope.person.id},$scope.person, function(status) {
				cleanAlertRedirect("Atualizado com sucesso!");
	        });
    	}else{
    		PersonService.save($scope.person, function(status) {
    			cleanAlertRedirect("Cadastro efetuado!");
	        }, function(error){
	        	console.log(error);
	        	if(error.status == 409)
	        		alertsManager.addAlert("Este e-mail já foi cadastrado. Tente outro.","alert-danger");
	        	
	        });
    	}	
    };
    
    function cleanAlertRedirect(msg){
    	$scope.person = {};
		alertsManager.addAlert(msg,"alert-success");
		$location.path("/"); 
    }
    
});