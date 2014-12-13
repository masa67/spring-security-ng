'use strict;'

angular.module('MainCtrl', []).controller('MainController',
    ['$scope', '$http', function($scope, $http) {
    	
    	console.log('MainCtrl started.');
    	
    	$scope.form = {
    		username: '',
    		password: ''
    	};
    	
    	$scope.submitLoginForm = function() {
    		$http({
    			method: 'POST',
    			url: '/login',
    			data: $.param($scope.form),
    			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    		}).then(function() {
    			window.location.href = 'index.html';
    		}, function(err) {
    			console.log(err);
    		});
    	};
}]);
