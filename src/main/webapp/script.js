var citiesApp = angular.module("citiesApp", []);
citiesApp.controller("CitiesCtrl", function($scope, $http) {
    $scope.name = "Calvin Hobbes";

    $scope.changed = function (city) {
        if(city.length >= 3) {
            $http({
                method: 'GET',
                url: '/suggestions?q='+city
            }).then(function successCallback(response) {
                console.log("yé");
            }, function errorCallback(response) {
                console.log("nope");
            })
        }
    }
});
