angular.module("crud_service", [])

.factory("CrudService", CrudService)

;

function CrudService($http, $q, $location) {
    function Crud() {
        var _uri;

        function setUri(uri) {
            _uri = uri;
        }

        function getUri() {
            return _uri;
        }

        function index() {
            // console.log('index');

            return $http.post(_uri + "-index.action")
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Index failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function list(searchCriteria) {
            // console.log('list');

            return $http.post(_uri + "-list.action", {model: searchCriteria})
                .then(success)
                .catch(fail);

            function success(response) {
                $location.search({
                    searchCriteria : JSON.stringify(searchCriteria)
                }).replace();

                return response.data;
            }

            function fail(error) {
                var msg = 'List failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function listPage(searchCriteria, page, limit) {
            // console.log('list page');

            return $http.post(_uri + "-list.action", {model: searchCriteria, page: page, limit: limit})
                .then(success)
                .catch(fail);

            function success(response) {
                $location.search({
                    page : page,
                    limit : limit,
                    searchCriteria : JSON.stringify(searchCriteria)
                }).replace();

                return response.data;
            }

            function fail(error) {
                var msg = 'List Page failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function typeahead(searchCriteria) {
            // console.log('typeahead');

            return $http.post(_uri + "-typeahead.action", {model: searchCriteria})
                .then(success)
                .catch(fail);

            function success(response) {
                return response.data;
            }

            function fail(error) {
                var msg = 'Typeahead failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function xlsExport(searchCriteria, filename) {
            // console.log('xls export');

            return $http.post(_uri + "-xls-export.action", {criterio: searchCriteria}, {
                responseType : 'arraybuffer'
            })
                .then(success)
                .catch(fail);

            function success(response) {
                var file = new Blob([ response.data ], {
                    type : 'application/xls'
                });

                setTimeout(function() {
                    saveAs(file, filename  + '.xls');
                }, 0);

                return response.data;
            }

            function fail(error) {
                var msg = 'Xls Export failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function filter(searchCriteria) {
            // console.log('filter');

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
            // console.log('detail');

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

        function pdfExport(id, filename) {
            // console.log('Pdf export');

            return $http.post(_uri + "-pdf-export.action", {model: id}, {
                responseType : 'arraybuffer'
            })
                .then(success)
                .catch(fail);

            function success(response) {
                var file = new Blob([ response.data ], {
                    type : 'application/pdf'
                });

                setTimeout(function() {
                    saveAs(file, filename  + '.pdf');
                }, 0);

                return response.data;
            }

            function fail(error) {
                var msg = 'Pdf export failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function fileExport(id, filename) {
            // console.log('File export');

            return $http.post(_uri + "-file-export.action", {model: id}, {
                responseType : 'arraybuffer'
            })
                .then(success)
                .catch(fail);

            function success(response) {
                var file = new Blob([ response.data ]);

                setTimeout(function() {
                    saveAs(file, filename);
                }, 0);

                return response.data;
            }

            function fail(error) {
                var msg = 'File export failed. ' + error.data;
                console.log(msg);

                return $q.reject(msg);
            }
        }

        function remove(item) {
            // console.log('remove');

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
            // console.log('edit');

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
            // console.log('save');

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
            // console.log('save i18n');

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
/*
 * function redirectAfterSave(accion, item, detailStateName) { accion == 'edit' ?
 * setTimeout(function() { window.history.back(); }, 0) :
 * $state.go(detailStateName, item, { location : 'replace' }); }
 */

        function redirectAfterSave(accion, url, urlParams) {
            if (urlParams) {
                for (i=0; i<urlParams.length; i++) {
                    url += '/' + urlParams[i];
                }
            }

            //alert(url);

            accion == 'edit' ? setTimeout(function() {
                window.history.back();
            }, 0) : $location.path(url).replace();
        }

        function tabSelected(tab) {
            $location.search('tab', tab).replace();
        }

        function pageMapChanged(pageMap) {
            $location.search('pageMap', JSON.stringify(pageMap)).replace();
        }

        return {
            index: index
            , listPage: listPage
            , list: list
            , typeahead: typeahead
            , xlsExport: xlsExport
            , filter: filter
            , detail: detail
            , pdfExport: pdfExport
            , fileExport: fileExport
            , remove: remove
            , edit: edit
            , save: save
            , saveI18n: saveI18n
            , redirectAfterSave: redirectAfterSave
            , tabSelected: tabSelected
            , pageMapChanged: pageMapChanged
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