var module = angular.module("util", [ 'ui.bootstrap' ]);

module.controller("datepickerController", function($scope) {
    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };

    $scope.dateOptions = {
        startingDay : 1,
        showWeeks : false
    };

    $scope.datepickerConfig = {
        format : "dd/MM/yyyy"
    }

    $scope.format = "dd/MM/yyyy";
});

// http://adamalbrecht.github.io/ngQuickDate/
// https://github.com/adamalbrecht/ngQuickDate
module.controller("timepickerController", function($scope) {
    $scope.open = function($event) {
        // alert("Open");

        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };

    $scope.timepickerConfig = {
        showMeridian : false
    };
});
