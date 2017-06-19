import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-subservice-type-grid-fragment',
    templateUrl: './subservice-type-grid-fragment.component.html'
} )
export class SubserviceTypeGridFragmentComponent {
    @Input() itemList: any[];

    constructor() { }

}
