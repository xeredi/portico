import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-status-change-grid-fragment',
    templateUrl: './status-change-grid-fragment.component.html'
} )
export class StatusChangeGridFragmentComponent {
    @Input() itemList: any[];

    constructor() { }
}
