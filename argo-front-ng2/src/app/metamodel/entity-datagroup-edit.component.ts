import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { EntityDatagroupService } from './entity-datagroup.service';

@Component( {
    selector: 'app-entity-datagroup-edit',
    templateUrl: './entity-datagroup-edit.component.html'
} )
export class EntityDatagroupEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private endgService: EntityDatagroupService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.endgService.edit( this.action, { id: +params['id'], entiId: +params['entityId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};
                } );
        } );
    }

    save() {
        this.endgService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/entity-datagroup/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
