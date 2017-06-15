import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ProcessService } from './process.service';

@Component( {
    selector: 'argo-process-detail',
    templateUrl: './process-detail.component.html'
} )
export class ProcessDetailComponent implements OnInit {
    model: any;
    prpmMap: any;
    pritEntradaList: any;
    pritSalidaList: any;
    arinEntradaList: any;
    arinSalidaList: any;

    activeTab: string;
    pageMap: Map<string, number>;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private procService: ProcessService
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";
            this.pageMap = params['pageMap'] ? JSON.parse( params['pageMap'] ) : {};

            this.procService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.prpmMap = resp.prpmMap;
                    this.pritEntradaList = resp.pritEntradaList;
                    this.pritSalidaList = resp.pritSalidaList;
                    this.arinEntradaList = resp.arinEntradaList;
                    this.arinSalidaList = resp.arinSalidaList;
                } );
        } );
    }

    cancel() {
        console.log( "Cancel" );

        // Redirigir al detalle?
    }

    tabChange( $event: NgbTabChangeEvent ) {
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    pageChange( pageId: string ) {
        // this.doAslnSearch();
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
        this.location.replaceState( "/batch/process/detail/" + this.model.id + ";activeTab=" + this.activeTab
            + ";pageMap=" + encodeURIComponent( JSON.stringify( this.pageMap ) ) );
    }
}
