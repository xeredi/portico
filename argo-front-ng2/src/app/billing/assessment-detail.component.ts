import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { AssessmentService } from './assessment.service';
import { AssessmentLineService } from './assessment-line.service';

@Component( {
    selector: 'app-assessment-detail',
    templateUrl: './assessment-detail.component.html'
} )
export class AssessmentDetailComponent implements OnInit {
    model: any;
    dttyExemptionCode: any;
    aspect: any;
    asstList: any[];
    asscList: any[];
    aslnList: any[];

    activeTab: string;
    pageMap: Map<string, number>;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private assmService: AssessmentService
        , private aslnService: AssessmentLineService
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";
            this.pageMap = params['pageMap'] ? JSON.parse( params['pageMap'] ) : {};

            this.assmService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.dttyExemptionCode = resp.tpdtCodExencion;
                    this.aspect = resp.aspc;
                    this.asscList = resp.vlrgList;
                    this.asstList = resp.vlriList;

                    this.doAslnSearch();
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.assmService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    pageChange( pageId: string ) {
        this.doAslnSearch();
    }

    private doAslnSearch() {
        this.aslnService.listPage( {
            vlrcId: this.model.id
        }, this.pageMap['aslnList'] ? this.pageMap['aslnList'] : 1, this.pageSize ).subscribe( resp => {
            this.aslnList = resp.resultList;
            this.pageMap['aslnList'] = resp.page;

            this.replaceState();
        } );
    }

    private replaceState() {
        this.location.replaceState( "/billing/assessment/detail/" + this.model.id + ";activeTab=" + this.activeTab
            + ";pageMap=" + encodeURIComponent( JSON.stringify( this.pageMap ) ) );
    }
}
