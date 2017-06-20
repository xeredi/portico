import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ModuleService } from './module.service';

@Component( {
    selector: 'app-module-grid',
    templateUrl: './module-grid.component.html'
} )
export class ModuleGridComponent implements OnInit {
    model: any;
    resultList: any;

    page: number;
    pageSize: number;
    count: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private mdleService: ModuleService
        , private modalService: NgbModal
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe
            (( params: Params ) => {
                this.page = params['page'] ? +params['page'] : 1;
                this.model = params['model'] ? JSON.parse( params['model'] ) : {};

                this.doSearch();
            } );
    }

    pageChange() {
        this.doSearch();
    }

    editFilter( filter ) {
        this.mdleService.filter( this.model ).subscribe( resp => {
            this.modalService.open( filter, { size: "lg" } );
        } );
    }

    saveFilter() {
        this.page = 1;
        this.doSearch();
    }

    resetFilter() {
        this.page = 1;
        this.model = {};
    }

    private doSearch() {
        this.mdleService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;

            this.location.replaceState( "/metamodel/module/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
