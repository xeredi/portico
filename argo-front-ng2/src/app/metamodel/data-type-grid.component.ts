import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { DataTypeService } from './data-type.service';

@Component( {
    selector: 'app-data-type-grid',
    templateUrl: './data-type-grid.component.html'
} )
export class DataTypeGridComponent implements OnInit {
    model: any;
    resultList: any;

    tpelList: any[];
    tphtList: any[];

    page: number;
    pageSize: number;
    count: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private dttpService: DataTypeService
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
        this.dttpService.filter( this.model ).subscribe( resp => {
            this.tpelList = resp.tpelList;
            this.tphtList = resp.tphtList;

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
        this.dttpService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;

            this.location.replaceState( "/metamodel/data-type/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
