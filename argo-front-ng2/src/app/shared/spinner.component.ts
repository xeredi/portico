import { Component, OnInit } from '@angular/core';

import { SpinnerService } from './spinner.service';

@Component( {
    selector: 'app-spinner',
    templateUrl: './spinner.component.html'
} )
export class SpinnerComponent implements OnInit {

    isRunning: boolean;

    constructor( private spinnerService: SpinnerService ) {
        this.isRunning = false;
    }

    ngOnInit() {
        this.spinnerService.loaderStatus.subscribe(( val: boolean ) => {
            this.isRunning = val;
        } );
    }

}
