angular.module("facturacion", [])

.config(config)

// ----------------- MENU PRINCIPAL --------------------------
.controller("FacturacionController", FacturacionController)

// ----------- VALORADOR ------------------
.controller("VldrPrepareController", VldrPrepareController)

// ----------- FACTURADOR ------------------
.controller("FctrPrepareController", FctrPrepareController)

// ----------- FACTURA ------------------
.controller("FctrGridController", FctrGridController)

.controller("FctrDetailController", FctrDetailController)

.controller("FctlDetailController", FctlDetailController)

// ----------- VALORACION ------------------
.controller("VlrcGridController", VlrcGridController)

.controller("VlrcDetailController", VlrcDetailController)

.controller("VlrcEditController", VlrcEditController)

.controller("VlrlDetailController", VlrlDetailController)

.controller("VlrlEditController", VlrlEditController)

.controller("VlrlCreateController", VlrlCreateController)

.controller("VlrdDetailController", VlrdDetailController)

// ----------- SERIE DE FACTURA ------------------
.controller("FcsrGridController", FcsrGridController)

.controller("FcsrCreateController", FcsrCreateController)

.controller("FcsrDetailController", FcsrDetailController)

.controller("FcsrEditController", FcsrEditController)

// ----------- CARGO y REGLA ------------------
.controller("CrgoGridController", CrgoGridController)

.controller("CrgoCreateController", CrgoCreateController)

.controller("CrgoDetailController", CrgoDetailController)

.controller("CrgoEditController", CrgoEditController)

.controller("RglaDetailController", RglaDetailController)

.controller("RglaEditController", RglaEditController)

.controller("RglaCreateController", RglaCreateController)

.controller("RginDetailController", RginDetailController)

.controller("RginEditController", RginEditController)

.controller("RginCreateController", RginCreateController)

// ----------- ASPECTO y ASPECTO CARGO ------------------
.controller("AspcGridController", AspcGridController)

.controller("AspcCreateController", AspcCreateController)

.controller("AspcDetailController", AspcDetailController)

.controller("AspcEditController", AspcEditController)

.controller("AspcDuplicateController", AspcDuplicateController)

.controller("AscrCreateController", AscrCreateController)

.controller("AscrDetailController", AscrDetailController)

.controller("AscrEditController", AscrEditController);

