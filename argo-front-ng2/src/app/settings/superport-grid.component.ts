import { Component, OnInit } from '@angular/core';

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

    constructor( private sprtService: SuperportService, private modalService: NgbModal ) { }

    ngOnInit() {
        this.page = 1;
        this.pageSize = 20;

        this.doSearch();
    }

    doSearch() {
        console.log( "Do Search" );

        this.sprtService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;
        } );
    }

    pageChange() {
        console.log( "Page change: " + this.page );

        this.doSearch();
    }

    editFilter( filter ) {
        console.log( "Edit Filter" );

        this.modalService.open( filter, { size: "lg" } );
    }

    saveFilter() {
        console.log( "Save Filter" );

        this.page = 1;
        this.doSearch();
    }

    resetFilter() {
        console.log( "Reset Filter" );

        this.model = {};
    }
}
