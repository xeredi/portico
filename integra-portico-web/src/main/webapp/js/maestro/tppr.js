var app = angular.module('portico', []);

app.controller('tpprsCtrl', function($http){
    //alert('Llamar al servidor');
    var app = this;

    $http.get("http://localhost:8080/web/maestro/tppr-listado-json.action")
        .success(function (data) {
            //console.log(data);
            app.tpprs = data.tpprs;
        });
})
