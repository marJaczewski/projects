app.controller('allAdvertismentsController', function ($http, $scope, $log) {
    $scope.dane = "";


    $scope.getAdvertisments = function () {

        // $http.get('http://localhost:8095/getAllAdverts')


        $http.get('http://localhost:8095/getAllAdverts')
            .then(function (result) {
                // console.log(result.data[0]);
                $scope.dane = result.data;


            }, function (result) {
                $scope.dane = "Blad"
                console.log(result);
            })
    }
});












