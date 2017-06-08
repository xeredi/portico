import { Component, OnInit } from '@angular/core';

@Component( {
    moduleId: module.id,
    template: `
<div class="col-md-6 col-md-offset-3">
    <h1>Hi {{currentUser.firstName}}!</h1>

    <ul class="list-group">
      <li class="list-group-item"><a [routerLink]="['/settings']">Settings</a></li>
      <li class="list-group-item"><a [routerLink]="['/metamodel']">Metamodel</a></li>
      <li class="list-group-item"><a [routerLink]="['/master/master-home']">Masters</a></li>
      <li class="list-group-item"><a [routerLink]="['/service']">Services</a></li>
      <li class="list-group-item"><a [routerLink]="['/security']">Security</a></li>
      <li class="list-group-item"><a [routerLink]="['/billing/billing-home']">Billing</a></li>
      <li class="list-group-item"><a [routerLink]="['/login']">Logout</a></li>
    </ul>
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