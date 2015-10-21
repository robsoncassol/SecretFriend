angular.module('directives', [])
    .directive('thePanel', function() {
    	var directive = {
                restrict: 'E', 
                templateUrl: 'directive/the-panel.html',
                transclude: true, 
                scope: {
                      title: '@'
                }
           };
    	return directive;
    });