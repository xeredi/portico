import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ParameterService } from '../item/parameter.service';
import { SubparameterService } from './subparameter.service';

@Component( {
    selector: 'app-parameter-detail',
    templateUrl: './parameter-detail.component.html'
} )
export class ParameterDetailComponent implements OnInit {
    enti: any;
    model: any;

    i18nMap: any;
    availableLanguages: any;

    itemHijosMap: any;
    entiHijasMap: any;
    pageMap: Map<string, number>;

    activeTab: string;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private prmtService: ParameterService
        , private sprmService: SubparameterService
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";
            this.pageMap = params['pageMap'] ? JSON.parse( params['pageMap'] ) : {};

            this.prmtService.detail( { entiId: +params['entiId'], id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.enti = resp.enti;
                    this.model = resp.model;

                    this.i18nMap = resp.i18nMap;
                    this.availableLanguages = resp.availableLanguages;

                    this.entiHijasMap = {};
                    this.itemHijosMap = {};

                    for ( var index = 0; index < this.enti.entiHijasList.length; index++ ) {
                        var entiHijaId = this.enti.entiHijasList[index];

                        this.doSprmSearch( this.model.id, entiHijaId, this.model.fref, this.pageMap[entiHijaId] ? this.pageMap[entiHijaId] : 1 );
                    }
                } );
        } );
    }

    private doSprmSearch( prmtId: number, entiId: number, fref: any, page: number ) {
        this.sprmService.listPage( {
            prmt: {
                id: prmtId
            },
            entiId: entiId,
            fechaVigencia: fref
        }, 1, this.pageSize ).subscribe( resp => {
            this.entiHijasMap[entiId] = resp.enti;
            this.itemHijosMap[entiId] = resp.resultList;
            this.pageMap[entiId] = resp.page;
        } );
    }

    remove() {
        console.log( "Remove" );

        this.prmtService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    pageChange( pageId: string ) {
        //        this.doAslnSearch();
    }

    /*
    private doAslnSearch() {
        this.aslnService.listPage( {
            vlrcId: this.model.id
        }, this.pageMap['aslnList'] ? this.pageMap['aslnList'] : 1, this.pageSize ).subscribe( resp => {
            this.aslnList = resp.resultList;
            this.pageMap['aslnList'] = resp.page;

            this.replaceState();
        } );
    }
*/

    private replaceState() {
        this.location.replaceState( "/master/parameter/detail/" + this.model.entiId
            + "/" + this.model.id + "/" + this.model.fref
            + ";activeTab=" + this.activeTab
            + ";pageMap=" + encodeURIComponent( JSON.stringify( this.pageMap ) ) );
    }
}
