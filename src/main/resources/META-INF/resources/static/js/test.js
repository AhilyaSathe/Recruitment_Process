var myApp = angular.module('myApp', []);

myApp.directive('fileModel', ['$parse', function ($parse) {
	alert("in directive");
    return {
    	
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

myApp.service('fileUpload', ['$http', function ($http) 
               {
	alert("in fileUploadService");
    this.uploadFileToUrl = function(file, uploadUrl,candidate){
        var fd = new FormData();
        fd.append('file', file);
        fd.append('candidate',JSON.stringify(candidate));
      /*  fd.append('candidate', candidate);*/
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });
    }
}]);

myApp.controller('registerController', ['$scope', 'fileUpload', function($scope, fileUpload)
                                  {
    alert("in controler");
    $scope.uploadFile = function(){
    	var candidate=$scope.candidate;
    	alert("in controller" +$scope.candidate.firstName);
        var file = $scope.myFile;
        console.log('file is ' );
        console.dir(file);
        var uploadUrl = "http://localhost:8080/addCandidate";
        fileUpload.uploadFileToUrl(file, uploadUrl,candidate);
    };
    
}]);