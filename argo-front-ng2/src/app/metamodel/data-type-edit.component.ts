import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { DataTypeService } from './data-type.service';

@Component( {
    selector: 'app-data-type-edit',
    templateUrl: './data-type-edit.component.html'
} )
export class DataTypeEditComponent implements OnInit {
    model: any;
    action: string;

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    tphtList: any[];
    tpelList: any[];
    tpprList: any[];
    tpsrList: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private dttyService: DataTypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.dttyService.edit( this.action, { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap ? resp.i18nMap : {};

                    this.tphtList = resp.tphtList;
                    this.tpelList = resp.tpelList;
                    this.tpprList = resp.tpprList;
                    this.tpsrList = resp.tpsrList;
                } );
        } );
    }

    save() {
        this.dttyService.saveI18n( this.action, this.model, this.i18nMap )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/data-type/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
