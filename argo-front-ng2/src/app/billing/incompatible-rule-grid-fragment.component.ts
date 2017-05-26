import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-incompatible-rule-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Código</th>
                <th nowrap="nowrap">Tipo</th>
                <th nowrap="nowrap">Entidad</th>
                <th nowrap="nowrap">Fec. Inicio</th>
                <th nowrap="nowrap">Fec. Fin</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/billing/incompatible-rule/detail', item.id, item.fref]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.rgla2.codigo"></td>
                <td nowrap="nowrap" [innerHTML]="item.rgla2.tipo"></td>
                <td nowrap="nowrap" [innerHTML]="item.rgla2.enti.id"></td>
                <td nowrap="nowrap" [innerHTML]="item.version.fini | date: 'dd/MM/yyyy'"></td>
                <td nowrap="nowrap" [innerHTML]="item.version.ffin | date: 'dd/MM/yyyy'"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class IncompatibleRuleGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
