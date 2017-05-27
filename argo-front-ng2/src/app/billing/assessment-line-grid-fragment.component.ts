import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-assessment-line-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th></th>
                <th>Entidad</th>
                <th>Cargo</th>
                <th>Regla</th>
                <th>Tipo</th>
                <th>Valor Base</th>
                <th>Importe Base</th>
                <th>Importe</th>
                <th>Subtotal</th>
                <th>Nº Detalles</th>
                <th>Impuesto</th>
                <th>Subservicio</th>
                <th>Fec. Inicio</th>
                <th>Fec. Fin</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td nowrap="nowrap">
                    <a [routerLink]="['/billing/assessment-line/detail', item.id]"><i class="fa fa-search"></i></a>
                </td>
                <td nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId" [innerHTML]="item.rgla.enti.id"></span>
                </td>
                <td nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId" [innerHTML]="item.rgla.crgo.etiqueta"></span>
                </td>
                <td nowrap="nowrap" [innerHTML]="item.rgla.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.rgla.tipo"></td>
                <td nowrap="nowrap" class="number" [innerHTML]="item.valorBase | number : '1.6-6'"></td>
                <td nowrap="nowrap" class="number">
                    <span *ngIf="item.id != item.padreId" [innerHTML]="item.importeBase | number : '1.2-2'"></span>
                </td>
                <td nowrap="nowrap" class="number">
                    <span [innerHTML]="item.importe | number : '1.2-2'"></span>
                </td>
                <td nowrap="nowrap" class="number">
                    <span *ngIf="item.id == item.padreId" [innerHTML]="item.subtotal | number : '1.2-2'"></span>
                </td>
                <td nowrap="nowrap" class="number">
                    <span [innerHTML]="item.vlrdCount | number"></span>
                </td>
                <td nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId" [innerHTML]="item.impuesto.parametro"
                        [ngbTooltip]="item.impuesto.etiqueta" container="body"></span>
                </td>
                <td nowrap="nowrap" class="number">
                    <span *ngIf="item.id == item.padreId && item.ssrv" [innerHTML]="item.ssrv.numero | number"></span>
                </td>
                <td nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId && item.fini" [innerHTML]="item.fini | date: 'dd/mm/yyyy HH:mm'"></span>
                </td>
                <td nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId && item.ffin" [innerHTML]="item.ffin | date: 'dd/mm/yyyy HH:mm'"></span>
                </td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class AssessmentLineGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
