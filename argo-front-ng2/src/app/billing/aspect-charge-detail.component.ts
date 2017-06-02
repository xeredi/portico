import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { AspectChargeService } from './aspect-charge.service';

@Component( {
    selector: 'app-aspect-charge-detail',
    templateUrl: './aspect-charge-detail.component.html'
} )
export class AspectChargeDetailComponent implements OnInit {
    model: any;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private ascrService: AspectChargeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.ascrService.detail( { id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.ascrService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
