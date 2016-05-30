var citiesApp = angular.module("citiesApp", []);
citiesApp.controller("CitiesCtrl", function ($scope, $http) {
    $scope.changed = function (city) {
        if (city.length >= 3) {
            $http.get('/suggestions?q=' + city)
                .then(function (response) {
                    $scope.cities = response.data;
                }, function () {
                    $scope.cities = [];
                });
        } else {
            $scope.cities = [];
        }
    };

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position){
            $scope.$apply(function() {
                $scope.latitude = position.coords.latitude;
                $scope.longitude = position.coords.longitude;
            });
        });
    }
});
