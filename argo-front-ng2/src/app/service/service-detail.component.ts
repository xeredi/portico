import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ServiceService } from '../item/service.service';
import { SubserviceService } from '../item/subservice.service';

@Component( {
    selector: 'app-service-detail',
    templateUrl: './service-detail.component.html'
} )
export class ServiceDetailComponent implements OnInit {
    enti: any;
    model: any;

    itemHijosMap: any;
    entiHijasMap: any;
    pageMap: Map<string, number>;

    srvcDepsList: any[];

    activeTab: string;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private srvcService: ServiceService
        , private ssrvService: SubserviceService
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";
            this.pageMap = params['pageMap'] ? JSON.parse( params['pageMap'] ) : {};

            this.srvcService.detail( { entiId: +params['entiId'], id: +params['id'] } )
                .subscribe( resp => {
                    this.enti = resp.enti;
                    this.model = resp.model;

                    this.srvcDepsList = resp.srvcDepsList;

                    this.entiHijasMap = {};
                    this.itemHijosMap = {};

                    for ( var index = 0; index < this.enti.entiHijasList.length; index++ ) {
                        var entiHijaId = this.enti.entiHijasList[index];

                        this.doSsrvSearch( this.model.id, entiHijaId );
                    }
                } );
        } );
    }

    private doSsrvSearch( srvcId: number, entiId: string ) {
        this.ssrvService.listPage( {
            srvc: {
                id: srvcId
            },
            entiId: entiId
        }, this.pageMap[entiId] ? this.pageMap[entiId] : 1, this.pageSize ).subscribe( resp => {
            this.entiHijasMap[entiId] = resp.enti;
            this.itemHijosMap[entiId] = resp.resultList;
            this.pageMap[entiId] = resp.page;

            this.replaceState();
        } );
    }

    remove() {
        this.srvcService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    pageChange( pageId: string ) {
        this.doSsrvSearch( this.model.id, pageId );
    }

    assessmentList() {
        console.log( "assessmentList" );

        this.router.navigateByUrl( "/billing/assessment/grid"
            + ";model=" + encodeURIComponent( JSON.stringify( {
                tpsrId: this.model.entiId,
                srvc: {
                    id: this.model.id,
                    entiId: this.model.entiId,
                    anno: this.model.anno,
                    numero: this.model.numero,
                    prto: this.model.prto
                }
            } ) )
        );
    }

    private replaceState() {
        this.location.replaceState( "/service/service/detail/" + this.model.entiId
            + "/" + this.model.id
            + ";activeTab=" + this.activeTab
            + ";pageMap=" + encodeURIComponent( JSON.stringify( this.pageMap ) ) );
    }
}
