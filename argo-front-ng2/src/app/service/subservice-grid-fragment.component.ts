import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-subservice-grid-fragment',
    templateUrl: './subservice-grid-fragment.component.html'
} )
export class SubserviceGridFragmentComponent {
    @Input() itemList: any[];
    @Input() enti: any;

    trackByFn( index, item ) {
        return index;
    }
}
