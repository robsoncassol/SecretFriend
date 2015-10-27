app.controller('ShuffleController', function($http, $scope, focus) {

	$scope.pairs = [];
	
	
	 $scope.shuffle = function(){
    	$http({
    		  method: 'GET',
    		  url: '/shuffle'
    		}).then(function successCallback(response) {
    			$scope.pairs = response.data;
    		  }, function errorCallback(response) {
    			  console.log(response);
    			  alertsManager.addAlert("Erro os realizar o sorteio!","alert-danger");
    		  });
	 };
	 
	 $scope.shuffle();
	
	 
	 $scope.sendEmails = function(){
	    	$http({
	    		  method: 'POST',
	    		  url: '/send/emails'
	    		}).then(function successCallback(response) {
	    			alertsManager.addAlert("Emails enviados!","alert-success");
	    		  }, function errorCallback(response) {
	    			  console.log(response);
	    			  alertsManager.addAlert("Erro ao enviar e-mails!","alert-danger");
	    		  });
		 };
	 
	
    
});