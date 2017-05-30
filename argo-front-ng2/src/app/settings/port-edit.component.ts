import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { PortService } from './port.service';

@Component( {
    selector: 'app-port-edit',
    template: `
<div *ngIf="model">
    <form role="form" (ngSubmit)="save()">
        <fieldset class="form-group">
            <div class="row">
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>Código</label>
                    <p *ngIf="action == 'edit'" class="form-control-static form-control-sm">{{model.codigo}}</p>
                    <input *ngIf="action != 'edit'" type="text" [(ngModel)]="model.codigo" name="model.codigo"
                        class="form-control form-control-sm" />
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>Cod. Corto</label>
                    <input type="text" [(ngModel)]="model.codigoCorto" name="model.codigoCorto"
                        class="form-control form-control-sm" />
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>Cod. EDI</label>
                    <input type="text" [(ngModel)]="model.codigoEdi" name="model.codigoEdi"
                        class="form-control form-control-sm" />
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>R. Aduanero</label>
                    <input type="text" [(ngModel)]="model.recAduanero" name="model.recAduanero"
                        class="form-control form-control-sm" />
                </div>
                <div class="col-sm-3 col-lg-2 col-xl-1 form-group-sm">
                    <label>UNlocode</label>
                    <input type="text" [(ngModel)]="model.unlocode" name="model.unlocode"
                        class="form-control form-control-sm" />
                </div>
                <div class="col-sm-4 col-lg-3 col-xl-2 form-group-sm">
                    <label>A. Portuaria</label>
                    <select class="form-control form-control-sm" [(ngModel)]="model.sprt.id" name="model.sprt.id">
                        <option></option>
                        <option *ngFor="let sprt of sprtList" [ngValue]="sprt.id" [innerHTML]="sprt.etiqueta"></option>
                    </select>
                </div>
            </div>

            <app-i18n-info-edit [(i18nMap)]="i18nMap" [availableLanguages]="availableLanguages"></app-i18n-info-edit>
        </fieldset>

        <div class="btn-group">
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-check"></i> Save
            </button>
            <button type="button" (click)="cancel()" class="btn btn-secondary">
                <i class="fa fa-close"></i> Cancel
            </button>
        </div>
    </form>
</div>
    `
} )
export class PortEditComponent implements OnInit {
    model: any;
    action: string;
    id: number;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    sprtList: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private prtoService: PortService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];
            this.id = params['id'];

            this.prtoService.edit( this.action, { id: this.id } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};

                    this.sprtList = resp.sprtList;
                } );
        } );
    }

    save() {
        this.prtoService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back() : this.router.navigate( ['/settings/port/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
