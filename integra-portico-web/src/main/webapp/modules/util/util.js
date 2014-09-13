var module = angular.module("util", [ 'ui.bootstrap' ]);

module.controller("datepickerController", function($scope) {
    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };

    $scope.dateOptions = {
        startingDay : 1
    };
});