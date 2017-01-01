/**
 * 
 */

var sampleApp = angular.module("sampleApp",['firebase','F1FeederApp.services','ngRoute']);

sampleApp.factory('userinfo',[function(){
	var userInfo;
	return {
		getUserInfo : function(){
			return userInfo;
		},
		setUserInfo : function(user){
			userInfo = user;
		}
	};
}]);

sampleApp.config(['$routeProvider',
                  function($routeProvider) {
	$routeProvider.
	when('/home', {
		templateUrl: 'templates/home.html',
		controller: 'HomeController',
		secure: true
	}).
	when('/login', {
		templateUrl: 'templates/firebaseLogin.html',
		controller: 'LoginController'
	}).
	when('/Signup', {
		templateUrl: 'templates/signup.html',
		controller: 'SignUpController'
	}).
	when('/ShowOrders', {
		templateUrl: 'templates/show_orders.html',
		controller: 'ShowOrdersController',
		secure: true
	}).when('/AddMessageOrder', {
		templateUrl: 'templates/add_message.html',
		controller: 'addMessageController',
		secure: true
	}).when('/EditMessage',{
		templateUrl:'templates/edit_message.html',
		controller:'EditController',
		secure: true
	});
}]);
sampleApp.controller('HomeController', ['$location','userinfo',function($location,userinfo) {
	var self  = this;
	
	self.message = 'This is Add new order screen';
	self.userInfo = userinfo.getUserInfo();
	self.logout = function (){
		firebase.auth().signOut().then(function() {
			console.log("Logout Sucessful");
			$location.path( "/#" );
		}, function(error) {
			console.log("Logout Error");
		});
	};

}]);
sampleApp.controller('BaseController', ['$location','userinfo',function($location,userinfo) {
	var self  = this;
	
	self.message = 'This is Add new order screen';
	self.userInfo = userinfo.getUserInfo();
	self.logout = function (){
		firebase.auth().signOut().then(function() {
			console.log("Logout Sucessful");
			$location.path( "/#" );
		}, function(error) {
			console.log("Logout Error");
		});
	};

}]);


sampleApp.controller('SignUpController',['$scope',function($scope){
	$scope.register = function (){
		firebase.auth().createUserWithEmailAndPassword($scope.user.registrationEmail, $scope.user.registrationPassword).then(function (user){
			console.log("User Signed in successfully and Logged In")
		}, function (error){
			authCtrl.error = error;
		});	
	};
}]);
sampleApp.controller('LoginController', ['$scope','$location', 'userinfo', function($scope,$location,userinfo){

	var self = this;
	self.login = function (){
		console.log("Current User before :" + firebase.auth().currentUser)
		firebase.auth().signInWithEmailAndPassword(self.user.loginEmail, self.user.loginPassword).then(function (auth){
			console.log("Login Successful");
			console.log(auth);
			console.log("Current User :" + firebase.auth().currentUser);
			var userInfo = {
					email:""
			};
			
			userInfo.email= auth.email; 
			userinfo.setUserInfo(userInfo);
			$scope.$apply(function() { $location.path("/home"); });
		}, function (error){
			self.error = error;
			console.log(error);
		});
	};

	self.logout = function (){
		firebase.auth().signOut().then(function() {
			console.log("Logout Sucessful");
			$scope.$apply(function() { $location.path("/#"); });
		}, function(error) {
			console.log("Logout Error");
		});
	};



	self.register = function (){
		firebase.auth().createUserWithEmailAndPassword(self.user.loginEmail, self.user.loginPassword).then(function (user){
			console.log("User Signed in successfully and Logged In")
		}, function (error){
			self.error = error;
		});	
	};
	self.twittersignIn= function(){
		var provider = new firebase.auth.TwitterAuthProvider();
		firebase.auth().signInWithPopup(provider).then(function(result) {
			console.log("Login Successful with Twitter");
			var token = result.credential.accessToken;
			var user = result.user;
			console.log(user);
			$location.path( "/home" );
		},function(error){
			console.log(error);
		});
	};
	self.facebooksignIn= function(){
		var provider = new firebase.auth.FacebookAuthProvider();
		firebase.auth().signInWithPopup(provider).then(function(result) {
			console.log("Login Successful with facebook");
			var token = result.credential.accessToken;
			var user = result.user;
			console.log(user);
		},function(error){
			console.log(error);
			var errorCode = error.code;
			var errorMessage = error.message;
			console.log(errorMessage);
			// The email of the user's account used.
			var email = error.email;
			// The firebase.auth.AuthCredential type that was used.
			var credential = error.credential;
		});
	};
	self.open = function() {
		$scope.showModal = true;
	};

	self.ok = function() {
		$scope.showModal = false;
	};

	self.cancel = function() {
		$scope.showModal = false;
	};
}]);

sampleApp.controller('ShowOrdersController', ['$scope' , 'ergastAPIservice' , function($scope,ergastAPIservice) {

	$scope.msg = 'This is Show orders screen';
	$scope.orders = [];	
	ergastAPIservice.getDrivers().success(function (response) {
		console.log(response);
		$scope.orders = response.messages;
	}).error(function (response) {
		console.log(response);
	});
}]);

sampleApp.controller('EditController', ['$scope','ergastAPIservice',function($scope,ergastAPIservice) {

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
}]);


sampleApp.controller('addMessageController', ['$scope','ergastAPIservice',function($scope,ergastAPIservice) {

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
}]);

sampleApp.run(['$rootScope', '$location',
               function ($rootScope, $location) {
	
	//Client-side security. Server-side framework MUST add it's 
	//own security as well since client-based security is easily hacked
	$rootScope.$on("$routeChangeStart", function (event, next, current) {
		if (next && next.$$route && next.$$route.secure) {
			firebase.auth().onAuthStateChanged(function(user) {
				if (user) {
					console.log("user is logged in already");
					console.log("User Details : "+user);
					$rootScope.userloggedIn=true;
					$rootScope.email = user.email;
				} else {
					if (next.templateUrl == "templates/login.html") {
						// already going to the login route, no redirect needed
						$rootScope.userloggedIn=false;
						$rootScope.$apply();
					} else {
						// not going to the login route, we should redirect now
						$location.path("/login");
						$rootScope.userloggedIn=false;
						$rootScope.$apply();
					}
				}
			});
		}
	});

}]);