import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { SuperportService } from './superport.service';

@Component( {
    selector: 'app-superport-edit',
    templateUrl: './superport-edit.component.html'
} )
export class SuperportEditComponent implements OnInit {
    model: any = {};
    action: string;
    id: number;
    i18nMap: any = {};
    availableLanguages: string[] = [];

    constructor( private location: Location, private route: ActivatedRoute,
        private router: Router, private sprtService: SuperportService ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];
            this.id = params['id'];

            this.sprtService.edit( this.action, { id: this.id } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    save() {
        this.sprtService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    cancel() {
        this.location.back();
    }
}
