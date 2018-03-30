
	var app = angular.module("myApp", []);
	
	app.filter('startFrom', function() {
	    return function(input, start) {
	        start = +start; //parse to int
	        return input.slice(start);
	    }
	});
	app.controller("registerController", ['registerService','$scope','$window','$location',function(registerService,$scope,$window,$location)
	           {
			
			
		
					//alert("in controller");
					$( "#check" ).hide();
					$( "#centeralDiv" ).show();
					$( "#scheduleInterview" ).hide();
					
					$scope.updateCandidates={};
					$scope.getCandidate={};
					$scope.scheduleCandidate={};
					$scope.candidate={};
					$scope.tech={};  
					$scope.test={};
					$scope.tlNames=[];
					
					$scope.deprtList=[];
					$scope.techList={}	;
					
					$scope.listOfCandidates=[];
					$scope.listOfTl=[];
					$scope.tl={};
					$scope.interviewRound={};
					alert($scope.interviewRound);
					
					//$scope.scheduledStatus={};
					findAllCandidates();
					getTechList();
					getDepartList();
					
					$scope.listOfIntervieRounds=["First Round","Second Round","Third Round"];
					$scope.candidate.technology;
					
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
								
					$scope.addCandidate=function()
					{
				//	alert("in addCandidate loginController" +$scope.candidate.technology);
					registerService.addCandidate($scope.candidate)
					 		   .then(function(response)
	                			{
					 			   alert("Added successfully");
					 			  $( "#check" ).hide();
									$( "#centeralDiv" ).show();
									$( "#scheduleInterview" ).hide();
									findAllCandidates();
					 			  $window.location.href = '/index';
					 			  
	                			});
						
						}      
	   
					//finding all users
					function findAllCandidates()
	               	 {
						//alert("in contr;");
	               		registerService.findAllCandidates()
              	        .then(function(data) 
              	        {
              	        	//alert("in controller success function"+d);
              	        	JSON.stringify(data);
              	        	//console.log(data);
              	  	        $scope.listOfCandidates = data.data;
              	  	        /*alert("cv value is "+data.cv+" "+data.data.cv);*/
              	  	        
              	  	    angular.forEach( $scope.listOfCandidates, function(value, key)
		              	  	    		{
		              	  	    		console.log("value "+value);
		              	  	    		//for checking cv
		              	  	    			var str=value.cv;
		              	  	    		//function to get status of candidate	
		              	  	    			registerService.getScheduleStatusOfCandidate(value.candidate_id)
				                      	        .then(function(data) 
				                      	        {
				                      	        	
				                      	        	 value.scheduledStatus = data.data;
				                      	        	
				                      	  	         console.log("in controller final status is :"+value.scheduledStatus);
				                      	  	                      	  	        
				                      	         });
		              	  	    	
		              	  	    				/*console.log("check this : "+value.scheduledStatus);*/
		              	  	    	
		              	  	    		});
              	  	        
              	         });
	               	 }
					
					
					//finding all departments
					function getDepartList()
	               	 {
						//alert("in getDepartList;");
	               		registerService.getDepartList()
              	        .then(function(data) 
              	        {
              	        	//alert("in getDepartList success function"+data);
              	        	JSON.stringify(data);
              	        	//console.log(data);
              	  	        $scope.deprtList = data.data;
              	  	   
              	  	                      	  	        
              	         });
	               	 }
	               	 
	               //finding all users
						function getTechList()
		               	 {
							//alert("in getTechList;");
		               		registerService.getTechList()
	              	        .then(function(data) 
	              	        {
	              	        	//alert("in getTechList success function"+data);
	              	        	JSON.stringify(data);
	              	        	//console.log(data);
	              	  	        $scope.techList = data.data;
	              	  	    $scope.candidate.technology = $scope.techList[0];        
	              	  	                      	  	        
	              	         });
		               	 }
					
					//delete functionality
					$scope.deleteApplicant=function(id)
					{
						registerService.deleteApplicant(id)
						.then(function(response)
								{
							//	alert("Deleted");
							findAllCandidates();
								});
					}
					
					//view of single user
					$scope.getApplicantById=function(id)
					{
						/*if(cv == null)
						{
							alert("Enter Cv First");
						}
						else
						{*/
						
						registerService.getApplicantById(id,cv)
						.then(function(d)
								{
								//alert("in update success"+d);
									console.log("in getCandidate "+d);
									
									//code for assigning candidate value to dropdoen
									$scope.getCandidate=d.data;
									registerService.getTechList()
			              	        .then(function(data) 
			              	        {
			              	       
			              	  	        $scope.techList = data.data;
			              	  	  
			              	  	    angular.forEach($scope.techList, function(item, index) 
			              	  	    		
			              	  	    	{
			              	  	    	
										if($scope.getCandidate.technology.technology==item.technology)
										{
											
											$scope.getCandidate.technology=$scope.techList[index];
										}
										});
			              	  	                      	  	        
			              	         });
									
									
									
									
									$( "#check" ).show();
									$( "#centeralDiv" ).hide();
									
								});
						/*}*/}
					
					
					//update
	               	 $scope.updateCandidate=function()
	               	 {
	               		 //alert("in update function"+$scope.updateCandidates);
	               		registerService.updateCandidate($scope.getCandidate)
               	        .then(function(d) 
               	        {
               	        	alert("Updated Candidate successfully");
               	        	findAllCandidates();
               	        	$( "#check" ).hide();
							$( "#centeralDiv" ).show();
							$( "#scheduleInterview" ).hide();
               	        	
               	         });
	               	 }
	               	 
	               	 //scheduleInterview(user.candidate_id)
	               	 $scope.scheduleInterview=function(id,cv)
	               	 {
	               		 if(cv == null)
	               		{
	               			
	               			$('#myModal').modal('show');
	               		 
	               		}
	               		 else{
	               		 //getDetailsOfApplicant
		               		registerService.getApplicantById(id)
							.then(function(d)
							{
									
										 $scope.getCandidate=d.data;
										 registerService.getTechList()
					              	        .then(function(data) 
					              	        {
					              	        
					              	  	        $scope.techList = data.data;
					              	  	        angular.forEach($scope.techList, function(item, index) 
					              	  	    		
					              	  	    	{
								              	  	  if($scope.getCandidate.technology.technology==item.technology)
														{
															
															$scope.getCandidate.technology=$scope.techList[index];
														}
												});
					              	  	                      	  	        
					              	         });
										 		//console.log($scope.getCandidate.technology.technology);
										  		tech=$scope.getCandidate.technology.technology;
										  			// alert("tech is "+tech);
										  		registerService.findTlWithTech(tech)
										  		.then(function(d)
												 {	
										  			//console.log(d);
										  			$scope.listOfTl=d.data;
										  			//console.log($scope.listOfTl);
												 });
										
										  		$( "#check" ).hide();
										  		$( "#centeralDiv" ).hide();
										  		$( "#scheduleInterview" ).show();	
										
							});
		               		
		               	 
	               		 }}
	               	 
	               	 
	               	 //sendEmailDetails()
	               	$scope.sendEmailDetails=function()
	               	{
	               		
	               		
	               		//alert($scope.scheduleCandidate.date);
	               		registerService.sendEmailDetails($scope.scheduleCandidate,$scope.getCandidate,$scope.tl,$scope.interviewRound)
				 		   .then(function(response)
             			{
				 			// alert("Email sent successfully");
				 			findAllCandidates();
				 			 $( "#check" ).hide();
								$( "#centeralDiv" ).show();
								$( "#scheduleInterview" ).hide();
             			});
	               		
	               	}
					   	
					
			}]);
			
	
		
	//service module of js
	app.factory('registerService',['$http','$q','$location',function($http,$q,$location)
	       {
	               // alert("in service");                           
	               var urlBase='http://localhost:8080';
	               var test='test';
	               var candidate={};
	               var tech={};
	               
	               var scheduleCandidate={};
	               var updateCandidates={};
	               var getCandidate={};
	               var tl={};
	               var interviewRound={};
	               $http.defaults.headers.post["Content-Type"] = "application/json";
	               var factory = 
	               {
	            		   addCandidate:addCandidate,
	            		   findAllCandidates:findAllCandidates,
	            		   deleteApplicant: deleteApplicant,
	            		   getApplicantById:getApplicantById,
	            		   updateCandidate:updateCandidate,
	            		   getTechList:getTechList,
	            		   getDepartList:getDepartList,
	            		   findTlWithTech:findTlWithTech,
	            		   sendEmailDetails:sendEmailDetails,
	            		   getScheduleStatusOfCandidate:getScheduleStatusOfCandidate
	               };
	               return factory;
	                
	              
	                
	                //add candidate
	                function addCandidate(candidate) 
               	  	{ 
	                	var deferred = $q.defer();
	                	
	                	$http.post(urlBase+'/addCandidate',candidate)
	                	
	                		 .then(function(response)
	                		  {
	                			     JSON.stringify(response);
	                				 //alert("added successfully");
	                				 deferred.resolve(response);
	                			
	                		  },
	               	          function(errResponse)
	               	          {
	               	            	
	               	                console.error('Error while fetching Users');
	               	                deferred.reject(errResponse);
	               	           });
	                	 return  deferred.promise;
	                	
               	  	}
	                //get list of all Users
	                 function findAllCandidates() 
	                 {                       		
	                	// alert("implementations of findAllCandidates in service");
	                     var deferred = $q.defer();
	                     $http.get(urlBase+'/listOfCandidates')
	                          .then(function (response) 
	                           {
	                        	 //alert("in success"+response);
	                              //console.log(response);
	                              deferred.resolve(response);
	                            },
	                            function(errResponse)
	                            {
	                            	
	                                console.error('Error while fetching Users');
	                                deferred.reject(errResponse);
	                             });
	                     
	                               return deferred.promise;
	                   }
	                 
	                 //get list of all Depart List
	                 function getDepartList() 
	                 {                       		
	                	//alert("implementations of getDepartList in service");
	                     var deferred = $q.defer();
	                     $http.get(urlBase+'/getDepartList')
	                          .then(function (response) 
	                           {
	                        	 deferred.resolve(response);
	                            },
	                            function(errResponse)
	                            {
	                            	//alert("in error");
	                                console.error('Error while fetching getDepartList');
	                                deferred.reject(errResponse);
	                             });
	                     
	                               return deferred.promise;
	                   }
	                 //get list of all Tech list
	                 function getTechList() 
	                 {                       		
	                	// alert("implementations of getTechList in service");
	                     var deferred = $q.defer();
	                     $http.get(urlBase+'/getTechList')
	                          .then(function (response) 
	                           {
	                        	 deferred.resolve(response);
	                            },
	                            function(errResponse)
	                            {
	                            	
	                                console.error('Error while fetching getDepartList');
	                                deferred.reject(errResponse);
	                             });
	                     
	                               return deferred.promise;
	                   }
	                 
	                 function getScheduleStatusOfCandidate(id)
	                 {
	                	 var deferred = $q.defer();
		                  // alert("in getScheduleStatusOfCandidate id is : "+id);
		                     $http.get(urlBase+'/getScheduleStatusOfCandidate/'+id)
		                          .then(function (response) 
		                           {
		                        	// alert("in success"+response);
		                              console.log(response);
		                              deferred.resolve(response);
		                            },
		                            function(errResponse)
		                            {
		                            	
		                                console.error('Error while getScheduleStatusOfCandidate');
		                                deferred.reject(errResponse);
		                             });
		                     
		                               return deferred.promise;
	                 }
	                 
	                 //get list of all Users
	                 function findTlWithTech(tech) 
	                 {                       		
	                	// alert("implementations of findTlWithTech in service"+tech);
	                     var deferred = $q.defer();
	                   //alert("in service tech is : "+tech);
	                     $http.get(urlBase+'/findTlWithTech/'+tech)
	                          .then(function (response) 
	                           {
	                        	 //alert("in success"+response);
	                              //console.log(response);
	                              deferred.resolve(response);
	                            },
	                            function(errResponse)
	                            {
	                            	//alert("in error");
	                                console.error('Error while findTlWithTech');
	                                deferred.reject(errResponse);
	                             });
	                     
	                               return deferred.promise;
	                   }
	                 
			               //deleting user  
		               	  	 function deleteApplicant(id)
		               	 {
		               		// alert("in delete userservice" +id);
		                       var deferred = $q.defer();
		                       $http.post(urlBase+'/deleteCandidate/'+id)
		                           .then(
		                           function (response)
		                           {
		                        	   findAllCandidates();
		                               deferred.resolve(response);
		                           },
		                           function(errResponse){
		                               console.error('Error while deleting User');
		                               deferred.reject(errResponse);
		                           }
		                       );
		                       return deferred.promise;
		                   }     
		               	  	 
		               	  
		               	  	 //view of Single user
		               	  function getApplicantById(id)
		                	 {
		                		// alert("in delete userservice" +id);
		               		 
		                        var deferred = $q.defer();
		                        $http.post(urlBase+'/getApplicantById/'+id)
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
	                

		               	  	 //updating the user
		               	  	 function updateCandidate(getCandidate)
		                 	 {
		                		//alert("in service updateUser" +getCandidate.candidate_id);
		                        var deferred = $q.defer();
		                       $http.post(urlBase+'/updateCandidateById',getCandidate)
		                          .then(function(response)
		                            {
		                                deferred.resolve(response);
		                           });
		                        return deferred.promise;
		                   }
		               	  	 
		               	  	 //scheduleInterview
		               	  	 
		               	  
		               	  //sendEmailDetails of candidate
		 	                function sendEmailDetails(scheduleCandidate,getCandidate,tl,interviewRound) 
		                	  	{ 
		 	                	var deferred = $q.defer();
		 	                	var data = {
		 	                			date: scheduleCandidate.date,
		 	                			getCandidate: getCandidate,
		 	                			tl: tl.tlID
		 	                			};
		 	                	var Indata = {tl:'tl.tlID',getCandidate:'getCandidate',date:'date'}
		 	                	//alert(data);
		 	                	//alert("in service sendEmailDetails"+scheduleCandidate.date +getCandidate.cv +tl.tlID);
		 	                	$http.post(urlBase+'/sendEmailDetails/'+tl.tlID+'/'+scheduleCandidate.date+'/'+interviewRound,getCandidate)
		 	                	
		 	                		 .then(function(response)
		 	                		  {
		 	                			     JSON.stringify(response);
		 	                				// alert("added successfully");
		 	                				 deferred.resolve(response);
		 	                			
		 	                		  },
		 	               	          function(errResponse)
		 	               	          {
		 	               	            	
		 	               	               // console.error('Error while fetching Users');
		 	               	                deferred.reject(errResponse);
		 	               	           });
		 	                	 return  deferred.promise;
		 	                	
		                	  	}
	                                                	 
               	  
	                 }]);
