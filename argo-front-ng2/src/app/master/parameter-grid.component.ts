import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ParameterService } from './parameter.service';

@Component( {
    selector: 'app-parameter-grid',
    templateUrl: './parameter-grid.component.html'
} )
export class ParameterGridComponent implements OnInit {
    model: any;
    enti: any;
    resultList: any;
    page: number;
    pageSize: number;

    prtoList: any[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private prmtService: ParameterService
        , private modalService: NgbModal
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe
            (( params: Params ) => {
                this.page = params['page'] ? +params['page'] : 1;
                this.model = params['model'] ? JSON.parse( decodeURIComponent( params['model'] ) ) : {};
                this.model.entiId = +params['entiId'];

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
        this.prmtService.filter( this.model ).subscribe( resp => {
            this.prtoList = resp.prtoList;

            this.modalService.open( filter, { size: "lg" } );
        } );
    }

    saveFilter() {
        this.page = 1;
        this.doSearch();
    }

    resetFilter() {
        this.page = 1;
        this.model = {
            entiId: this.model.entiId
        };
    }

    private doSearch() {
        this.prmtService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.enti = resp.enti;
            this.resultList = resp.resultList;

            this.location.replaceState(
                "/master/parameter/grid/" + this.model.entiId
                + ";page=" + this.page
                + ";model=" + encodeURIComponent( JSON.stringify( this.model ) )
            );
        } );
    }
}
