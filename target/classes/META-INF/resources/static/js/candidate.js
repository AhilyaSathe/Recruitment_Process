var candidate=angular.module('candidateApp',[]);
 
candidate.controller("candidateController",['$scope','candidateService','$window','$location',function($scope,candidateService,$window,$location)
{
	$scope.checkLoginOfCandidate=function()
	{
		
		console.log("email id is:  "+$scope.emailId);
		candidateService.checkLoginOfCandidate($scope.emailId)
						.then(function(response)
					   {
		    			     alert("in success"+response);
		    			     var pat=response.data;
		    			     console.log(pat);
		    			     if(pat=='/homePageCandidate')
		    			    	 $window.location.href='/homePageCandidate';
		    			     else if(pat=='/loginCandidate')
		    			    	 $window.location.href='/loginCandidate';
		    			   
		    		  });
	}
	
	
}]);

candidate.factory("candidateService",['$http','$q',function($http,$q)
{
	var urlBase='http://localhost:8080';
	
	var factory = 
    {
			checkLoginOfCandidate:checkLoginOfCandidate
    }
	return factory;
	
	function checkLoginOfCandidate(emailId)
	{
		alert("in candidateService"+emailId);
		var deferred = $q.defer();
    	
    		$http.post(urlBase+'/checkLoginOfCandidate/'+emailId)
    	
    		 .then(function(response)
    		  {
    			     console.log(response);
    				 deferred.resolve(response);
    			
    		  },
   	          function(errResponse)
   	          {
   	            	alert("in error");
   	                console.error('Error while fetching Users');
   	                deferred.reject(errResponse);
   	           });
    	 	return  deferred.promise;
	}


}]);