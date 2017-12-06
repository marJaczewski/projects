// var app = angular.module('mainModule', ['ngRoute','ngFileUpload']);
// var app = angular.module('mainModule', ['ngRoute']).run(function($rootScope){
//     $rootScope.test="app";
// });
var app = angular.module('mainModule', ['ngRoute']);




app.config(function($routeProvider) {
    $routeProvider

        .when('/newAdvertisment', {
            templateUrl: 'pages/NewAdvertisment.html',
            controller: 'newAdvertismentController'
        })

        .when('/adverts', {
            templateUrl: 'pages/AllAdvertisments.html',
            controller: 'allAdvertismentsController'
        })

        .when('/about', {
            templateUrl: 'pages/about.html',
            controller: 'aboutController'
        })

        .when('/home', {
            templateUrl:'pages/home.html',
            controller:'homeController'
        })


           .when('/current/:id', {
            templateUrl: 'pages/Current.html',
            controller: 'currentController'
        })


        .when('/robocze', {
            templateUrl: 'pages/Robocze.html',
            controller: 'fileUploadCtrl'
        })


        .otherwise({
            redirectTo: '/home',
            controller: 'homeController'
        })
});

