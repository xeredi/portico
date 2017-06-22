import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ReferenceCodeService } from './reference-code.service';

@Component( {
    selector: 'app-reference-code-detail',
    templateUrl: './reference-code-detail.component.html'
} )
export class ReferenceCodeDetailComponent implements OnInit {
    model: any;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private rfcdService: ReferenceCodeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.rfcdService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.rfcdService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
