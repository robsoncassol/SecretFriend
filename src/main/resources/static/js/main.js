var app = angular.module('People',['ngRoute','ngResource','services','directives']);

app.config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl: 'partials/welcome.tpl.html',
		controller: 'WelcomeController'
	});

	$routeProvider.when('/people', {
		templateUrl: 'partials/people.tpl.html',
		controller: 'PersonController'
	});

	$routeProvider.otherwise({redirectTo: '/'});
	
});