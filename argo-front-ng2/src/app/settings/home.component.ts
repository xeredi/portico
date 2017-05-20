import { Component, OnInit } from '@angular/core';

@Component( {
    selector: 'app-home',
    template: `
<p>Settings</p>

<p>
    <a [routerLink]="['/settings/superport/grid']">Port Authorities</a> - <a [routerLink]="['/settings/port/grid']">Ports</a>
    - <a [routerLink]="['/settings/configuration/grid']">Configuration</a> - <a
        [routerLink]="['/settings/i18n-message/grid']">I18n</a>
</p>
    `
} )
export class HomeComponent implements OnInit {

    constructor() { }

    ngOnInit() {
    }

}
