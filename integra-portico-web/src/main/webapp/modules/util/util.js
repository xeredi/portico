angular.module("util", [ 'ui.bootstrap' ])

.factory('pageTitleService', pageTitleService)

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

function pageTitleService($rootScope, $translate) {
    return {
        setTitleEnti : setTitleEnti,
        setTitle : setTitle
    };

    function setTitle(prefix, title) {
        $translate([ prefix, title ]).then(function(translations) {
            $rootScope.title = translations[prefix] + ": " + translations[title];
        });
    }

    function setTitleEnti(entiId, title) {
        $translate([ 'enti_' + entiId, title ]).then(function(translations) {
            $rootScope.title = translations['enti_' + entiId] + ": " + translations[title];
        });
    }
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

