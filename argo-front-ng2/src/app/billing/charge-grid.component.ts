import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ChargeService } from './charge.service';

@Component( {
    selector: 'app-charge-grid',
    templateUrl: './charge-grid.component.html'
} )
export class ChargeGridComponent implements OnInit {
    model: any;
    resultList: any;
    page: number;
    pageSize: number;
    count: number;

    tpsrList: any[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private chrgService: ChargeService
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
        this.chrgService.filter( this.model ).subscribe( resp => {
            this.tpsrList = resp.tpsrList;

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
        this.chrgService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;

            this.location.replaceState( "/billing/charge/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
