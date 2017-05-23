import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { SuperportService } from './superport.service';

@Component( {
    selector: 'app-superport',
    templateUrl: './superport.component.html'
} )
export class SuperportComponent implements OnInit {
    model: any = {};

    i18nMap: Map<string, any> = new Map<string, any>();
    availableLanguages: string[] = [];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private sprtService: SuperportService ) {
    }

    ngOnInit() {
        this.route.params
            .switchMap(( params: Params ) => this.sprtService.detail( { id: params['id'] } ) )
            .subscribe( resp => {
                this.model = resp.model;
                this.i18nMap = resp.i18nMap;
                this.availableLanguages = resp.availableLanguages;
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
