import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';

import { I18nMessageService } from './i18n-message.service';

@Component( {
    selector: 'app-i18n-message',
    templateUrl: './i18n-message.component.html'
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
