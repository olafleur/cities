var citiesApp = angular.module("citiesApp", []);
citiesApp.controller("CitiesCtrl", function ($scope, $http) {
    $scope.changed = function (city) {
        if (city.length >= 3) {
            $http.get('/suggestions?q=' + city)
                .then(function (response) {
                    $scope.cities = response.data;
                });
        } else {
            $scope.cities = [];
        }
    }
});
