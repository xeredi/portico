import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { StatusChangeDatatypeService } from './status-change-datatype.service';

@Component( {
    selector: 'app-status-change-datatype-detail',
    templateUrl: './status-change-datatype-detail.component.html'
} )
export class StatusChangeDatatypeDetailComponent implements OnInit {
    model: any;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private scdtService: StatusChangeDatatypeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.scdtService.detail( {
                trmtId: +params['statusChangeId']
                , entd: {
                    tpdt: { id: +params['dataTypeId'] }
                }
            } )
                .subscribe( resp => {
                    this.model = resp.model;
                } );
        } );
    }

    remove() {
        this.scdtService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}

