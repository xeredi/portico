import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { SuperportService } from './superport.service';

@Component( {
    selector: 'app-superport-grid',
    templateUrl: './superport-grid.component.html'
} )
export class SuperportGridComponent implements OnInit {
    model: any = {};
    resultList: any = {};

    page: number;
    pageSize: number;
    count: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private sprtService: SuperportService
        , private modalService: NgbModal
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe
            (( params: Params ) => {
                this.page = params['page'] ? +params['page'] : 1;
                this.model = params['model'] ? JSON.parse( params['model'] ) : {};
            } );

        this.pageSize = 20;

        this.doSearch();
    }

    doSearch() {
        // console.log( "Do Search" );
        this.sprtService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;

            this.location.replaceState( "/settings/superport/grid;page=" + this.page + ";model=" + JSON.stringify( this.model ) );
        } );
    }

    pageChange() {
        // console.log( "Page change: " + this.page );
        this.doSearch();
    }

    editFilter( filter ) {
        // console.log( "Edit Filter" );
        this.modalService.open( filter, { size: "lg" } );
    }

    saveFilter() {
        // console.log( "Save Filter" );
        this.page = 1;
        this.doSearch();
    }

    resetFilter() {
        // console.log( "Reset Filter" );
        this.page = 1;
        this.model = {};
    }
}
