var app = angular.module("tlApp", []);


app.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});
	
app.controller("tlController", ['tlService','$scope','$window','$location',function(tlService,$scope,$window,$location)
{
	//alert("in controller");
	$scope.listOfCandidates=[];
	$scope.user={};
	
	findAllCandidates();
	
	//for pagination
	$scope.currentPage = 0;
    $scope.pageSize = 5;
   /* $scope.data = [];*/
    $scope.numberOfPages=function()
    {
        return Math.ceil($scope.listOfCandidates.length/$scope.pageSize);                
    }
    for (var i=0; i<45; i++)
    {
        $scope.listOfCandidates.push("Item "+i);
    }
	
	//finding all Candidates
	function findAllCandidates()
   	 {
		
			tlService.findAllCandidates()
	        .then(function(data) 
	        {
	        	
	        	JSON.stringify(data);
	        	$scope.listOfCandidates = data.data;
	  	     });
   	 }
	
	//downloadCV
	$scope.downloadCV=function(check)
	{
		console.log("check"+check.cv);
		var fileURl=check.cv;
		tlService.downloadCV(fileURl)
        .then(function(data) 
        {
        	console.log("downloaded");
        	
  	     });
		
		
	}
	
	$scope.acceptedStatus=function(id)
	{
		 var buttonColor = "lime";
		alert("status is Accepted"+id);
		tlService.acceptedStatus(id)
		.then(function()
				{
					alert("status is updated in database");
					 /*$scope.httpCall = {
					          'background-color': buttonColor
					        }*/
					
					tlService.findAllCandidates()
			        .then(function(data) 
			        {
			        	
			        	JSON.stringify(data);
			        	$scope.listOfCandidates = data.data;
			  	     });
				});
		}
	
	$scope.rejectedStatus=function(id)
	{
		 var buttonColor = "lime";
		alert("status is rejected"+id);
		tlService.rejectedStatus(id)
		.then(function()
				{
					alert("status is updated in database");
					 /*$scope.httpCall = {
					          'background-color': buttonColor
					        }*/
					
					tlService.findAllCandidates()
			        .then(function(data) 
			        {
			        	
			        	JSON.stringify(data);
			        	$scope.listOfCandidates = data.data;
			  	     });
				});
		}
	
	
}]);        


app.factory('tlService',['$http','$q','$location',function($http,$q,$location)
{
	var urlBase='http://localhost:8080';
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var factory = 
    {
 		   
 		   findAllCandidates:findAllCandidates,
 		  downloadCV:downloadCV,
 		 acceptedStatus:acceptedStatus,
 		rejectedStatus:rejectedStatus
 		  
    };
    return factory;
    	
    //get list of all Candidates
    function findAllCandidates() 
    {                       		
    	
        var deferred = $q.defer();
        $http.get(urlBase+'/listOfscheduledCandidates')
             .then(function (response) 
              {
           	      deferred.resolve(response);
              },
              function(errResponse)
              {
            	  	alert("in error");
            	  	console.error('Error while fetching Users');
            	  	deferred.reject(errResponse);
               });
        
               return deferred.promise;
      }

    //downloadCV
	
 	  function downloadCV(fileURL)
  	 {
  		alert("in downloadCV " +fileURL);
 		 
          var deferred = $q.defer();
          $http.post(urlBase+'/downloadFile',fileURL)
              .then(
              function (response)
              {
              	
                  deferred.resolve(response);
              },
              function(errResponse){
                  console.error('Error while viewing User');
                  deferred.reject(errResponse);
              }
          );
          return deferred.promise;
      }  
 	  
 	  function acceptedStatus(id)
 	  {
 		  alert("in service "+id);
 		 var deferred = $q.defer();
 		  $http.post(urlBase+"/acceptedStatus/"+id)
 		  .then(function(data)
 				  {
 			  			alert("updated successfully");
 			  			/*$http.post(urlBase+"/getScheduledStatus"+id)
 			  			.then(function(data){alert("success");});
 			  			*/
 			  			deferred.resolve(data);
 			  		},
 		function(errResponse)
 				{
 						alert("in error");
 						deferred.reject(errResponse);
 				});
 		 return deferred.promise;
 	  }
 	 
 	 
	  function rejectedStatus(id)
	  {
		  alert("in service "+id);
		 var deferred = $q.defer();
		  $http.post(urlBase+"/rejectedStatus/"+id)
		  .then(function(data)
				  {
			  			alert("updated successfully");
			  			/*$http.post(urlBase+"/getScheduledStatus"+id)
			  			.then(function(data){alert("success");});
			  			*/
			  			deferred.resolve(data);
			  		},
		function(errResponse)
				{
						alert("in error");
						deferred.reject(errResponse);
				});
		 return deferred.promise;
	  }
     
}]);
                    	
                       	