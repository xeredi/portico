import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-entity-datatype-grid-fragment',
    templateUrl: './entity-datatype-grid-fragment.component.html'
} )
export class EntityDatatypeGridFragmentComponent {
    private _endtList: any[];

    @Input()
    set endtList( endtList: any[] ) {
        this._endtList = endtList;
    }

    get endtList(): any[] { return this._endtList; }
}
