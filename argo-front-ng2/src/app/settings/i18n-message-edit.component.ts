import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { I18nMessageService } from './i18n-message.service';

@Component( {
    selector: 'app-i18n-message-edit',
    template: `
<div class="container-fluid">
    <form role="form" (ngSubmit)="save()">
        <fieldset class="form-group">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                        <label>Clave</label>
                        <p class="form-control-static form-control-sm">{{key}}</p>
                    </div>
                    <div *ngFor="let availableLanguage of availableLanguages"
                        class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                        <label>{{availableLanguage}}</label> <input type="text"
                            [ngModel]="i18nMap[availableLanguage]?.value"
                            (ngModelChange)="i18nMap[availableLanguage].value=$event"
                            name="i18nMap[{{availableLanguage}}].value" class="form-control form-control-sm" />
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-check"></i> <span>Save</span>
            </button>
            <button type="button" (click)="cancel()" class="btn btn-default">
                <i class="fa fa-close"></i> <span>Cancel</span>
            </button>
        </div>
    </form>
</div>
    `
} )
export class I18nMessageEditComponent implements OnInit {
    model: any;
    action: string;
    key: string;
    i18nMap: any;
    availableLanguages: string[];

    constructor( private location: Location, private route: ActivatedRoute,
        private router: Router, private m18nService: I18nMessageService ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];
            this.key = params['key'];

            this.m18nService.edit( this.action, this.key )
                .subscribe( resp => {
                    this.key = resp.model;
                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;

                    for ( let availableLanguage of this.availableLanguages ) {
                        if ( !this.i18nMap[availableLanguage] ) {
                            this.i18nMap[availableLanguage] = {};
                        }
                    }
                } );
        } );
    }

    save() {
        this.m18nService.saveI18n( this.action, this.key, this.i18nMap )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    cancel() {
        this.location.back();
    }
}
