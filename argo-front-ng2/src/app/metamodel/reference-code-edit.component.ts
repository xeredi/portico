import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ReferenceCodeService } from './reference-code.service';

@Component( {
    selector: 'app-reference-code-edit',
    templateUrl: './reference-code-edit.component.html'
} )
export class ReferenceCodeEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private rfcdService: ReferenceCodeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.rfcdService.edit( this.action, { id: +params['id'], tpdtId: +params['datatypeId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};
                } );
        } );
    }

    save() {
        this.rfcdService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/reference-code/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
