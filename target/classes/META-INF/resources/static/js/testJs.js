// Declare app level module which depends on filters, and services
var app = angular.module('myApp', []);

function RegisterCtrl($scope,$location,$http,$window)
{
	
	 /*$scope.educationDetail.certifications = 'false'; 
	 alert("educationDetail.certifications" +$scope.educationDetail.certifications);*/
		$scope.candidate={};
		$scope.application={};
		/*$scope.user={};*/
		$scope.employmentDetails = [];
		$scope.educationDetails = [];
		$scope.hrNames=[];
		getHrList();
	
	var urlBase='http://localhost:8080';
	
	
	/*------get all hrNames-------*/
	function getHrList()
	 {
	alert("in getHrList;");
	 $http.get('http://localhost:8080/getHrList')
   .then(function(response)
     {
         console.log("in success"+response);
         $scope.hrNames=response.data;
       /*  console.log($scope.hrNames);*/
         
    });
	 }

	

  $scope.steps = [
    'Step 1: Application Info',
    'Step 2: Personal Details',
    'Step 3: Educational Details',
    'Step 4: Employment Details'
    
  ];
  /*----------------------saveCandidateDetails()------------*/
  
      $scope.addNew = function(){
            $scope.educationDetails.push({ 
                'educationDegree': "", 
                'year_of_passing': "",
                'fullOrPartTime': "",
                'percentageOrClass':"",
                'boardOrUniversity':"",
                'certifications':""
            });
           
        };

        $scope.addNewEmploy = function(employmentDetail){
            $scope.employmentDetails.push({ 
                'cmp_name': "", 
                'from_date': "",
                'to_date': "",
                'designation':"",
                'last_salary_drawn':"",
                'reason_of_leaving':""
            });
        };
    
    
        
        $scope.remove = function(){
            var newDataList=[];
            $scope.selectedAll = false;
            angular.forEach($scope.educationDetails, function(selected){
                if(!selected.selected){
                    newDataList.push(selected);
                }
            }); 
            $scope.educationDetails = newDataList;
        };
    
    $scope.checkAll = function () {
        if (!$scope.selectedAll) {
            $scope.selectedAll = true;
        } else {
            $scope.selectedAll = false;
        }
        angular.forEach($scope.educationDetails, function(educationDetail) {
        	educationDetail.selected = $scope.selectedAll;
        });
    };    
    
    $scope.saveCandidateDetails=function()
    {
    	/*angular.forEach($scope.educationDetails, function(key, value) 
   			 {
    			console.log(key.certifications);
    			//console.log(value.certifications);
        	  			
        	     });*/
/*    	console.log("application value is: "+$scope.application.user.name);*/
    	angular.forEach($scope.hrNames, function(key, value) 
      			 {
    					/*console.log("check.. "+$scope.application.user.name);
           	  			console.log("hrNames "+$scope.hrNames[key] +key.name+" "+$scope.hrNames[value]+value.name);
           	  		*/if($scope.application.user.name==key.name)
					{
					/*	console.log("in if"+$scope.application.user.name +" "+$scope.hrNames[value]);*/
						$scope.application.user=$scope.hrNames[value];
					}
		
           	     });
    	 
    	 
    	
    	 $scope.candidate.applicationDetails= $scope.application;
    	
    	 var dataObj = {
    			 candidate : $scope.candidate,
    			
    			 educational_Details : $scope.educationDetails,
    			 employment_Details:$scope.employmentDetails
 				
 		};
    	 
    	 $http.post(urlBase+'/saveCandidate',dataObj)
         .then(function(response)
           {
               console.log("in success");
               $window.location.href = '/';
          });
    }


/*-----------Adding row to employmentDetails table-----------*/ 
//app.controller("employmentController", ['$scope', function($scope) {
    
    
        $scope.remove = function(){
            var newDataList=[];
            $scope.selectedAll = false;
            angular.forEach($scope.employmentDetails, function(selected){
                if(!selected.selected)
                {
                    newDataList.push(selected);
                }
            }); 
            $scope.employmentDetails = newDataList;
        };
    
    $scope.checkAll = function () {
        if (!$scope.selectedAll) {
            $scope.selectedAll = true;
        } else {
            $scope.selectedAll = false;
        }
        angular.forEach($scope.employmentDetails, function(employmentDetail) {
        	employmentDetail.selected = $scope.selectedAll;
        });
    };    
    /*--------------------------Pagination----------------------------*/
    $scope.selection = $scope.steps[0];

    $scope.getCurrentStepIndex = function(){
      // Get the index of the current step given selection
      return _.indexOf($scope.steps, $scope.selection);
    };

    // Go to a defined step index
    $scope.goToStep = function(index) {
      if ( !_.isUndefined($scope.steps[index]) )
      {
        $scope.selection = $scope.steps[index];
      }
    };

    $scope.hasNextStep = function(){
      var stepIndex = $scope.getCurrentStepIndex();
      var nextStep = stepIndex + 1;
      // Return true if there is a next step, false if not
      return !_.isUndefined($scope.steps[nextStep]);
    };

    $scope.hasPreviousStep = function(){
      var stepIndex = $scope.getCurrentStepIndex();
      var previousStep = stepIndex - 1;
      // Return true if there is a next step, false if not
      return !_.isUndefined($scope.steps[previousStep]);
    };

    $scope.incrementStep = function() {
      if ( $scope.hasNextStep() )
      {
        var stepIndex = $scope.getCurrentStepIndex();
        var nextStep = stepIndex + 1;
        $scope.selection = $scope.steps[nextStep];
      }
    };

    $scope.decrementStep = function() {
      if ( $scope.hasPreviousStep() )
      {
        var stepIndex = $scope.getCurrentStepIndex();
        var previousStep = stepIndex - 1;
        $scope.selection = $scope.steps[previousStep];
      }
    };

   
} 

//}]);
