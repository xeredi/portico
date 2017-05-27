import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-assessment-charge-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Cargo</th>
                <th nowrap="nowrap">Importe</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/billing/charge/detail', item.crgo.id, item.crgo.fref]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.crgo.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.importe | number:'1.2-2'" class="number"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class AssessmentChargeGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
