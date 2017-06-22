import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-entity-grid-fragment',
    templateUrl: './entity-grid-fragment.component.html'
} )
export class EntityGridFragmentComponent {
    @Input() itemList: any[];

    constructor() { }
}
