import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { AspectService } from './aspect.service';

@Component( {
    selector: 'app-aspect-detail',
    templateUrl: './aspect-detail.component.html'
} )
export class AspectDetailComponent implements OnInit {
    model: any;
    chrgList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private aspcService: AspectService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.aspcService.detail( { id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.chrgList = resp.ascrList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.aspcService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
