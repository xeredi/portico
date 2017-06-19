import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-special-action-grid-fragment',
    templateUrl: './special-action-grid-fragment.component.html'
} )
export class SpecialActionGridFragmentComponent {
    @Input() itemList: any[];

    constructor() { }
}
