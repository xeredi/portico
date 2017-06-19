import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { SpecialActionService } from './special-action.service';

@Component( {
    selector: 'app-special-action-detail',
    templateUrl: './special-action-detail.component.html'
} )
export class SpecialActionDetailComponent implements OnInit {
    model: any;
    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private spacService: SpecialActionService
    ) { }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.spacService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.spacService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

}
