/**
 * 
 */

var sampleApp = angular.module("sampleApp",['F1FeederApp.services','firebase']);

sampleApp.config(['$routeProvider',
                  function($routeProvider) {
	$routeProvider.
	when('/home', {
		templateUrl: 'templates/home.html',
		controller: 'HomeController'
	}).
	when('/login', {
		templateUrl: 'templates/firebaseLogin.html',
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
/*sampleApp.controller('LoginController', function($scope) {
	
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

});*/
//sampleApp.controller('LoginController', function($scope) {
//	
//	$scope.toggleSignIn = function() {
//	    	if (!firebase.auth().currentUser) {
//	        var provider = new firebase.auth.GoogleAuthProvider();
//	  
//	        provider.addScope('https://www.googleapis.com/auth/plus.login');
//	      
//	        firebase.auth().signInWithPopup(provider).then(function(result) {
//	          var token = result.credential.accessToken;
//	          var user = result.user;
//	          $location.path( "/home" );
//	        })
//	    	} else {
//	    		firebase.auth().signOut();
//	    	}
//	      // [START_EXCLUDE]
//	     // document.getElementById('quickstart-sign-in').disabled = true;
//	      // [END_EXCLUDE]
//	    }
//	    // [END buttoncallback]
//	    /**
//	     * initApp handles setting up UI event listeners and registering Firebase auth listeners:
//	     *  - firebase.auth().onAuthStateChanged: This listener is called when the user is signed in or
//	     *    out, and that is where we update the UI.
//	     */
//	   $scope.initApp=function() {
//	      // Listening for auth state changes.
//	      // [START authstatelistener]
//	      firebase.auth().onAuthStateChanged(function(user) {
//	        if (user) {
//	          // User is signed in.
//	          var displayName = user.displayName;
//	          var email = user.email;
//	          var emailVerified = user.emailVerified;
//	          var photoURL = user.photoURL;
//	          var isAnonymous = user.isAnonymous;
//	          var uid = user.uid;
//	          var providerData = user.providerData;
//	          // [START_EXCLUDE]
//	          document.getElementById('quickstart-sign-in-status').textContent = 'Signed in';
//	          document.getElementById('quickstart-sign-in').textContent = 'Sign out';
//	          document.getElementById('quickstart-account-details').textContent = JSON.stringify(user, null, '  ');
//	          // [END_EXCLUDE]
//	        } else {
//	          // User is signed out.
//	          // [START_EXCLUDE]
//	          document.getElementById('quickstart-sign-in-status').textContent = 'Signed out';
//	          document.getElementById('quickstart-sign-in').textContent = 'Sign in with Google';
//	          document.getElementById('quickstart-account-details').textContent = 'null';
//	          document.getElementById('quickstart-oauthtoken').textContent = 'null';
//	          // [END_EXCLUDE]
//	        }
//	        // [START_EXCLUDE]
//	        document.getElementById('quickstart-sign-in').disabled = false;
//	        // [END_EXCLUDE]
//	      });
//	      // [END authstatelistener]
//	     // document.getElementById('quickstart-sign-in').addEventListener('click', toggleSignIn, false);
//	    }
//
//});

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