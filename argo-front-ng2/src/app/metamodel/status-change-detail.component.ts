import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { StatusChangeService } from './status-change.service';

@Component( {
    selector: 'app-status-change-detail',
    templateUrl: './status-change-detail.component.html'
} )
export class StatusChangeDetailComponent implements OnInit {
    model: any;
    enti: any;
    trtdList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private stchService: StatusChangeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.stchService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.enti = resp.enti;
                    this.trtdList = resp.trtdList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.stchService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
