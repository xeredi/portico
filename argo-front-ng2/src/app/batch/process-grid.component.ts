import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ProcessService } from './process.service';

@Component( {
    selector: 'app-process-grid',
    templateUrl: './process-grid.component.html'
} )
export class ProcessGridComponent implements OnInit {
    model: any;
    resultList: any;
    page: number;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private procService: ProcessService
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

    search() {
        this.page = 1;
        this.doSearch();
    }

    resetFilter() {
        this.page = 1;
        this.model = {};
    }

    private doSearch() {
        this.procService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;

            this.location.replaceState( "/batch/process/grid;page=" + this.page + ";model=" + encodeURIComponent( JSON.stringify( this.model ) ) );
        } );
    }
}
