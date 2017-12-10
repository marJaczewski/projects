//app.controller('aboutController',function($scope){});


app.directive('customOnChange', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var onChangeFunc = scope.$eval(attrs.customOnChange);
            element.bind('change', onChangeFunc);
        }
    };
});

app.controller('aboutController', function ($scope) {
    $scope.data = 'none';
    $scope.dataimg = 'none';
    $scope.add = function() {

        var f = document.getElementById('file').files[0],
            r = new FileReader();
        r.onloadend = function(e) {
            $scope.data = e.target.result;
            var img = document.createElement('img');
            img.src = 'data:image/jpeg;base64,' + btoa(e.target.result);
            document.body.appendChild(img);

        }
        r.readAsBinaryString(f);
    }
});



