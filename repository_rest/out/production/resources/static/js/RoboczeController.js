

app.controller('roboczeController', function($scope) {
    alert(1);
    $scope.onSelectFile = function($files) {
        for (var i = 0; i < $files.length; i++) {
            var $file = $files[i];
            $upload.upload({
                url: 'images',
                file: $file,
                progress: function(e) {
                    // wait...
                }
            })
                .then(function(data, status, headers, config) {
                    alert('file is uploaded successfully');
                });
        }
        alert('file is uploaded successfully');
    }
});