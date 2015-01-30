angular.module("util", [ 'ui.bootstrap' ])

.factory('pageTitleService', pageTitleService)

.controller("datepickerController", datepickerController)

.controller("datetimeController", datetimeController)

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
    };

    $scope.format = "dd/MM/yyyy";
}

function datetimeController($scope, $filter) {
    $scope.dateTime = new Date();

    console.log('Tras inicialziar: ' + $scope.dateTime);

//    if ($scope.timeValue) {
//        $scope.dateTime.setHours($scope.timeValue.getHours());
//        $scope.dateTime.setMinutes($scope.timeValue.getMinutes());
//        $scope.dateTime.setSeconds(0);
//    }

    $scope.openDate = function($event) {
        // alert('date');

        $event.preventDefault();
        $event.stopPropagation();

        $scope.dateOpened = true;
        $scope.timeOpened = false;
    };

    $scope.openTime = function($event) {
        // alert('time');

        $event.preventDefault();
        $event.stopPropagation();

        $scope.dateOpened = false;
        $scope.timeOpened = true;
    };

    $scope.dateOptions = {
        startingDay : 1,
        showWeeks : false
    };

    $scope.datepickerConfig = {
        format : "dd/MM/yyyy"
    };

    $scope.dateChanged = function() {
        console.log('Date Changed');

        console.log($scope.dateTime);

        $scope.timeValue = null;
//        $scope.dateTime = $scope.dateValue;
    };

    $scope.timeChanged = function() {
        console.log('Time Changed');

        console.log($scope.dateTime);
    };

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
