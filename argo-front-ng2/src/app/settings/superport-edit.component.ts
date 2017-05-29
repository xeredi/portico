import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { SuperportService } from './superport.service';
import { I18nInfoService } from '../shared/i18n-info.service';

@Component( {
    selector: 'app-superport-edit',
    template: `
<div *ngIf="model">
    <form role="form" (ngSubmit)="save()">
        <fieldset class="form-group">
            <div class="row">
                <div class="col-sm-3 col-md-2 col-lg-1 form-group-sm">
                    <label>Código</label>
                    <p *ngIf="action == 'edit'" class="form-control-static form-control-sm" [innerHTML]="model.codigo"></p>
                    <input *ngIf="action != 'edit'" type="text" [(ngModel)]="model.codigo" name="model.codigo"
                        class="form-control form-control-sm" />
                </div>
            </div>

            <app-i18n-info-edit name="i18nMap" [i18nMap]="i18nMap" [availableLanguages]="availableLanguages"></app-i18n-info-edit>
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
export class SuperportEditComponent implements OnInit {
    model: any;
    action: string;
    id: number;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private sprtService: SuperportService
        , private i18iService: I18nInfoService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];
            this.id = params['id'];

            this.sprtService.edit( this.action, { id: this.id } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = this.i18iService.normalize( resp.i18nMap, resp.availableLanguages );
                } );
        } );
    }

    save() {
        this.sprtService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    cancel() {
        this.location.back();
    }
}
