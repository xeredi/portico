import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-reference-code-grid-fragment',
    templateUrl: './reference-code-grid-fragment.component.html'
} )
export class ReferenceCodeGridFragmentComponent {
    @Input() itemList;

    constructor() { }
}
