import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { AspectService } from './aspect.service';

@Component( {
    selector: 'app-aspect-grid',
    templateUrl: './aspect-grid.component.html'
} )
export class AspectGridComponent implements OnInit {
    model: any;
    resultList: any;
    page: number;
    pageSize: number;

    srtpList: any[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private aspcService: AspectService
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

    trackByFn( index, item ) {
        return index;
    }

    pageChange() {
        this.doSearch();
    }

    editFilter( filter ) {
        this.aspcService.filter( this.model ).subscribe( resp => {
            this.srtpList = resp.tpsrList;

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
        this.aspcService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;

            this.location.replaceState( "/billing/aspect/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
