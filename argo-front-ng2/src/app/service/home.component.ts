import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ServiceHomeService } from './service-home.service';

@Component( {
    selector: 'app-home',
    templateUrl: './home.component.html'
} )
export class HomeComponent implements OnInit {
    resultList: any;
    tpssMap: any;

    constructor(
        private srvcService: ServiceHomeService
    ) {
    }

    ngOnInit() {
        this.srvcService.index().subscribe( resp => {
            this.resultList = resp.resultList;
            this.tpssMap = resp.tpssMap;
        } );
    }
}
