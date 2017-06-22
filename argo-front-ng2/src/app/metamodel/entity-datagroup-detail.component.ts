import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { EntityDatagroupService } from './entity-datagroup.service';

@Component( {
    selector: 'app-entity-datagroup-detail',
    templateUrl: './entity-datagroup-detail.component.html'
} )
export class EntityDatagroupDetailComponent implements OnInit {
    model: any;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private endgService: EntityDatagroupService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.endgService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.endgService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
