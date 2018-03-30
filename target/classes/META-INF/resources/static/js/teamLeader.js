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
	$scope.listOfInterviewers=[];
	$scope.user={};
	$scope.assignInterviewer={};
	$scope.listOfIntervieRounds=["First Round","Second Round","Third Round"];
	
	$scope.applicantsId={};
	
	 $( "#applicantsList" ).show();
	 $( "#addInterviewer" ).hide();
	
	
	findAllCandidates();
	getInterviewerList();
	
	$scope.showAddInterviewer=function()
	{
		 $( "#applicantsList" ).hide();
		 $( "#addInterviewer" ).show();
		 $( "#assignInterviewer" ).hide();
		
	}
	
	
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
    
    //addInterviewer()
    $scope.addInterviewer=function()
    {
    	
    	tlService.addInterviewer($scope.user)
    	 .then(function(data) 
    		        {
    		 			alert("Interviewer added successfully");
    		 			$( "#applicantsList" ).show();
    		 			 $( "#addInterviewer" ).hide();
    		 			$( "#assignInterviewer" ).hide();
    		 
    		  	     });
    }
    
    
  //finding all Interviewers
	function getInterviewerList()
   	 {
		
			tlService.getInterviewerList()
	        .then(function(data) 
	        {
	        	
	        	JSON.stringify(data);
	        	$scope.listOfInterviewers = data.data;
	  	     });
   	 }
	
	//show div of assign interview
	$scope.assignInterviewer=function(id)
	{
		console.log("id of the candidate is: "+id);
		$scope.applicantsId=id;
		/* angular.forEach($scope.listOfCandidates, function(item, index) 
	  	    		
   	  	    	{
			 	console.log($scope.techList[index]);
	              	  	  
				});*/
		
		
		$( "#applicantsList" ).hide();
		 $( "#addInterviewer" ).hide();
		 $( "#assignInterviewer" ).show();
	}
	
	$scope.assignInterview=function()
	{
		console.log("candidate is :"+$scope.applicantsId);
		console.log("interviewer is : "+$scope.assignInterviewer.interviewer.emailId);
		console.log("interviewRound is : "+$scope.assignInterviewer.interviewRound);
		
		
		tlService.assignInterview($scope.applicantsId,$scope.assignInterviewer.interviewer,$scope.assignInterviewer.interviewRound)
		.then(function(data)
		{
			alert("Email send to interviewer successfully");
			$( "#applicantsList" ).show();
			 $( "#addInterviewer" ).hide();
			 $( "#assignInterviewer" ).hide();
		});
		/*console.log("Tl is "+);*/
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
	var user={};
	/*var assignInterviewer={};*/
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var factory = 
    {
 		   
			 		findAllCandidates:findAllCandidates,
			 		downloadCV:downloadCV,
			 		acceptedStatus:acceptedStatus,
			 		rejectedStatus:rejectedStatus,
			 		addInterviewer:addInterviewer,
			 		getInterviewerList:getInterviewerList,
			 		assignInterview:assignInterview
 		  
    };
    return factory;
    
    
    //add interviewer
    function addInterviewer(user)
    {
    	var deferred = $q.defer();
    	
    	$http.post(urlBase+'/addInterviewer',user)
    	
    		 .then(function(response)
    		  {
    			    
    				 deferred.resolve(response);
    			
    		  },
   	          function(errResponse)
   	          {
   	            	//alert("in error");
   	                console.error('Error while adding interviewer');
   	                deferred.reject(errResponse);
   	           });
    	 return  deferred.promise;
    }
    	
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

    
    
  //get list of all Interviewers
    function getInterviewerList() 
    {                       		
    	
        var deferred = $q.defer();
        $http.get(urlBase+'/getInterviewerList')
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
    
    function assignInterview(applicantsId,interviewer,interviewRound)
    {
    	console.log("in service"+applicantsId+" "+interviewer+" "+interviewRound);
    	/*var data = {
    			
    			interviewer: assignInterviewer $scope.assignInterviewer.interviewRound
     			};*/
    	var deferred = $q.defer();
        $http.post(urlBase+'/assignInterview/'+applicantsId+'/'+interviewRound,interviewer)
            .then(
            function (response)
            {
            	
                deferred.resolve(response);
            },
            function(errResponse){
                console.error('Error while assignInterview');
                deferred.reject(errResponse);
            }
        );
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
                    	
                       	