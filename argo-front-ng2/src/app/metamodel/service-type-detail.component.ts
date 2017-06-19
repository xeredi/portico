import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ServiceTypeService } from './service-type.service';

@Component( {
    selector: 'app-service-type-detail',
    templateUrl: './service-type-detail.component.html'
} )
export class ServiceTypeDetailComponent implements OnInit {
    model: any;
    endgList: any[];
    endtList: any[];
    enacList: any[];
    acesList: any[];
    subentiList: any[];
    entiHijasList: any[];
    trmtList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    activeTab: string;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private srtpService: ServiceTypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";

            this.srtpService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.endgList = resp.engdList;
                    this.endtList = resp.entdList;
                    this.enacList = resp.acenList;
                    this.acesList = resp.acesList;
                    this.subentiList = resp.subentiList;
                    this.entiHijasList = resp.entiHijasList;
                    this.trmtList = resp.trmtList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.srtpService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        // console.log( "Tab Change -> activeId:" + $event.activeId + " nextId:" + $event.nextId );
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    private replaceState() {
        // console.log( "path with hash: " + this.location.path( true ) );
        // console.log( "path without hash: " + this.location.path( false ) );
        this.location.replaceState( "/metamodel/service-type/detail/" + this.model.id + ";activeTab=" + this.activeTab );
    }
}
