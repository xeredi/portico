angular.module("util", [ 'ui.bootstrap' ])

.factory("pagetitleService", pagetitleService)

.controller("datepickerController", datepickerController)

.controller("timepickerController", timepickerController);

function datepickerController($scope) {
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
}

// http://adamalbrecht.github.io/ngQuickDate/
// https://github.com/adamalbrecht/ngQuickDate
function timepickerController($scope) {
    $scope.open = function($event) {
        // alert("Open");

        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };

    $scope.timepickerConfig = {
        showMeridian : false
    };
}

function pagetitleService($rootScope, $translate) {
    var setTitle = function () {
        alert('setTitle');
    }

    return function(titleKey) {
        alert('setTitle 2');

        $rootScope.title = titleKey;
    }
}

