import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { SuperportService } from './superport.service';
import { I18nInfoService } from './i18n-info.service';

@Component( {
    selector: 'app-superport-detail',
    template: `
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-primary" [routerLink]="['/settings/superport/edit', 'edit', model.id]"><i
            class="fa fa-edit"></i> Edit</a>
        <button class="btn btn-secondary" (click)="remove()">
            <i class="fa fa-remove"></i> Remove
        </button>
    </div>
</div>

<form>
    <fieldset class="form-group">
        <div class="row">
            <div class="col-sm-3 col-md-2 col-lg-1 form-group-sm">
                <label>Código</label>
                <p class="form-control-static form-control-sm">{{model.codigo}}</p>
            </div>
        </div>

        <app-i18n-info-detail [i18nMap]="i18nMap" [availableLanguages]="availableLanguages"></app-i18n-info-detail>
    </fieldset>
</form>
    `
} )
export class SuperportDetailComponent implements OnInit {
    model: any = {};

    i18nMap: Map<string, any> = new Map<string, any>();
    availableLanguages: string[] = [];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private sprtService: SuperportService
        , private i18iService: I18nInfoService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.sprtService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = this.i18iService.normalize( resp.i18nMap, resp.availableLanguages );
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.sprtService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
