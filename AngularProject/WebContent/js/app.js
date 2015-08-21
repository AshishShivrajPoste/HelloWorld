/**
 * 
 */

var sampleApp = angular.module("sampleApp",['F1FeederApp.services']);

sampleApp.config(['$routeProvider',
                  function($routeProvider) {
	$routeProvider.
	when('/home', {
		templateUrl: 'templates/home.html',
		controller: 'HomeController'
	}).
	when('/login', {
		templateUrl: 'templates/login.html',
		controller: 'LoginController'
	}).
	when('/ShowOrders', {
		templateUrl: 'templates/show_orders.html',
		controller: 'ShowOrdersController'
	}).when('/AddMessageOrder', {
		templateUrl: 'templates/add_message.html',
		controller: 'addMessageController'
	}).when('/EditMessage',{
		templateUrl:'templates/edit_message.html',
		controller:'EditController'
	});
}]);
sampleApp.controller('HomeController', function($scope) {

	$scope.message = 'This is Add new order screen';

});
sampleApp.controller('LoginController', function($scope) {
	
	$scope.loginUser=function()
    {
        var username=$scope.user.name;
        var password=$scope.user.password;
        if(username=="admin" && password=="admin123")
        {
            page.setUser($scope.user);
            $location.path( "/home" );
        }
        else
        {
            $scope.message="Error";
            $scope.messagecolor="alert alert-danger";
        }
    }

});

sampleApp.controller('ShowOrdersController', function($scope,ergastAPIservice) {
	
	$scope.msg = 'This is Show orders screen';
	$scope.orders = [];	
	ergastAPIservice.getDrivers().success(function (response) {
		console.log(response);
        $scope.orders = response.messages;
    }).error(function (response) {
		console.log(response);
    });
});

sampleApp.controller('EditController', function($scope,ergastAPIservice) {

	$scope.deleteMessage = function(messageID) {
		//$scope.orders.push({ 'author':$scope.message.author, 'message': $scope.message.mseg });
		console.log("Ashish");
		var res = ergastAPIservice.deleteMessage(messageID);
		res.success(function(data, status, headers, config) {
			//console.log(data);
//			$scope.message = data;
			//$scope.orders.push(data);
		});
		res.error(function(data, status, headers, config) {
			console.log("failed");
			//alert( "failure message: " + JSON.stringify({data: data}));
		});		  
    }
	$scope.editPerson = function(message){
		console.log("Edit");
		console.log(message);
		var result = ergastAPIservice.editMessage(message);
		result.success(function(data, status, headers, config) {
		//	console.log(response);
		   // $scope.orders = response.messages;
		});
		result.error(function(data, status, headers, config) {
			console.log(response);
		});	
	}
});


sampleApp.controller('addMessageController', function($scope,ergastAPIservice) {
	
	$scope.add = function(message) {
		//$scope.orders.push({ 'author':$scope.message.author, 'message': $scope.message.mseg });
		
		//console.log($scope.message.author);
		//console.log($scope.message.author);
		var dataObj = {
				author : $scope.message.author,
				msg :$scope.message.mseg
		};
		var res = ergastAPIservice.addMessages(dataObj);
		res.success(function(data, status, headers, config) {
			console.log(data);
			$scope.message = data;
			$scope.orders.push(data);
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});		
		// Making the fields empty
		//
		$scope.message.author='';
		$scope.message.mseg='';
        
        
        
    }
	
	$scope.deleteMessage = function(messageID) {
		//$scope.orders.push({ 'author':$scope.message.author, 'message': $scope.message.mseg });
		console.log("Ashish");
		//console.log($scope.message.author);
		//console.log($scope.message.author);
		var dataObj = {
				author : $scope.message.author,
				message :$scope.message.mseg
		};
		var res = ergastAPIservice.addMessages(messageID);
		res.success(function(data, status, headers, config) {
			//console.log(data);
//			$scope.message = data;
			$scope.orders.push(data);
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});		
		// Making the fields empty
		//
		$scope.message.author='';
		$scope.message.mseg='';   
    }
});