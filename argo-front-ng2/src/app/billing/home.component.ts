import { Component, OnInit } from '@angular/core';

@Component( {
    selector: 'app-home',
    template: `
<p>Billing</p>

<p>
    <a [routerLink]="['/billing/charge/grid']">Charges</a> - <a [routerLink]="['/billing/assessment/grid']">Assessments</a>
</p>
    `
} )
export class HomeComponent implements OnInit {

    constructor() { }

    ngOnInit() {
    }

}
