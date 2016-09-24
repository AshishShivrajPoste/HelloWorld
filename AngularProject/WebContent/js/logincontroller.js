/**
 * 
 */

angular.module('sampleApp').factory('FireBaseAuthFactory', [$firebaseAuth ,function($firebaseAuth){
	var authFactory = {};
	var auth = $firebaseAuth();
	authFactory.createUser = function(email,password){
		return auth.$createUser({
			email:email,
			password:password
		})
	};
	authFactory.authUser = function(email,password){
		return auth.$authWithPassword({
			email:email,
			password:password
		})
	}
}]);

angular.module('sampleApp').controller('LoginController', ['FireBaseAuthFactory' , function($scope){
	var self  = this;
	$scope.emailpassLogin = function(){
		var result = FireBaseAuthFactory.authUser(self.user.loginEmail, self.user.loginPassword);
		result.then(function(authData){
			console.log("User Successfully Logged in with uid: ",authData.uid)
		},function(error){
			console.log("Authentication error occured : ",error)
		})
	}
	$scope.emailpassaddUser = function(){
		var result = FireBaseAuthFactory.createUser(self.email, self.pass);
		result.then(function(userData){
			console.log("User Successfully created  with uid: ",userData.uid)
		},function(error){
			console.log(" Error occured : ",error)
		})
	}
	
}]);