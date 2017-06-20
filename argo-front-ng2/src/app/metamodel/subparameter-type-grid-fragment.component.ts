import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-subparameter-type-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Código</th>
                <th nowrap="nowrap">Nombre</th>
                <th nowrap="nowrap">Grid Máx (filas)</th>
                <th nowrap="nowrap">Maestro</th>
                <th nowrap="nowrap">Classpath</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/metamodel/subparameter-type/detail', item.id]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.codigo"></td>
                <td nowrap="nowrap" [innerHTML]="item.nombre"></td>
                <td nowrap="nowrap" [innerHTML]="item.maxGrid" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.tpprAsociado.nombre"></td>
                <td nowrap="nowrap" [innerHTML]="item.classpath"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class SubparameterTypeGridFragmentComponent {
    @Input() itemList: any[];
}
