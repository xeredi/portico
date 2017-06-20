import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { EntityActionService } from './entity-action.service';

@Component( {
    selector: 'app-entity-action-detail',
    templateUrl: './entity-action-detail.component.html'
} )
export class EntityActionDetailComponent implements OnInit {
    model: any;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private enacService: EntityActionService
    ) { }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.enacService.detail( { id: +params['id'] } )
                .subscribe( resp => {
                    this.model = resp.model;
                } );
        } );
    }

    remove() {
        this.enacService.remove( this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }
}
