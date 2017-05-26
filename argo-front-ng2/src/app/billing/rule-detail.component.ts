import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { RuleService } from './rule.service';
import { I18nInfoDetailComponent } from '../settings/i18n-info-detail.component';

@Component( {
    selector: 'app-rule-detail',
    templateUrl: './rule-detail.component.html'
} )
export class RuleDetailComponent implements OnInit {
    model: any;
    inrlList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private ruleService: RuleService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.ruleService.detail( { id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.inrlList = resp.rginList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.ruleService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
