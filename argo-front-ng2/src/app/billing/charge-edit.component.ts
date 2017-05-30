import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ChargeService } from './charge.service';

@Component( {
    selector: 'app-charge-edit',
    templateUrl: './charge-edit.component.html'
} )
export class ChargeEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    srtpList: any[];
    chtpList: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private chrgService: ChargeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.chrgService.edit( this.action, { id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};

                    this.srtpList = resp.tpsrList;
                    this.chtpList = resp.tipos;
                } );
        } );
    }

    save() {
        this.chrgService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/billing/charge/detail', resp.model.id, resp.model.fref], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
