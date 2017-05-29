import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { AssessmentLineService } from './assessment-line.service';
import { AssessmentDetailService } from './assessment-detail.service';

@Component( {
    selector: 'app-assessment-line-detail',
    templateUrl: './assessment-line-detail.component.html'
} )
export class AssessmentLineDetailComponent implements OnInit {
    model: any;
    aspect: any;
    aslnParent: any;
    aslnChildList: any[];

    asdtList: any[];

    activeTab: string;
    pageMap: Map<string, number>;
    pageSize: number;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private aslnService: AssessmentLineService
        , private asdtService: AssessmentDetailService
    ) {
    }

    ngOnInit() {
        this.pageSize = 20;

        this.route.params.subscribe( params => {
            this.activeTab = params['activeTab'] ? params['activeTab'] : "mainTab";
            this.pageMap = params['pageMap'] ? JSON.parse( params['pageMap'] ) : {};

            this.aslnService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                    this.aspect = resp.aspc;
                    this.aslnParent = resp.vlrlPadre;
                    this.aslnChildList = resp.vlrlHijosList;

                    this.doAsdtSearch();
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.aslnService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    tabChange( $event: NgbTabChangeEvent ) {
        this.activeTab = $event.nextId;

        this.replaceState();
    };

    pageChange( pageId: string ) {
        this.doAsdtSearch();
    }

    private doAsdtSearch() {
        this.asdtService.listPage( {
            vlrlId: this.model.id
        }, this.pageMap['asdtList'] ? this.pageMap['asdtList'] : 1, this.pageSize ).subscribe( resp => {
            this.asdtList = resp.resultList;
            this.pageMap['asdtList'] = resp.page;

            this.replaceState();
        } );
    }

    private replaceState() {
        this.location.replaceState( "/billing/assessment-line/detail/" + this.model.id + ";activeTab=" + this.activeTab
            + ";pageMap=" + encodeURIComponent( JSON.stringify( this.pageMap ) ) );
    }
}
