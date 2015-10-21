app.controller('WelcomeController', function($scope, PersonService) {
    $scope.people = [];
    
    PersonService.query(function(retorno) {
       $scope.people = retorno;
    });
});