function config($routeProvider) {
	$routeProvider

	.when("/facturacion", {
		templateUrl : "modules/facturacion/facturacion.html",
		controller : "FacturacionController",
		controllerAs : "vm"
	})

	.when("/facturacion/vldr/prepare/:entiId/:srvcId", {
		templateUrl : "modules/facturacion/vldr-prepare.html",
		controller : "VldrPrepareController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/fctr/prepare/:vlrcId", {
		templateUrl : "modules/facturacion/fctr-prepare.html",
		controller : "FctrPrepareController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/fctr/grid", {
		templateUrl : "modules/facturacion/fctr-grid.html",
		controller : "FctrGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/fctr/detail/:fctrId", {
		templateUrl : "modules/facturacion/fctr-detail.html",
		controller : "FctrDetailController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/fctl/detail/:fctlId", {
		templateUrl : "modules/facturacion/fctl-detail.html",
		controller : "FctlDetailController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/vlrc/grid", {
		templateUrl : "modules/facturacion/vlrc-grid.html",
		controller : "VlrcGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/vlrc/detail/:vlrcId", {
		templateUrl : "modules/facturacion/vlrc-detail.html",
		controller : "VlrcDetailController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/vlrc/edit/:vlrcId", {
		templateUrl : "modules/facturacion/vlrc-edit.html",
		controller : "VlrcEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/vlrl/create/:vlrcId", {
		templateUrl : "modules/facturacion/vlrl-edit.html",
		controller : "VlrlCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/vlrl/detail/:vlrlId", {
		templateUrl : "modules/facturacion/vlrl-detail.html",
		controller : "VlrlDetailController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/vlrl/edit/:vlrlId", {
		templateUrl : "modules/facturacion/vlrl-edit.html",
		controller : "VlrlEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/vlrd/detail/:vlrdId", {
		templateUrl : "modules/facturacion/vlrd-detail.html",
		controller : "VlrdDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/vlrd/edit/:vlrdId", {
		templateUrl : "modules/facturacion/vlrd-edit.html",
		controller : "vlrdEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/fcsr/grid", {
		templateUrl : "modules/facturacion/fcsr-grid.html",
		controller : "FcsrGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/fcsr/detail/:fcsrId", {
		templateUrl : "modules/facturacion/fcsr-detail.html",
		controller : "FcsrDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/fcsr/edit/:fcsrId", {
		templateUrl : "modules/facturacion/fcsr-edit.html",
		controller : "FcsrEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/fcsr/create", {
		templateUrl : "modules/facturacion/fcsr-edit.html",
		controller : "FcsrCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/crgo/grid", {
		templateUrl : "modules/facturacion/crgo-grid.html",
		controller : "CrgoGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/crgo/detail/:crgoId", {
		templateUrl : "modules/facturacion/crgo-detail.html",
		controller : "CrgoDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/crgo/detail/:crgoId/:fechaVigencia", {
		templateUrl : "modules/facturacion/crgo-detail.html",
		controller : "CrgoDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/crgo/edit/:crgoId", {
		templateUrl : "modules/facturacion/crgo-edit.html",
		controller : "CrgoEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/crgo/edit/:crgoId/:fechaVigencia", {
		templateUrl : "modules/facturacion/crgo-edit.html",
		controller : "CrgoEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/crgo/create", {
		templateUrl : "modules/facturacion/crgo-edit.html",
		controller : "CrgoCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgla/detail/:rglaId", {
		templateUrl : "modules/facturacion/rgla-detail.html",
		controller : "RglaDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgla/detail/:rglaId/:fechaVigencia", {
		templateUrl : "modules/facturacion/rgla-detail.html",
		controller : "RglaDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgla/edit/:rglaId", {
		templateUrl : "modules/facturacion/rgla-edit.html",
		controller : "RglaEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgla/edit/:rglaId/:fechaVigencia", {
		templateUrl : "modules/facturacion/rgla-edit.html",
		controller : "RglaEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgla/create/:crgoId", {
		templateUrl : "modules/facturacion/rgla-edit.html",
		controller : "RglaCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgla/create/:crgoId/:fechaVigencia", {
		templateUrl : "modules/facturacion/rgla-edit.html",
		controller : "RglaCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgin/detail/:rginId", {
		templateUrl : "modules/facturacion/rgin-detail.html",
		controller : "RginDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgin/detail/:rginId/:fechaVigencia", {
		templateUrl : "modules/facturacion/rgin-detail.html",
		controller : "RginDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgin/edit/:rgivId", {
		templateUrl : "modules/facturacion/rgin-edit.html",
		controller : "RginEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/rgin/create/:crgoId/:rgla1Id", {
		templateUrl : "modules/facturacion/rgin-edit.html",
		controller : "RginCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/grid", {
		templateUrl : "modules/facturacion/aspc-grid.html",
		controller : "AspcGridController",
		controllerAs : "vm",
		reloadOnSearch : false
	})

	.when("/facturacion/aspc/create", {
		templateUrl : "modules/facturacion/aspc-edit.html",
		controller : "AspcCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/detail/:aspcId", {
		templateUrl : "modules/facturacion/aspc-detail.html",
		controller : "AspcDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/detail/:aspcId/:fechaVigencia", {
		templateUrl : "modules/facturacion/aspc-detail.html",
		controller : "AspcDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/edit/:aspcId", {
		templateUrl : "modules/facturacion/aspc-edit.html",
		controller : "AspcEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/edit/:aspcId/:fechaVigencia", {
		templateUrl : "modules/facturacion/aspc-edit.html",
		controller : "AspcEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/duplicate/:aspcId", {
		templateUrl : "modules/facturacion/aspc-edit.html",
		controller : "AspcDuplicateController",
		controllerAs : "vm"
	})

	.when("/facturacion/aspc/duplicate/:aspcId/:fechaVigencia", {
		templateUrl : "modules/facturacion/aspc-edit.html",
		controller : "AspcDuplicateController",
		controllerAs : "vm"
	})

	.when("/facturacion/ascr/create/:aspcId/:fechaVigencia", {
		templateUrl : "modules/facturacion/ascr-edit.html",
		controller : "AscrCreateController",
		controllerAs : "vm"
	})

	.when("/facturacion/ascr/detail/:ascrId/:fechaVigencia", {
		templateUrl : "modules/facturacion/ascr-detail.html",
		controller : "AscrDetailController",
		controllerAs : "vm"
	})

	.when("/facturacion/ascr/edit/:ascrId", {
		templateUrl : "modules/facturacion/ascr-edit.html",
		controller : "AscrEditController",
		controllerAs : "vm"
	})

	.when("/facturacion/ascr/edit/:ascrId/:fechaVigencia", {
		templateUrl : "modules/facturacion/ascr-edit.html",
		controller : "AscrEditController",
		controllerAs : "vm"
	});
}

function FacturacionController(pageTitleService) {
	pageTitleService.setTitle("sec_facturacion", "page_home");
}

function VldrPrepareController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.valorar = valorar;
	vm.cancel = cancel;

	function valorar() {
		$http.post("facturacion/vldr-valorar.action", {
			fliq : vm.fliq,
			srvc : vm.srvc
		}).success(function(data) {
			$location.path("/proceso/prbt/grid").replace();
		});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/vldr-prepare.action", {
		srvc : {
			id : $routeParams.srvcId,
			entiId : $routeParams.entiId
		}
	}).success(function(data) {
		vm.srvc = data.srvc;
		vm.fliq = data.fliq;
	});

	pageTitleService.setTitle("vldr", "page_prepare");
}

function FctrPrepareController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.facturar = facturar;
	vm.cancel = cancel;

	function facturar() {
		$http.post("facturacion/fctr-facturar.action", {
			ffac : vm.ffac,
			vlrc : vm.vlrc,
			aspcId : vm.aspcId,
			fcsrId : vm.fcsrId
		}).success(function(data) {
			$location.path("/proceso/prbt/grid").replace();
		});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/fctr-prepare.action", {
		vlrc : {
			id : $routeParams.vlrcId
		}
	}).success(function(data) {
		vm.vlrc = data.vlrc;
		vm.ffac = data.ffac;
		vm.aspcId = data.aspcId;
		vm.aspcList = data.aspcList;
		vm.fcsrList = data.fcsrList;
	});

	pageTitleService.setTitle("fctr", "page_prepare");
}

function FctrGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.fctrCriterio = $routeParams.fctrCriterio ? angular
			.fromJson($routeParams.fctrCriterio) : {};

	function search(page) {
		$http.post("facturacion/fctr-list.action", {
			fctrCriterio : vm.fctrCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.page = data.fctrList.page;
			vm.fctrList = data.fctrList;
			vm.fctrCriterio = data.fctrCriterio;

			$location.search({
				page : vm.page,
				fctrCriterio : JSON.stringify(vm.fctrCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
		$http.post("facturacion/fctr-filter.action").success(function(data) {
			// vm.tpsrList = data.tpsrList;
		});
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("fctr", "page_grid");
}

function FctrDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.print = print;

	vm.tab = $routeParams.tab ? $routeParams.tab : null;
	vm.path = $location.path();

	function findFctlList(page) {
		$http.post("facturacion/fctl-list.action", {
			fctrId : $routeParams.fctrId,
			page : page
		}).success(function(data) {
			vm.fctlList = data.fctlList;
			vm.page = data.fctlList.page;

			$location.search("page", vm.page).replace();
		});
	}

	function pageChanged() {
		findFctlList(vm.page);
	}

	function tabSelected(tabNo) {
		if (vm.path == $location.path()) {
			$location.search("tab", tabNo).replace();
		}
	}

	function print() {
		$http.post('facturacion/fctr-print.action', {
			fctrId : vm.fctr.id
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ], {
				type : 'application/pdf'
			});

			setTimeout(function() {
				saveAs(file, vm.fctr.etiqueta + '.pdf');
			}, 0);
		});
	}

	$http.post("facturacion/fctr-detail.action", {
		fctr : {
			id : $routeParams.fctrId
		}
	}).success(function(data) {
		vm.fctr = data.fctr;
		vm.aspc = data.aspc;
		vm.fctsList = data.fctsList;
		vm.fctgList = data.fctgList;
		vm.fctiList = data.fctiList;

		findFctlList($routeParams.page ? $routeParams.page : 1);
	});

	pageTitleService.setTitle("fctr", "page_detail");
}

function FctlDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;

	vm.tab = $routeParams.tab ? $routeParams.tab : null;
	vm.path = $location.path();

	function findFctdList(page) {
		$http.post("facturacion/fctd-list.action", {
			fctlId : $routeParams.fctlId,
			page : page
		}).success(function(data) {
			vm.fctdList = data.fctdList;
			vm.page = data.fctdList.page;

			$location.search("page", vm.page).replace();
		});
	}

	function pageChanged() {
		findFctdList(vm.page);
	}

	function tabSelected(tabNo) {
		if (vm.path == $location.path()) {
			$location.search("tab", tabNo).replace();
		}
	}

	$http.post("facturacion/fctl-detail.action", {
		fctl : {
			id : $routeParams.fctlId
		}
	}).success(function(data) {
		vm.fctl = data.fctl;

		findFctdList($routeParams.page ? $routeParams.page : 1);
	});

	pageTitleService.setTitle("fctl", "page_detail");
}

function VlrcGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;
	vm.tpsrChanged = tpsrChanged;

	vm.vlrcCriterio = $routeParams.vlrcCriterio ? angular
			.fromJson($routeParams.vlrcCriterio) : {};

	if ($routeParams.srvcId) {
		vm.vlrcCriterio.srvc = {
			id : $routeParams.srvcId
		};
	}

	function search(page) {
		$http.post("facturacion/vlrc-list.action", {
			vlrcCriterio : vm.vlrcCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.page = data.vlrcList.page;
			vm.vlrcList = data.vlrcList;
			vm.vlrcCriterio = data.vlrcCriterio;

			$location.search({
				page : vm.page,
				vlrcCriterio : JSON.stringify(vm.vlrcCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
		$http.post("facturacion/vlrc-filter.action").success(function(data) {
			vm.tpsrList = data.tpsrList;
		});
	}

	function tpsrChanged(tpsrId) {
		if (tpsrId != null) {
			$http.post("facturacion/vlrc-reload-filter.action", {
				vlrcCriterio : {
					tpsrId : tpsrId
				}
			}).success(function(data) {
				vm.crgoList = data.crgoList;
				vm.aspcList = data.aspcList;
			});
		}
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("vlrc", "page_grid");
}

function VlrcDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.remove = remove;
	vm.print = print;

	vm.tab = $routeParams.tab ? $routeParams.tab : null;
	vm.path = $location.path();

	function findVlrlList(page) {
		$http.post("facturacion/vlrl-list.action", {
			vlrlCriterio : {
				vlrc : {
					id : $routeParams.vlrcId
				}
			},
			page : page
		}).success(function(data) {
			vm.vlrlList = data.vlrlList;
			vm.page = data.vlrlList.page;

			$location.search("page", vm.page).replace();
		});
	}

	function pageChanged() {
		findVlrlList(vm.page);
	}

	function tabSelected(tabNo) {
		if (vm.path == $location.path()) {
			$location.search("tab", tabNo).replace();
		}
	}

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/vlrc-remove.action", {
				vlrc : {
					id : vm.vlrc.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	function print() {
		$http.post('facturacion/vlrc-print.action', {
			vlrcId : vm.vlrc.id
		}, {
			responseType : 'arraybuffer'
		}).success(function(data) {
			var file = new Blob([ data ], {
				type : 'application/pdf'
			});

			setTimeout(function() {
				saveAs(file, vm.vlrc.id + '.pdf');
			}, 0);
		});
	}

	$http.post("facturacion/vlrc-detail.action", {
		vlrc : {
			id : $routeParams.vlrcId
		}
	}).success(function(data) {
		vm.vlrc = data.vlrc;
		vm.aspc = data.aspc;
		vm.vlrgList = data.vlrgList;
		vm.vlriList = data.vlriList;

		findVlrlList($routeParams.page ? $routeParams.page : 1);
	});

	pageTitleService.setTitle("vlrc", "page_detail");
}

function VlrcEditController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		alert('save');
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/vlrc-edit.action", {
		vlrc : {
			id : $routeParams.vlrcId
		}
	}).success(function(data) {
		vm.vlrc = data.vlrc;
		vm.tpsrId = data.vlrc.srvc.entiId;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("vlrc", "page_edit");
}

function VlrlDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.pageChanged = pageChanged;
	vm.tabSelected = tabSelected;
	vm.remove = remove;

	vm.tab = $routeParams.tab ? $routeParams.tab : null;
	vm.path = $location.path();

	function findVlrdList(page) {
		$http.post("facturacion/vlrd-list.action", {
			vlrdCriterio : {
				vlrl : {
					id : $routeParams.vlrlId
				}
			},
			page : page
		}).success(function(data) {
			vm.vlrdList = data.vlrdList;
			vm.page = data.vlrdList.page;

			$location.search("page", vm.page).replace();
		});
	}

	function pageChanged() {
		findVlrdList(vm.page);
	}

	function tabSelected(tabNo) {
		if (vm.path == $location.path()) {
			$location.search("tab", tabNo).replace();
		}
	}

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/vlrl-remove.action", {
				vlrl : {
					id : vm.vlrl.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/vlrl-detail.action", {
		vlrl : {
			id : $routeParams.vlrlId
		}
	}).success(function(data) {
		vm.vlrl = data.vlrl;

		findVlrdList($routeParams.page ? $routeParams.page : 1);
	});

	pageTitleService.setTitle("vlrl", "page_detail");
}

function VlrlEditController($scope, $http, $location, $routeParams,
		pageTitleService) {
	$http.post("facturacion/vlrl-edit.action", {
		vlrl : {
			id : $routeParams.vlrlId
		}
	}).success(function(data) {
		$scope.vlrl = data.vlrl;
		$scope.accion = data.accion;
	});

	$scope.save = function() {
		$http.post("facturacion/vlrl-save.action", {
			vlrl : $scope.vlrl,
			accion : $scope.accion
		}).success(function(data) {
			setTimeout(function() {
				window.history.back();
			}, 0);
		});
	};

	$scope.cancel = function() {
		window.history.back();
	};

	pageTitleService.setTitle("vlrl", "page_edit");
}

function VlrlCreateController($scope, $http, $location, $routeParams,
		pageTitleService) {
	$http.post("facturacion/vlrl-create.action", {
		vlrl : {
			vlrcId : $routeParams.vlrcId
		}
	}).success(function(data) {
		$scope.vlrl = data.vlrl;
		$scope.accion = data.accion;
	});

	$scope.save = function() {
		$http.post("facturacion/vlrl-save.action", {
			vlrl : $scope.vlrl,
			accion : $scope.accion
		}).success(
				function(data) {
					$location.path("/facturacion/vlrl/detail/" + data.vlrl.id)
							.replace();
				});
	};

	$scope.cancel = function() {
		window.history.back();
	};

	pageTitleService.setTitle("vlrc", "page_create");
}

function VlrdDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	$http.post("facturacion/vlrd-detail.action", {
		vlrd : {
			id : $routeParams.vlrdId
		}
	}).success(function(data) {
		vm.vlrd = data.vlrd;
		vm.vlrl = data.vlrl;
	});

	pageTitleService.setTitle("vlrl", "page_detail");
}

function FcsrGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.fcsrCriterio = $routeParams.fcsrCriterio ? angular
			.fromJson($routeParams.fcsrCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("facturacion/fcsr-list.action", {
			fcsrCriterio : vm.fcsrCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.fcsrList = data.fcsrList;
			vm.page = data.fcsrList.page;

			$location.search({
				page : vm.page,
				fcsrCriterio : JSON.stringify(vm.fcsrCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("fcsr", "page_grid");
}

function FcsrDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/fcsr-remove.action", {
				fcsr : {
					id : vm.fcsr.id
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/fcsr-detail.action", {
		fcsr : {
			id : $routeParams.fcsrId
		}
	}).success(function(data) {
		vm.fcsr = data.fcsr;
	});

	pageTitleService.setTitle("fcsr", "page_detail");
}

function FcsrCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/fcsr-save.action", {
			fcsr : vm.fcsr,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/facturacion/fcsr/detail/" + data.fcsr.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/fcsr-create.action").success(function(data) {
		vm.fcsr = data.fcsr;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("fcsr", "page_create");
}

function FcsrEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/fcsr-save.action", {
			fcsr : vm.fcsr,
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

	$http.post("facturacion/fcsr-edit.action", {
		fcsr : {
			id : $routeParams.fcsrId
		}
	}).success(function(data) {
		vm.fcsr = data.fcsr;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("fcsr", "page_edit");
}

function CrgoGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.crgoCriterio = $routeParams.crgoCriterio ? angular
			.fromJson($routeParams.crgoCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("facturacion/crgo-list.action", {
			crgoCriterio : vm.crgoCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.crgoList = data.crgoList;
			vm.page = data.crgoList.page;

			$location.search({
				page : vm.page,
				crgoCriterio : JSON.stringify(vm.crgoCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
		$http.post("metamodelo/enti-lv-list.action", {
			entiCriterio : {
				tipo : "T"
			}
		}).success(function(data) {
			vm.entiList = data.lvList;
		});
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("crgo", "page_grid");
}

function CrgoDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/crgo-remove.action", {
				crgo : {
					crgv : {
						id : vm.crgo.crgv.id
					}
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/crgo-detail.action", {
		crgo : {
			id : $routeParams.crgoId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.crgo = data.crgo;
		vm.i18nMap = data.i18nMap;
		vm.rglaList = data.rglaList;
		vm.fechaVigencia = data.fechaVigencia;
	});

	pageTitleService.setTitle("crgo", "page_detail");
}

function CrgoCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/crgo-save.action", {
			crgo : vm.crgo,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/facturacion/crgo/detail/" + data.crgo.crgv.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/crgo-create.action").success(function(data) {
		vm.crgo = data.crgo;
		vm.tipos = data.tipos;
		vm.accion = data.accion;
		vm.entiList = data.tpsrList;
	});

	pageTitleService.setTitle("crgo", "page_create");
}

function CrgoEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/crgo-save.action", {
			crgo : vm.crgo,
			i18nMap : vm.i18nMap,
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

	$http.post("facturacion/crgo-edit.action", {
		crgo : {
			id : $routeParams.crgoId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.crgo = data.crgo;
		vm.i18nMap = data.i18nMap;
		vm.tipos = data.tipos;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("crgo", "page_edit");
}

function RglaDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/rgla-remove.action", {
				rgla : {
					rglv : {
						id : vm.rgla.rglv.id
					}
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/rgla-detail.action", {
		rgla : {
			id : $routeParams.rglaId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.rgla = data.rgla;
		vm.rginList = data.rginList;
		vm.fechaVigencia = data.fechaVigencia;
	});

	pageTitleService.setTitle("rgla", "page_detail");
}

function RglaEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/rgla-save.action", {
			rgla : vm.rgla,
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

	$http.post("facturacion/rgla-edit.action", {
		rgla : {
			id : $routeParams.rglaId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.rgla = data.rgla;
		vm.tipos = data.tipos;
		vm.entiFacturableList = data.entiFacturableList;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("rgla", "page_edit");
}

function RglaCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/rgla-save.action", {
			rgla : vm.rgla,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/facturacion/rgla/detail/" + data.rgla.id + "/"
									+ data.rgla.rglv.fini).replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/rgla-create.action", {
		rgla : {
			crgo : {
				id : $routeParams.crgoId
			},
			fechaVigencia : $routeParams.fechaVigencia
		}
	}).success(function(data) {
		vm.rgla = data.rgla;
		vm.tipos = data.tipos;
		vm.entiFacturableList = data.entiFacturableList;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("rgla", "page_create");
}

function RginDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/rgin-remove.action", {
				rgin : {
					rgiv : {
						id : vm.rgin.rgiv.id
					}
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/rgin-detail.action", {
		rgin : {
			id : $routeParams.rginId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.rgin = data.rgin;
		vm.fechaVigencia = data.fechaVigencia;
	});

	pageTitleService.setTitle("rgin", "page_detail");
}

function RginEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/rgin-save.action", {
			rgin : vm.rgin,
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

	$http.post("facturacion/rgin-edit.action", {
		rgin : {
			rgiv : {
				id : $routeParams.rgivId
			}
		}
	}).success(function(data) {
		vm.rgin = data.rgin;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("rgin", "page_edit");
}

function RginCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/rgin-save.action", {
			rgin : vm.rgin,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path("/facturacion/rgin/detail/" + data.rgin.id)
							.replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/rgin-create.action", {
		rgin : {
			rgla1Id : $routeParams.rgla1Id
		},
		crgoId : $routeParams.crgoId
	}).success(function(data) {
		vm.rgin = data.rgin;
		vm.accion = data.accion;
		vm.rgla2List = data.rgla2List;
	});

	pageTitleService.setTitle("rgin", "page_create");
}

function AspcGridController($http, $location, $routeParams, $modal,
		pageTitleService) {
	var vm = this;

	vm.search = search;
	vm.pageChanged = pageChanged;
	vm.filter = filter;

	vm.aspcCriterio = $routeParams.aspcCriterio ? angular
			.fromJson($routeParams.aspcCriterio) : {};
	vm.page = $routeParams.page ? $routeParams.page : 1;

	function search(page) {
		$http.post("facturacion/aspc-list.action", {
			aspcCriterio : vm.aspcCriterio,
			page : page,
			limit : vm.limit
		}).success(function(data) {
			vm.aspcList = data.aspcList;
			vm.page = data.aspcList.page;

			$location.search({
				page : vm.page,
				aspcCriterio : JSON.stringify(vm.aspcCriterio)
			}).replace();
		});
	}

	function pageChanged() {
		search(vm.page);
	}

	function filter(size) {
		$http.post("metamodelo/enti-lv-list.action", {
			entiCriterio : {
				tipo : "T"
			}
		}).success(function(data) {
			vm.entiList = data.lvList;
		});
	}

	search($routeParams.page ? $routeParams.page : 1);
	pageTitleService.setTitle("aspc", "page_grid");
}

function AspcDetailController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/aspc-remove.action", {
				aspc : {
					aspv : {
						id : vm.aspc.aspv.id
					}
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/aspc-detail.action", {
		aspc : {
			id : $routeParams.aspcId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.urlInclude = 'modules/facturacion/aspc-detail.html';
		vm.aspc = data.aspc;
		vm.i18nMap = data.i18nMap;
		vm.ascrList = data.ascrList;
		vm.fechaVigencia = data.fechaVigencia;
	});

	pageTitleService.setTitle("aspc", "page_detail");
}

function AspcCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/aspc-save.action", {
			aspc : vm.aspc,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/facturacion/aspc/detail/" + data.aspc.id + "/"
									+ data.aspc.aspv.fini).replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/aspc-create.action").success(function(data) {
		vm.aspc = data.aspc;
		vm.accion = data.accion;
		vm.entiTpsrList = data.entiList;
	});

	pageTitleService.setTitle("aspc", "page_create");
}

function AspcEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/aspc-save.action", {
			aspc : vm.aspc,
			i18nMap : vm.i18nMap,
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

	$http.post("facturacion/aspc-edit.action", {
		aspc : {
			id : $routeParams.aspcId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.aspc = data.aspc;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("aspc", "page_edit");
}

function AspcDuplicateController($http, $location, $routeParams,
		pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/aspc-save.action", {
			aspc : vm.aspc,
			i18nMap : vm.i18nMap,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/facturacion/aspc/detail/" + data.aspc.id + "/"
									+ data.aspc.aspv.fini).replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/aspc-duplicate.action", {
		aspc : {
			id : $routeParams.aspcId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.aspc = data.aspc;
		vm.i18nMap = data.i18nMap;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("aspc", "page_duplicate");
}

function AscrDetailController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.remove = remove;

	function remove() {
		if (confirm("Are you sure?")) {
			$http.post("facturacion/ascr-remove.action", {
				ascr : {
					ascv : {
						id : vm.ascr.ascv.id
					}
				}
			}).success(function(data) {
				window.history.back();
			});
		}
	}

	$http.post("facturacion/ascr-detail.action", {
		ascr : {
			id : $routeParams.ascrId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.ascr = data.ascr;
		vm.fechaVigencia = data.fechaVigencia;
	});

	pageTitleService.setTitle("ascr", "page_detail");
}

function AscrCreateController($http, $location, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/ascr-save.action", {
			ascr : vm.ascr,
			accion : vm.accion
		}).success(
				function(data) {
					$location.path(
							"/facturacion/ascr/detail/" + data.ascr.id + "/"
									+ data.ascr.ascv.fini).replace();
				});
	}

	function cancel() {
		window.history.back();
	}

	$http.post("facturacion/ascr-create.action", {
		ascr : {
			aspcId : $routeParams.aspcId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.ascr = data.ascr;
		vm.crgoList = data.crgoList;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("ascr", "page_create");
}

function AscrEditController($http, $routeParams, pageTitleService) {
	var vm = this;

	vm.save = save;
	vm.cancel = cancel;

	function save() {
		$http.post("facturacion/ascr-save.action", {
			ascr : vm.ascr,
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

	$http.post("facturacion/ascr-edit.action", {
		ascr : {
			id : $routeParams.ascrId
		},
		fechaVigencia : $routeParams.fechaVigencia
	}).success(function(data) {
		vm.ascr = data.ascr;
		vm.accion = data.accion;
	});

	pageTitleService.setTitle("ascr", "page_edit");
}