import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { SpecialActionService } from './special-action.service';

@Component( {
    selector: 'app-special-action-edit',
    templateUrl: './special-action-edit.component.html'
} )
export class SpecialActionEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private spacService: SpecialActionService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.spacService.edit( this.action, { id: +params['id'], entiId: +params['entityId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};
                } );
        } );
    }

    save() {
        this.spacService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/special-action/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
