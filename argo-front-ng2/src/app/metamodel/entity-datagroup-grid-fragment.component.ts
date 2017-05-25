import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-entity-datagroup-grid-fragment',
    templateUrl: './entity-datagroup-grid-fragment.component.html'
} )
export class EntityDatagroupGridFragmentComponent {
    private _endgList: any[];

    @Input()
    set endgList( endgList: any[] ) {
        this._endgList = endgList;
    }

    get endgList(): any[] { return this._endgList; }
}
