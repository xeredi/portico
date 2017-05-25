import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-entity-action-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Código</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/metamodel/entity-action/detail', item.id]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.aebs.codigo"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class EntityActionGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
