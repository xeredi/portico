import { Component, OnInit } from '@angular/core';

import { ConfigurationService } from './configuration.service';

@Component( {
    selector: 'app-configuration-grid',
    templateUrl: './configuration-grid.component.html'
} )
export class ConfigurationGridComponent implements OnInit {

    confList: any[] = [];

    constructor( private confService: ConfigurationService ) {
    }

    ngOnInit() {
        console.log( "ConfigurationGrid" );

        this.confService.list( {} ).subscribe( resp => {
            this.confList = resp.resultList;
        } );
    }
}
