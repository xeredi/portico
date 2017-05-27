import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-assessment-tax-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Impuesto</th>
                <th nowrap="nowrap">%</th>
                <th nowrap="nowrap">Importe Base</th>
                <th nowrap="nowrap">Importe Impuesto</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/master/parameter/detail', item.impuesto.entiId, item.impuesto.id, item.impuesto.fref]">
                    <i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.impuesto.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.porcentaje | number:'1.2-2'" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.importeBase | number:'1.2-2'" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.importeImpuesto | number:'1.2-2'" class="number"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class AssessmentTaxGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
