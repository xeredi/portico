import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';

import { SuperportService } from './superport.service';

@Component( {
    selector: 'app-superport',
    templateUrl: './superport.component.html'
} )
export class SuperportComponent implements OnInit {
    model: any = {};
    i18nMap: any = {};
    availableLanguages: string[] = [];

    constructor( private route: ActivatedRoute,
        private router: Router, private sprtService: SuperportService ) {
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
}
