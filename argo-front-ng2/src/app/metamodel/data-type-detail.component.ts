import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { DataTypeService } from './data-type.service';

@Component( {
    selector: 'app-data-type-detail',
    templateUrl: './data-type-detail.component.html'
} )
export class DataTypeDetailComponent implements OnInit {
    model: any;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private dttpService: DataTypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.dttpService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.dttpService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    private replaceState() {
        this.location.replaceState( "/metamodel/data-type/detail/" + this.model.id );
    }
}
