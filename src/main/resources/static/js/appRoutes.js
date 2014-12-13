
angular.module('appRoutes', []).config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {

    $routeProvider

        .when('/login', {
        	templateUrl: 'views/login_view.html',
        	controller: 'MainController'
        });
        
    $locationProvider.html5Mode(true);
}]);

