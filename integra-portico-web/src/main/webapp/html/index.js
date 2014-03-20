var app = angular.module('portico', []);

app.factory('Tpprs', function() {
	var Tpprs = [
		  {value: 1, label: "Nombre 1"}
		, {value: 2, label: "Nombre 2"}
		, {value: 3, label: "Nombre 3"}
		, {value: 4, label: "Nombre 4"}
		, {value: 5, label: "Nombre 5"}
		, {value: 6, label: "Nombre 6"}
		, {value: 7, label: "Nombre 7"}
		, {value: 8, label: "Nombre 8"}
		, {value: 9, label: "Nombre 9"}
		, {value: 0, label: "Nombre 0"}
		, {value: 0, label: "aa"}
		, {value: 0, label: "ab"}
	];

	return Tpprs;
});

function tpprsCtrl($scope, Tpprs) {
	$scope.tpprs = Tpprs;
}

function ctrl1($scope) {

}

function ctrl2($scope) {
	
}

