import { Component, OnInit } from '@angular/core';

@Component( {
    selector: 'app-home',
    template: `
<p>Billing</p>

<p>
    <a [routerLink]="['/billing/charge/grid']" [translate]="'crgoList'"></a>
    - <a [routerLink]="['/billing/aspect/grid']" [translate]="'aspcList'"></a>
    - <a [routerLink]="['/billing/assessment/grid']" [translate]="'vlrcList'"></a>
</p>
    `
} )
export class HomeComponent implements OnInit {

    constructor() { }

    ngOnInit() {
    }

}
