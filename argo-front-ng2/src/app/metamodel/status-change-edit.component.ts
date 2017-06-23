import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { StatusChangeService } from './status-change.service';

@Component( {
    selector: 'app-status-change-edit',
    templateUrl: './status-change-edit.component.html'
} )
export class StatusChangeEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    dttyStatus: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private stchService: StatusChangeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.stchService.edit( this.action, { id: +params['id'], entiId: +params['entityId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};

                    this.dttyStatus = resp.tpdtEstado;
                } );
        } );
    }

    save() {
        this.stchService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/status-change/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
