import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ParameterTypeService } from './parameter-type.service';
import { I18nInfoDetailComponent } from '../settings/i18n-info-detail.component';

@Component( {
    selector: 'app-parameter-type-detail',
    templateUrl: './parameter-type-detail.component.html'
} )
export class ParameterTypeDetailComponent implements OnInit {
    model: any;
    endgList: any[];
    endtList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    activeTab: string;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private prtpService: ParameterTypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";

            this.prtpService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.endgList = resp.engdList;
                    this.endtList = resp.entdList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.prtpService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        console.log( "Tab Change -> activeId:" + $event.activeId + " nextId:" + $event.nextId );

        this.activeTab = $event.nextId;

        this.replaceState();
    };

    private replaceState() {
        // console.log( "path with hash: " + this.location.path( true ) );
        // console.log( "path without hash: " + this.location.path( false ) );
        this.location.replaceState( "/metamodel/parameter-type/detail/" + this.model.id + ";activeTab=" + this.activeTab );
    }
}
