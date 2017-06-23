import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { EntityActionService } from './entity-action.service';

@Component( {
    selector: 'app-entity-action-edit',
    templateUrl: './entity-action-edit.component.html'
} )
export class EntityActionEditComponent implements OnInit {
    model: any;
    action: string;

    aebsList: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private enacService: EntityActionService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.enacService.edit( this.action, { id: +params['id'], entiId: +params['entityId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.aebsList = resp.aebsList;
                } );
        } );
    }

    save() {
        this.enacService.save( this.action, this.model )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/metamodel/entity-action/detail', resp.model.id], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
