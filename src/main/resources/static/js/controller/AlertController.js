app.controller('AlertsCtrl', function($scope, alertsManager) {
    $scope.alerts = alertsManager.alerts;
    
    $scope.reset = function() {
        alertsManager.clearAlerts();
    };
});

