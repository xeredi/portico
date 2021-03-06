import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-entity-datatype-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap">Grupo</th>
                <th nowrap="nowrap">Fila</th>
                <th nowrap="nowrap">Orden</th>
                <th nowrap="nowrap">Span</th>
                <th nowrap="nowrap">Span (Lg)</th>
                <th nowrap="nowrap">Etiqueta</th>
                <th nowrap="nowrap">Obligatorio?</th>
                <th nowrap="nowrap">Gridable?</th>
                <th nowrap="nowrap">Filtrable?</th>
                <th nowrap="nowrap">Tipo de Dato</th>
                <th nowrap="nowrap">Tipo de Elemento</th>
                <th nowrap="nowrap">Tipo HTML</th>
                <th nowrap="nowrap">Entidad</th>
                <th nowrap="nowrap">V. Defecto</th>
                <th nowrap="nowrap">Validación</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/metamodel/entity-datatype/detail', item.id]"><i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.grupo" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.fila" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.orden" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.span" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.spanLg" class="number"></td>
                <td nowrap="nowrap" [innerHTML]="item.etiqueta"></td>
                <td nowrap="nowrap"><i class="fa"
                    [ngClass]="{true:'fa-check', false:'fa-remove'}[item.obligatorio]"></i></td>
                <td nowrap="nowrap"><i class="fa" [ngClass]="{true:'fa-check', false:'fa-remove'}[item.gridable]"></i></td>
                <td nowrap="nowrap"><i class="fa" [ngClass]="{true:'fa-check', false:'fa-remove'}[item.filtrable]"></i></td>
                <td nowrap="nowrap" [innerHTML]="item.tpdt.nombre"></td>
                <td nowrap="nowrap" [innerHTML]="item.tpdt.tipoElemento"></td>
                <td nowrap="nowrap" [innerHTML]="item.tpdt.tpht"></td>
                <td nowrap="nowrap" [innerHTML]="item.tpdt.enti?.nombre"></td>
                <td nowrap="nowrap" [innerHTML]="item.valorDefecto"></td>
                <td nowrap="nowrap" [innerHTML]="item.validacion"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class EntityDatatypeGridFragmentComponent {
    private _itemList: any[];

    @Input()
    set itemList( itemList: any[] ) {
        this._itemList = itemList;
    }

    get itemList(): any[] { return this._itemList; }
}
