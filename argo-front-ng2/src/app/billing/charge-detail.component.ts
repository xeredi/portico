import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ChargeService } from './charge.service';
import { I18nInfoDetailComponent } from '../settings/i18n-info-detail.component';

@Component( {
    selector: 'app-charge-detail',
    templateUrl: './charge-detail.component.html'
} )
export class ChargeDetailComponent implements OnInit {
    model: any;
    ruleList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private chrgService: ChargeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.chrgService.detail( { id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.ruleList = resp.rglaList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.chrgService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
