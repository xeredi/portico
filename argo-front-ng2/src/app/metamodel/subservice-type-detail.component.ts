import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { SubserviceTypeService } from './subservice-type.service';

@Component( {
    selector: 'app-subservice-type-detail',
    templateUrl: './subservice-type-detail.component.html',
} )
export class SubserviceTypeDetailComponent implements OnInit {
    model: any;
    endgList: any[];
    endtList: any[];
    enacList: any[];
    acesList: any[];
    entiHijasList: any[];
    entiPadresList: any[];
    trmtList: any[];

    i18nMap: Map<string, any>;
    availableLanguages: string[];

    activeTab: string;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private sstpService: SubserviceTypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";

            this.sstpService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.endgList = resp.engdList;
                    this.endtList = resp.entdList;
                    this.enacList = resp.acenList;
                    this.acesList = resp.acesList;
                    this.entiHijasList = resp.entiHijasList;
                    this.entiPadresList = resp.entiPadresList;
                    this.trmtList = resp.trmtList;

                    this.availableLanguages = resp.availableLanguages;
                    this.i18nMap = resp.i18nMap;
                } );
        } );
    }

    remove() {
        this.sstpService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    private replaceState() {
        this.location.replaceState( "/metamodel/subservice-type/detail/" + this.model.id + ";activeTab=" + this.activeTab );
    }
}
