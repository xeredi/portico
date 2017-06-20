import { Component, OnInit } from '@angular/core';

@Component( {
    selector: 'app-home',
    template: `
<p>Metamodel</p>

<p>
    <a [routerLink]="['/metamodel/parameter-type/grid']">Parameter Types</a>
    - <a [routerLink]="['/metamodel/service-type/grid']">Service Types</a>
    - <a [routerLink]="['/metamodel/module/grid']">Modules</a>
    - <a [routerLink]="['/metamodel/data-type/grid']">Data Types</a>
</p>
    `
} )
export class HomeComponent implements OnInit {

    constructor() { }

    ngOnInit() {
    }

}
