app.controller('homeController', simpleHomeController)


function simpleHomeController($scope, $http, $rootScope) {
   // $scope.categories = ["", "Motoryzacja", "Dom i ogród", "Elektronika", "Praca", "Nieruchomości", "Moda"];


    $scope.categories="";

    $scope.search = "";
    $scope.dane = "";

    $scope.getOrig = function() {
        return $rootScope.test;
    };

    $scope.changeRs = function() {
        $rootScope.test =  "dwojkaRs";
    };



    $scope.searchingResoults = function () {


        $http.get('http://localhost:8095/getSearched/'+$scope.search)
            .then(function (result) {
                    $scope.dane = result.data;


                }, function (result) {
                    $scope.dane = "blad pobrania odfiltrowanych wyników"
                }
            );
    };

    //*********************************** robocze************************
 $scope.loadCategories=function(){
   $http.get('http://localhost:8095/getAllCategories')
       .then(function(result){

          $scope.categories=result.data;

       },function(result) {

        $scope.categories=["blad zaladowania kategorii"];
       }
       );


 };


    //*********************************** robocze************************

};
