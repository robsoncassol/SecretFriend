var app = angular.module('Persons',['ngRoute','ngResource','services','directives','angularUtils.directives.dirPagination']);

app.config(function($routeProvider, paginationTemplateProvider) {

	$routeProvider.when('/', {
		templateUrl: 'partials/list.tpl.html',
		controller: 'ListController'
	});

	$routeProvider.when('/form', {
		templateUrl: 'partials/form.tpl.html',
		controller: 'PersonController'
	});
	
	$routeProvider.when('/pairs', {
		templateUrl: 'partials/pairs.tpl.html',
		controller: 'PairsController'
	});

	$routeProvider.otherwise({redirectTo: '/'});
	
	paginationTemplateProvider.setPath('partials/dirPagination.tpl.html');
	
});