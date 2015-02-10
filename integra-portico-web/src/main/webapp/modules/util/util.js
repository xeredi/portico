angular.module("util", [])

.factory('pageTitleService', pageTitleService)

;

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
