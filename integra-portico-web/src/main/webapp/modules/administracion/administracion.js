angular.module("administracion", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("administracionController", administracionController)

// ----------------- METAMODELO --------------------------
.controller("metamodeloReloadController", metamodeloReloadController)

// ----------------- CONFIGURACION --------------------------
.controller("confGridController", confGridController)

.controller("confDetailController", confDetailController)

.controller("confEditController", confEditController)

// ----------------- MESSAGEI18N --------------------------
.controller("m18nGridController", m18nGridController)

.controller("m18nDetailController", m18nDetailController)

.controller("m18nEditController", m18nEditController)

// ----------------- SCHEDULER --------------------------
.controller("schrDetailController", schrDetailController)

;

function config($routeProvider) {
	$routeProvider

	.when("/administracion", {
		title : 'sec_administracion',
		templateUrl : "modules/administracion/administracion.html",
		controller : "administracionController",
		controllerAs : "vm"
	})

	.when("/administracion/metamodelo/reload", {
		title : 'metamodelo_reload',
		templateUrl : "modules/administracion/metamodelo-reload.html",
		controller : "metamodeloReloadController",
		controllerAs : "vm"
	})

	.when("/administracion/conf/grid", {
		title : 'conf_grid',
		templateUrl : "modules/administracion/conf-grid.html",
		controller : "confGridController",
		controllerAs : "vm"
	}).when("/administracion/conf/detail/:key", {
		title : 'conf_detail',
		templateUrl : "modules/administracion/conf-detail.html",
		controller : "confDetailController",
		controllerAs : "vm"
	}).when("/administracion/conf/edit/:key", {
		title : 'conf_edit',
		templateUrl : "modules/administracion/conf-edit.html",
		controller : "confEditController",
		controllerAs : "vm"
	})

	.when("/administracion/m18n/grid", {
		title : 'm18nList',
		templateUrl : "modules/administracion/m18n-grid.html",
		controller : "m18nGridController",
		controllerAs : "vm"
	}).when("/administracion/m18n/detail/:key", {
		title : 'm18n',
		templateUrl : "modules/administracion/m18n-detail.html",
		controller : "m18nDetailController",
		controllerAs : "vm"
	}).when("/administracion/m18n/edit/:key", {
		title : 'm18n',
		templateUrl : "modules/administracion/m18n-edit.html",
		controller : "m18nEditController",
		controllerAs : "vm"
	})

	.when("/administracion/schr/detail", {
		title : 'm18n',
		templateUrl : "modules/administracion/schr-detail.html",
		controller : "schrDetailController",
		controllerAs : "vm"
	})

	;

}

function administracionController(pageTitleService) {
	pageTitleService.setTitle("sec_administracion", "page_home");
}

function metamodeloReloadController($http, pageTitleService) {
	var vm = this;

	vm.reload = reload;

	function reload() {
		$http.post("administracion/metamodelo/reload.action").success(
				function(data) {
				});
	}

	pageTitleService.setTitle("metamodelo", "page_reload");
}

function confGridController($http, pageTitleService) {
	var vm = this;

	vm.reload = reload;

	function reload() {
		$http.post("administracion/configuracion/conf-reload.action").success(
				function(data) {
				});
	}

	$http.post("administracion/configuracion/conf-grid.action").success(
			function(data) {
				vm.confList = data.confList;
			});

	pageTitleService.setTitle("conf", "page_grid");
}

function confDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	$http.post("administracion/configuracion/conf-detail.action", {
		conf : {
			key : $routeParams.key
		}
	}).success(function(data) {
		vm.conf = data.conf;
	});

	pageTitleService.setTitle("conf", "page_detail");
}

function confEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("administracion/configuracion/conf-save.action", {
			conf : vm.conf,
			accion : vm.accion
		}).success(function(data) {
			setTimeout(function() {
				window.history.back();
			}, 0);
		});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("administracion/configuracion/conf-edit.action", {
		conf : {
			key : $routeParams.key
		}
	}).success(function(data) {
		vm.accion = data.accion;
		vm.conf = data.conf;
	});

	pageTitleService.setTitle("conf", "page_edit");
}

function m18nGridController($http, pageTitleService) {
	var vm = this;

	vm.reload = reload;

	function reload() {
		$http.post("administracion/messagei18n/m18n-reload.action").success(
				function(data) {
				});
	}

	$http.post("administracion/messagei18n/m18n-grid.action").success(
			function(data) {
				vm.keyList = data.keyList;
				vm.keyMap = data.keyMap;
				vm.availableLanguages = data.availableLanguages;
			});

	pageTitleService.setTitle("m18n", "page_grid");
}

function m18nDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	$http.post("administracion/messagei18n/m18n-detail.action", {
		key : $routeParams.key
	}).success(function(data) {
		vm.key = data.key;
		vm.m18nMap = data.m18nMap;
		vm.availableLanguages = data.availableLanguages;
	});

	pageTitleService.setTitle("m18n", "page_detail");
}

function m18nEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("administracion/messagei18n/m18n-save.action", {
			accion : vm.accion,
			key : vm.key,
			m18nMap : vm.m18nMap
		}).success(function(data) {
			setTimeout(function() {
				window.history.back();
			}, 0);
		});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("administracion/messagei18n/m18n-edit.action", {
		key : $routeParams.key
	}).success(function(data) {
		vm.accion = data.accion;
		vm.key = data.key;
		vm.m18nMap = data.m18nMap;
		vm.availableLanguages = data.availableLanguages;
	});

	pageTitleService.setTitle("m18n", "page_edit");
}

function schrDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.start = start;
	vm.pause = pause;
	vm.shutdown = shutdown;
	vm.shutdownClean = shutdownClean;

	function start() {
		$http.post("administracion/job/schr-start.action").success(
				function(data) {
					vm.schr = data.schr;
				});
	}

	function pause() {
		$http.post("administracion/job/schr-pause.action").success(
				function(data) {
					vm.schr = data.schr;
				});
	}

	function shutdown() {
		$http.post("administracion/job/schr-shutdown.action").success(
				function(data) {
					vm.schr = data.schr;
				});
	}

	function shutdownClean() {
		$http.post("administracion/job/schr-shutdown-clean.action").success(
				function(data) {
					vm.schr = data.schr;
				});
	}

	$http.post("administracion/job/schr-detail.action").success(function(data) {
		vm.schr = data.schr;
	});

	pageTitleService.setTitle("schr", "page_detail");
}
