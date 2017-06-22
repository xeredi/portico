import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { EntityDatatypeService } from './entity-datatype.service';

@Component( {
    selector: 'app-entity-datatype-detail',
    templateUrl: './entity-datatype-detail.component.html'
} )
export class EntityDatatypeDetailComponent implements OnInit {
    model: any;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private endtService: EntityDatatypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.endtService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.endtService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
