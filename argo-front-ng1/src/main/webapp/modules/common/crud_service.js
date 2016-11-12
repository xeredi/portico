(function() {
    'use strict';

    angular.module("crud_service", [])

    .factory("CrudService", CrudService)

    ;

    /* @ngInject */
    function CrudService($http, $q, $location, Upload, FileSaver) {
        function Crud() {
            var _uri;
            var _prefix;

            function setUri(uri) {
                _uri = uri;
            }

            function getUri() {
                return _uri;
            }

            function setPrefix(prefix) {
                _prefix = prefix;
            }

            function getPrefix() {
                return _prefix;
            }

            function index() {
                // console.log('index');

                return $http.post(_uri + "-index.action").then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Index failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function list(searchCriteria) {
                // console.log('list');

                return $http.post(_uri + "-list.action", {
                    model : searchCriteria,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    $location.search({
                        searchCriteria : JSON.stringify(searchCriteria)
                    }).replace();

                    return response.data;
                }

                function fail(error) {
                    var msg = 'List failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function listPage(searchCriteria, page, limit) {
                // console.log('list page');

                return $http.post(_uri + "-list.action", {
                    model : searchCriteria,
                    page : page,
                    limit : limit,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    $location.search({
                        page : page,
                        limit : limit,
                        searchCriteria : JSON.stringify(searchCriteria)
                    }).replace();

                    return response.data;
                }

                function fail(error) {
                    var msg = 'List Page failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function typeahead(searchCriteria) {
                return $http.post(_uri + "-typeahead.action", {
                    model : searchCriteria,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Typeahead failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function xlsExport(searchCriteria, filename) {
                // console.log('xls export');

                return $http.post(_uri + "-xls-export.action", {
                    criterio : searchCriteria,
                    prefix : _prefix
                }, {
                    responseType : 'arraybuffer'
                }).then(success, fail);

                function success(response) {
                    var file = new Blob([ response.data ], {
                        type : 'application/xls'
                    });

                    setTimeout(function() {
                        FileSaver.saveAs(file, filename + '.xls');
                    }, 0);

                    return response.data;
                }

                function fail(error) {
                    var msg = 'Xls Export failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function filter(searchCriteria) {
                // console.log('filter');

                return $http.post(_uri + "-filter.action", {
                    model : searchCriteria,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Filter failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function detail(id) {
                // console.log('detail');

                return $http.post(_uri + "-detail.action", {
                    model : id,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Detail failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function pdfExport(id, filename) {
                // console.log('Pdf export');

                return $http.post(_uri + "-pdf-export.action", {
                    model : id,
                    prefix : _prefix
                }, {
                    responseType : 'arraybuffer'
                }).then(success, fail);

                function success(response) {
                    var file = new Blob([ response.data ], {
                        type : 'application/pdf'
                    });

                    setTimeout(function() {
                        FileSaver.saveAs(file, filename + '.pdf');
                    }, 0);

                    return response.data;
                }

                function fail(error) {
                    var msg = 'Pdf export failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function fileExport(id, filename) {
                // console.log('File export');

                return $http.post(_uri + "-file-export.action", {
                    model : id,
                    prefix : _prefix
                }, {
                    responseType : 'arraybuffer'
                }).then(success, fail);

                function success(response) {
                    var file = new Blob([ response.data ]);

                    setTimeout(function() {
                        FileSaver.saveAs(file, filename);
                    }, 0);

                    return response.data;
                }

                function fail(error) {
                    var msg = 'File export failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function remove(item) {
                // console.log('remove');

                if (confirm("Are you sure?")) {
                    return $http.post(_uri + "-remove.action", {
                        model : item,
                        prefix : _prefix
                    }).then(success, fail);
                } else {
                    // FIXME

                    return null;
                }

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Remove failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function edit(accion, id) {
                return $http.post(_uri + "-edit.action", {
                    model : id,
                    accion : accion,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Edit failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function save(accion, item) {
                return $http.post(_uri + "-save.action", {
                    model : item,
                    accion : accion,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Save failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function saveI18n(accion, item, i18nMap) {
                return $http.post(_uri + "-save.action", {
                    model : item,
                    i18nMap : i18nMap,
                    accion : accion,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'Save I18n failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function loadPrepare(item) {
                // console.log('loadPrepare');

                return $http.post(_uri + "-load-prepare.action", {
                    model : item,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'loadPrepare failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function load(item) {
                return $http.post(_uri + "-load.action", {
                    model : item,
                    prefix : _prefix
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'load failed. ' + error;
                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function fileUpload(file) {
                console.log('fileUpload');

                return Upload.upload({
                    url : _uri + "-file-upload.action",
                    data : {
                        uploadedFile : file
                    }
                }).then(success, fail);

                function success(response) {
                    return response.data;
                }

                function fail(error) {
                    var msg = 'fileUpload failed. ' + error;

                    console.log(msg);

                    return $q.reject(msg);
                }
            }

            function redirectAfterSave(accion, url, urlParams) {
                if (urlParams) {
                    var i;

                    for (i in urlParams) {
                        url += '/' + urlParams[i];
                    }
                }

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
                index : index,
                listPage : listPage,
                list : list,
                typeahead : typeahead,
                xlsExport : xlsExport,
                filter : filter,
                detail : detail,
                pdfExport : pdfExport,
                fileExport : fileExport,
                remove : remove,
                edit : edit,
                save : save,
                saveI18n : saveI18n,
                redirectAfterSave : redirectAfterSave,
                loadPrepare : loadPrepare,
                load : load,
                fileUpload : fileUpload,
                tabSelected : tabSelected,
                pageMapChanged : pageMapChanged,
                setUri : setUri,
                getUri : getUri,
                setPrefix : setPrefix,
                getPrefix : getPrefix
            };
        }

        return {
            create : function(uri, prefix) {
                var crud = new Crud();

                crud.setUri(uri);
                crud.setPrefix(prefix);

                return crud;
            }
        };

    }
})();