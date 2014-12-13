'use strict;'

angular.module('MainCtrl', []).controller('MainController',
    ['$scope', '$http', function($scope, $http) {
    	
    	$scope.form = {
    		username: '',
    		password: ''
    	};
    	
    	$scope.submitLoginForm = function() {
    		$http.post(
    			'/login',
    			JSON.stringify($scope.form))
    			
    			.success(function() {
    				/*success callback*/}
    			)
    			.error(function(err) {
    				console.log(err);
    			});
    	};
}]);
