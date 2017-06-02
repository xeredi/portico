import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { AspectChargeService } from './aspect-charge.service';

@Component( {
    selector: 'app-aspect-charge-edit',
    templateUrl: './aspect-charge-edit.component.html'
} )
export class AspectChargeEditComponent implements OnInit {
    model: any;
    action: string;

    chrgList: any[];

    constructor(
        private location: Location
        , private route: ActivatedRoute
        , private router: Router
        , private aschService: AspectChargeService
    ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];

            this.aschService.edit( this.action, { id: +params['id'], fref: params['date'], aspcId: +params['aspectId'] } )
                .subscribe( resp => {
                    this.model = resp.model;

                    this.chrgList = resp.crgoList;
                } );
        } );
    }

    save() {
        this.aschService.save( this.action, this.model )
            .subscribe( resp => {
                this.action == 'edit' ? this.location.back()
                    : this.router.navigate( ['/billing/aspect-charge/detail', resp.model.id, resp.model.fref], { replaceUrl: true } );
            } );
    }

    cancel() {
        this.location.back();
    }
}
