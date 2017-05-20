import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';

import { ConfigurationService } from './configuration.service';

@Component( {
    selector: 'app-configuration',
    templateUrl: './configuration.component.html'
} )
export class ConfigurationComponent implements OnInit {

    conf: any[] = [];

    constructor( private route: ActivatedRoute,
        private router: Router, private confService: ConfigurationService ) {
    }

    ngOnInit() {
        this.route.params
            .switchMap(( params: Params ) => this.confService.detail( { key: params['key'] } ) )
            .subscribe( resp => {
                this.conf = resp.model;
            } );
    }
}
