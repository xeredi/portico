import { Component, OnInit } from '@angular/core';

@Component( {
    moduleId: module.id,
    template: `
<div class="col-md-6 col-md-offset-3">
    <h1>Hi {{currentUser.firstName}}!</h1>
    <p>You're logged in with Angular 2!!</p>
    <p>
        <a [routerLink]="['/login']">Logout</a> - <a [routerLink]="['/settings']">Settings</a> - <a
            [routerLink]="['/security']">Security</a> - <a
            [routerLink]="['/metamodel']">Metamodel</a> - <a
            [routerLink]="['/billing']">Billing</a>
    </p>
</div>
    `
} )
export class HomeComponent implements OnInit {
    currentUser: any;

    constructor() {
        this.currentUser = JSON.parse( localStorage.getItem( 'currentUser' ) );
    }

    ngOnInit() {
    }
}