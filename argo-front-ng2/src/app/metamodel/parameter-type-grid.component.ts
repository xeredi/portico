import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ParameterTypeService } from './parameter-type.service';

@Component( {
    selector: 'app-parameter-type-grid',
    templateUrl: './parameter-type-grid.component.html'
} )
export class ParameterTypeGridComponent implements OnInit {
    model: any;
    resultList: any;

    page: number;
    pageSize: number;
    count: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private prtpService: ParameterTypeService
        , private modalService: NgbModal
    ) {
    }

    ngOnInit() {
        console.log( "ngOnInit page: " + this.page );

        this.pageSize = 20;

        this.route.params.subscribe
            (( params: Params ) => {
                this.page = params['page'] ? +params['page'] : 1;
                this.model = params['model'] ? JSON.parse( params['model'] ) : {};

                console.log( "after params page: " + this.page );

                this.doSearch();
            } );
    }

    pageChange() {
        // console.log( "Page change: " + this.page );
        this.doSearch();
    }

    editFilter( filter ) {
        // console.log( "Edit Filter" );
        this.prtpService.filter( this.model ).subscribe( resp => {
            this.modalService.open( filter, { size: "lg" } );
        } );
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

    private doSearch() {
        console.log( "Do Search page: " + this.page );
        this.prtpService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;

            this.location.replaceState( "/metamodel/parameter-type/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
