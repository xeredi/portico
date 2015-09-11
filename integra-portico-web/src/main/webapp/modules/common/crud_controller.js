angular.module("crud_controller", [])

.controller("CrudGridController", CrudGridController)

;

function CrudGridController($http, $location, $routeParams, $modal, baseUri) {
    var vm = this;

    var listUrl = baseUri + "-list.action";
    var filterUrl = baseUri + "-filter.action";

    vm.search = search;
    vm.pageChanged = pageChanged;
    vm.filter = filter;
    vm.resetFilter = resetFilter;

    vm.searchCriteria = $routeParams.searchCriteria ? angular.fromJson($routeParams.searchCriteria) : {};

    vm.search($routeParams.page ? $routeParams.page : 1);

    function search(page) {
        $http.post(listUrl, {
            model : vm.searchCriteria,
            page : page,
            limit : vm.limit
        }).success(function(data) {
            vm.page = data.resultList.page;

            $location.search({
                page : vm.page,
                searchCriteria : JSON.stringify(vm.searchCriteria)
            }).replace();

            vm.retrieveResult(data);
        });
    }

    function pageChanged() {
        search(vm.page);
    }

    function filter(size) {
        $http.post(filterUrl, {
            model : vm.searchCriteria
        }).success(function(data) {
            vm.retrieveFilterDependencies(data);
        });
    }

    function resetFilter() {
        vm.searchCriteria = {};
    }
}

CrudGridController.prototype.retrieveResult = function(data) {
    console.log("retrieveResult Parent");
};

CrudGridController.prototype.retrieveFilterDependencies = function(data) {
    console.log("retrieveFilterData Parent");
};
