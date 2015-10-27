var app = angular.module('People',['ngRoute','ngResource','services','directives','angularUtils.directives.dirPagination']);

app.config(function($routeProvider, paginationTemplateProvider) {

	$routeProvider.when('/', {
		templateUrl: 'partials/welcome.tpl.html',
		controller: 'WelcomeController'
	});

	$routeProvider.when('/people', {
		templateUrl: 'partials/people.tpl.html',
		controller: 'PersonController'
	});
	
	$routeProvider.when('/shuffle', {
		templateUrl: 'partials/friends.tpl.html',
		controller: 'ShuffleController'
	});

	$routeProvider.otherwise({redirectTo: '/'});
	
	paginationTemplateProvider.setPath('partials/dirPagination.tpl.html');
	
});