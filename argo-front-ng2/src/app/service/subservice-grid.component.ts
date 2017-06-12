import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { SubserviceService } from '../item/subservice.service';

@Component( {
    selector: 'app-subservice-grid',
    templateUrl: './subservice-grid.component.html'
} )
export class SubserviceGridComponent implements OnInit {
    model: any;
    enti: any;
    resultList: any;
    page: number;
    pageSize: number;

    portList: any[];
    labelValuesMap: any;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private ssrvService: SubserviceService
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

    pageChange() {
        this.doSearch();
    }

    editFilter( filter ) {
        this.ssrvService.filter( this.model ).subscribe( resp => {
            this.portList = resp.prtoList;
            this.labelValuesMap = resp.labelValuesMap;

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
        this.model.entiId = this.enti.enti.id;
        this.model.itdtMap = {};
    }

    private doSearch() {
        this.ssrvService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.enti = resp.enti;
            this.resultList = resp.resultList;

            this.location.replaceState(
                "/service/subservice/grid/" + this.model.entiId
                + ";page=" + this.page
                + ";model=" + encodeURIComponent( JSON.stringify( this.model ) )
            );
        } );
    }
}
