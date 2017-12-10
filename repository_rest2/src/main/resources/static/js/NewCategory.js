app.controller('newCategoryController', newCategorySimpleController)
function newCategorySimpleController($scope, $http){

$scope.newCategory={
    name:""
};

$scope.addCategory=function(){

    $http.post('http://localhost:8095/newCategory', $scope.newCategory);


};

};