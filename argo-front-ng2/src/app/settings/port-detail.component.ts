import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { PortService } from './port.service';

@Component( {
    selector: 'app-port-detail',
    template: `
<div class="container-fluid" *ngIf="model">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <a class="btn btn-primary" [routerLink]="['/settings/port/edit', 'edit', model.id]"><i
                class="fa fa-edit"></i> Edit</a>
            <button class="btn btn-secondary" (click)="remove()">
                <i class="fa fa-remove"></i> Remove
            </button>
        </div>
    </div>

    <form>
        <fieldset class="form-group">
            <div class="row">
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>Código</label>
                    <p class="form-control-static form-control-sm" [innerHTML]="model.codigo"></p>
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>Cod. Corto</label>
                    <p class="form-control-static form-control-sm" [innerHTML]="model.codigoCorto"></p>
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>Cod. EDI</label>
                    <p class="form-control-static form-control-sm" [innerHTML]="model.codigoEdi"></p>
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>R. Aduanero</label>
                    <p class="form-control-static form-control-sm" [innerHTML]="model.recAduanero"></p>
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>UNlocode</label>
                    <p class="form-control-static form-control-sm" [innerHTML]="model.unlocode"></p>
                </div>
                <div class="col-sm-4 col-lg-3 col-xl-2 form-group-sm">
                    <label>A. Portuaria</label>
                    <p class="form-control-static form-control-sm">
                        <a *ngIf="model.sprt?.id" [routerLink]="['/settings/superport/detail', model.sprt.id]" [innerHTML]="model.sprt?.etiqueta"></a>
                    </p>
                </div>
            </div>

            <app-i18n-info-detail [i18nMap]="i18nMap" [availableLanguages]="availableLanguages"></app-i18n-info-detail>
        </fieldset>
    </form>
</div>
    `
} )
export class PortDetailComponent implements OnInit {
    model: any = {};

    i18nMap: Map<string, any> = new Map<string, any>();
    availableLanguages: string[] = [];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private prtoService: PortService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.prtoService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.prtoService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
