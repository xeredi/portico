import { Component, OnInit } from '@angular/core';

@Component( {
    selector: 'app-home',
    template: `
<p>Batch</p>

<p>
    <a [routerLink]="['/batch/process/grid']" [translate]="'prbtList'"></a>
</p>
    `
} )
export class HomeComponent implements OnInit {

    constructor() { }

    ngOnInit() {
    }

}
