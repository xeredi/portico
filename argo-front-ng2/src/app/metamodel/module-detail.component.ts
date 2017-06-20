import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ModuleService } from './module.service';

@Component( {
    selector: 'app-module-detail',
    templateUrl: './module-detail.component.html'
} )
export class ModuleDetailComponent implements OnInit {
    model: any;
    grpoList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private mdleService: ModuleService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.mdleService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.grpoList = resp.grpoList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.mdleService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
