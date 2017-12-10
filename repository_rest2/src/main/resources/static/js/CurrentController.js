app.controller('currentController', function ($scope, $location, $routeParams, $http, $rootScope) {

    $scope.singleAdvertisment = "";
    $scope.currentIdentyfikator = "";






    $scope.$on('$viewContentLoaded', function () {

        // $http.get('http://localhost:8095/current/' + $routeParams.id)
        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/current/'+ $routeParams.id)




            .then(function (result) {

                    $scope.singleAdvertisment = result.data;

                }, function (result) {

                    $scope.singleAdvertisment = "blad pobrania odfiltrowanych wyników";

                }
            );


    });


});

