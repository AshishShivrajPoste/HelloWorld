/**
 * 
 */
angular.module('F1FeederApp.services', []).
factory('ergastAPIservice', function($http) {

	var ergastAPI = {};

	ergastAPI.getDrivers=function(){
		return $http({
			method: 'GET', 
			url: 'http://localhost:8080/messenger/webapi/messages'
		});
	};
	ergastAPI.addMessages = function(messagedata) {

		return $http.post('http://localhost:8080/messenger/webapi/messages', messagedata);
	};

	ergastAPI.deleteMessage = function(messageID) {
		//  return $http.delete('http://localhost:8080/messenger/webapi/messages/delete' + messagedata.id);
		return $http({
			method: 'DELETE', 
			url: 'http://localhost:8080/messenger/webapi/messages/delete/'+messageID
		});
	};
	ergastAPI.editMessage = function(message) {
		//  return $http.delete('http://localhost:8080/messenger/webapi/messages/delete' + messagedata.id);
		console.log("Hello World");
//		return $http({
//			method: 'PUT', 
//			url: 'http://localhost:8080/messenger/webapi/messages/delete/'+messageID
//		});
		console.log("http://localhost:8080/messenger/webapi/messages/"+message.identifier);
		return $http.put('http://localhost:8080/messenger/webapi/messages/'+message.identifier,message);
	};
	return ergastAPI;
});