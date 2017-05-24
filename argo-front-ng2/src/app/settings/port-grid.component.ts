import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { PortService } from './port.service';

@Component( {
    selector: 'app-port-grid',
    template: `
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group mr-2" role="group">
        <ngb-pagination [collectionSize]="count" [(page)]="page" [pageSize]="pageSize" [maxSize]="1" [size]="sm"
            [boundaryLinks]="false" [ellipses]="false" (pageChange)="pageChange()"></ngb-pagination>
    </div>
    <div class="btn-group mr-2" role="group">
        <button class="btn btn-secondary" (click)="editFilter(filter)">
            <i class="fa fa-filter"></i> Filter
        </button>
        <a class="btn btn-secondary" [routerLink]="['/settings/port/edit', 'create']"><i class="fa fa-file-o"></i>
            New</a>
    </div>
</div>

<span>Nº Resultados: {{count}}</span>

<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Codigo</th>
                <th nowrap="nowrap">Nombre</th>
                <th nowrap="nowrap">Cod. Corto</th>
                <th nowrap="nowrap">Cod. EDI</th>
                <th nowrap="nowrap">R. Aduanero</th>
                <th nowrap="nowrap">UNlocode</th>
                <th nowrap="nowrap">A. Portuaria</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of resultList.list">
                <td><a [routerLink]="['/settings/port/detail', item.id]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.codigo"></td>
                <td nowrap="nowrap" [innerHTML]="item.nombre"></td>
                <td nowrap="nowrap" [innerHTML]="item.codigo"Corto></td>
                <td nowrap="nowrap" [innerHTML]="item.codigoEdi"></td>
                <td nowrap="nowrap" [innerHTML]="item.recAduanero"></td>
                <td nowrap="nowrap" [innerHTML]="item.unlocode"></td>
                <td nowrap="nowrap" [innerHTML]="item.sprt.etiqueta"></td>
            </tr>
        </tbody>
    </table>
</div>

<ng-template #filter let-c="close" let-d="dismiss">
<div class="modal-header">
    <h4 class="modal-title">Search Filter</h4>
    <button type="button" class="close" aria-label="Close" (click)="d('Cross click')">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<div class="modal-body">
    <fieldset class="form-group">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 col-lg-1 form-group-sm">
                    <label>Código</label> <input type="text" [(ngModel)]="model.codigo" name="value"
                        class="form-control form-control-sm" />
                </div>
                <div class="col-sm-4 col-md-3 col-lg-2 form-group-sm">
                    <label>A. Portuaria</label>
                    <select class="form-control form-control-sm" [(ngModel)]="model.sprtId">
                        <option></option>
                        <option *ngFor="let sprt of sprtList" [ngValue]="sprt.id" [innerHTML]="sprt.etiqueta"></option>
                    </select>
                </div>
            </div>
        </div>
    </fieldset>
</div>
<div class="modal-footer">
    <div class="btn-group">
        <button type="button" class="btn btn-primary" (click)="saveFilter();c()">Search</button>
        <button type="button" class="btn btn-secondary" (click)="resetFilter()">Reset</button>
        <button type="button" class="btn btn-secondary" (click)="c('Close click')">Close</button>
    </div>
</div>
</ng-template>
    `
} )
export class PortGridComponent implements OnInit {
    model: any = {};
    resultList: any = {};

    page: number;
    pageSize: number;
    count: number;

    sprtList: any[] = [];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private prtoService: PortService
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
        this.prtoService.listPage( this.model, this.page, this.pageSize ).subscribe( resp => {
            this.model = resp.model;
            this.resultList = resp.resultList;
            this.count = resp.resultList.count;

            this.location.replaceState( "/settings/port/grid;page=" + this.page + ";model=" + JSON.stringify( this.model ) );
        } );
    }

    pageChange() {
        // console.log( "Page change: " + this.page );
        this.doSearch();
    }

    editFilter( filter ) {
        // console.log( "Edit Filter" );
        this.prtoService.filter( this.model ).subscribe( resp => {
            this.sprtList = resp.sprtList;

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
}
