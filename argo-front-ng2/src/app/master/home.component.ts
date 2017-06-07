import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { MasterService } from './master.service';

@Component( {
    selector: 'app-home',
    templateUrl: './home.component.html'
} )
export class HomeComponent implements OnInit {
    resultList: any;

    constructor(
        private mstrService: MasterService
    ) {
    }

    ngOnInit() {
        this.mstrService.index().subscribe( resp => {
            this.resultList = resp.resultList;
        } );
    }
}
