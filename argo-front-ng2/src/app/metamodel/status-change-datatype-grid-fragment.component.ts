import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-status-change-datatype-grid-fragment',
    templateUrl: './status-change-datatype-grid-fragment.component.html'
} )
export class StatusChangeDatatypeGridFragmentComponent  {
    @Input() itemList;

    constructor() { }
}
