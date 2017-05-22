import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';

import { I18nMessageService } from './i18n-message.service';

@Component( {
    selector: 'app-i18n-message',
    template: `
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-primary" [routerLink]="['/settings/i18n-message/edit', 'edit', key]"><i class="fa fa-edit"></i>
            Edit</a>
    </div>
</div>

<form>
    <fieldset class="form-group">
        <div class="row">
            <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                <label>Clave</label>
                <p class="form-control-static form-control-sm">{{key}}</p>
            </div>
            <div *ngFor="let availableLanguage of availableLanguages" class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                <label>{{availableLanguage}}</label>
                <p class="form-control-static form-control-sm">{{i18nMap[availableLanguage]?.value}}</p>
            </div>
        </div>
    </fieldset>
</form>
    `
} )
export class I18nMessageComponent implements OnInit {
    key: string;
    i18nMap: any;
    availableLanguages: string;

    constructor( private route: ActivatedRoute,
        private router: Router, private m18nService: I18nMessageService ) {
    }

    ngOnInit() {
        this.route.params
            .switchMap(( params: Params ) => this.m18nService.detail( params['key'] ) )
            .subscribe( resp => {
                this.key = resp.model;
                this.i18nMap = resp.i18nMap;
                this.availableLanguages = resp.availableLanguages;
            } );
    }

}
