angular.module("crud_service", [])

.factory("CrudService", CrudService)

;

function CrudService($http, $q, $state) {
    function Crud() {
        var _uri;

        function setUri(uri) {
            _uri = uri;
        }

        function getUri() {
            return _uri;
        }

        function list(searchCriteria, page, limit) {
            console.log('list');

            return $http.post(_uri + "-list.action", {model: searchCriteria, page: page, limit: limit})
                .then(success)
                .catch(fail);

            function success(response) {
                $state.go('.', {
                    page : page,
                    limit : limit,
                    searchCriteria : JSON.stringify(searchCriteria)
                }, {
                    notify : false,
                    reload : false,
                    location : 'replace',
                    inherit : true
                });

                return response.data;
            }

            function fail(error) {
                var msg = 'List failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function filter(searchCriteria) {
            console.log('filter');

            return $http.post(_uri + "-filter.action", {model: searchCriteria})
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Filter failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function detail(id) {
            console.log('detail');

            return $http.post(_uri + "-detail.action", {model: id})
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Detail failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function remove(item) {
            console.log('remove');

            if (confirm("Are you sure?")) {
                return $http.post(_uri + "-remove.action", {model: item})
                    .then(success)
                    .catch(fail);
            }

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Remove failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function edit(accion, id) {
            console.log('edit');

            return $http.post(_uri + "-edit.action", {model: id, accion : accion})
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Edit failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function save(accion, item) {
            console.log('save');

            return $http.post(_uri + "-save.action", {model: item, accion : accion})
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Save failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function saveI18n(accion, item, i18nMap) {
            console.log('save i18n');

            return $http.post(_uri + "-save.action", {model: item, i18nMap: i18nMap, accion : accion})
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Save I18n failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function tabSelected(tab) {
            console.log('tabSelected');

            $state.go('.', {
                tab : tab
            }, {
                notify : false,
                reload : false,
                location : 'replace',
                inherit : true
            });
        }

        return {
            list: list
            , filter: filter
            , detail: detail
            , remove: remove
            , edit: edit
            , save: save
            , saveI18n: saveI18n
            , tabSelected: tabSelected
            , setUri: setUri
            , getUri: getUri
        };
    }

    return {
        create: function (uri) {
          var crud = new Crud();

          crud.setUri(uri);

          return crud;
      }
    };


}