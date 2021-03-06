import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { BillSeriesService } from './bill-series.service';

@Component( {
    selector: 'app-bill-series-grid',
    templateUrl: './bill-series-grid.component.html'
} )
export class BillSeriesGridComponent implements OnInit {
    model: any;
    resultList: any;
    page: number;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private blsrService: BillSeriesService
        , private modalService: NgbModal
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe
            (( params: Params ) => {
                this.page = params['page'] ? +params['page'] : 1;
                this.model = params['model'] ? JSON.parse( decodeURIComponent( params['model'] ) ) : {};

                this.doSearch();
            } );
    }

    trackByFn( index, item ) {
        return index;
    }

    pageChange() {
        this.doSearch();
    }

    editFilter( filter ) {
        this.blsrService.filter( this.model ).subscribe( resp => {
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
        this.blsrService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;

            this.location.replaceState( "/billing/bill-series/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
