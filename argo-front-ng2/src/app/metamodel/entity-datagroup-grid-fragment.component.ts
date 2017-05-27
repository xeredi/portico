import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-entity-datagroup-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Etiqueta</th>
                <th nowrap="nowrap">Número</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/metamodel/entity-datagroup/detail', item.id]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.numero" class="number"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class EntityDatagroupGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
