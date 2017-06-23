import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { EntityDatatypeService } from './entity-datatype.service';

@Component( {
    selector: 'app-entity-datatype-edit',
    templateUrl: './entity-datatype-edit.component.html'
} )
export class EntityDatatypeEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    dttyList: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private endtService: EntityDatatypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.endtService.edit( this.action, { id: +params['id'], entiId: +params['entityId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};

                    this.dttyList = resp.tpdtList;
                } );
        } );
    }

    save() {
        this.endtService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/entity-datatype/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
