import { Component, OnInit } from '@angular/core';

import { AlertService } from './alert.service';

@Component( {
    /*    moduleId: module.id,*/
    selector: 'alert',
    templateUrl: 'alert.component.html'
} )
export class AlertComponent {
    messages: any;

    constructor( private alertService: AlertService ) { }

    ngOnInit() {
        this.alertService.getMessages().subscribe( messages => { this.messages = messages; } );
    }
}