import { Component, OnInit } from '@angular/core';

@Component( {
    moduleId: module.id,
    template: `
<div class="row">
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/service']">Services</a>
        </h3>
      </div>
    </div>
  </div>
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/billing']">Billing</a>
        </h3>
      </div>
    </div>
  </div>
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/master']">Masters</a>
        </h3>
      </div>
    </div>
  </div>
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/batch']">Batch</a>
        </h3>
      </div>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/settings']">Settings</a>
        </h3>
      </div>
    </div>
  </div>
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/security']">Security</a>
        </h3>
      </div>
    </div>
  </div>
  <div class="col-lg-4 col-xl-3">
    <div class="card">
      <div class="card-block">
        <h3 class="card-title">
            <a [routerLink]="['/metamodel']">Metamodel</a>
        </h3>
      </div>
    </div>
  </div>
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