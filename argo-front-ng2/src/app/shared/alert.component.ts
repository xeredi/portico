import { Component, OnInit } from '@angular/core';

import { AlertService } from './alert.service';

@Component( {
    /*    moduleId: module.id,*/
    selector: 'alert',
    template: `
<div *ngIf="messages"
    [ngClass]="{ 'alert': messages, 'alert-success': messages.type === 'success', 'alert-danger': messages.type === 'error' }">
    <ul>
        <li *ngFor="let message of messages.text">{{message}}</li>
    </ul>
</div>
    `
} )
export class AlertComponent {
    messages: any;

    constructor( private alertService: AlertService ) { }

    ngOnInit() {
        this.alertService.getMessages().subscribe( messages => { this.messages = messages; } );
    }
}