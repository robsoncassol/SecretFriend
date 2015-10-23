app.controller('ShuffleController', function($http, $scope, focus) {

	$scope.pairs = [];
	
	
	 $scope.shuffle = function(){
    	$http({
    		  method: 'GET',
    		  url: '/shuffle'
    		}).then(function successCallback(response) {
    			$scope.pairs = response.data;
    			console.log(response.data);
    		  }, function errorCallback(response) {
    			  console.log('pauuuu')
    		  });
	 };
	 
	 $scope.shuffle();
	
	 
	
    
});