import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { NgbTabChangeEvent } from '@ng-bootstrap/ng-bootstrap';

import { ParameterService } from '../item/parameter.service';
import { SubparameterService } from './subparameter.service';

@Component( {
    selector: 'app-subparameter-detail',
    templateUrl: './subparameter-detail.component.html'
} )
export class SubparameterDetailComponent implements OnInit {
    enti: any;
    model: any;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private sprmService: SubparameterService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.sprmService.detail( { entiId: +params['entiId'], id: +params['id'], fref: params['date'] } )
                .subscribe( resp => {
                    this.enti = resp.enti;
                    this.model = resp.model;
                } );
        } );
    }

    remove() {
        console.log( "Remove" );

        this.sprmService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
