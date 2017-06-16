import { Component, Input } from '@angular/core';

@Component( {
    selector: 'argo-subparameter-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th></th>
                <th *ngIf="enti.enti.tpprAsociado.puerto" [translate]="'prto'"></th>
                <th [translate]="'enti_' + enti.enti.tpprAsociado.id"></th>

                <th [translate]="'fini'"></th>
                <th [translate]="'ffin'"></th>

                <th *ngFor="let entdId of enti.entdGridList" [translate]="'entd_' + enti.entdMap[entdId].id"></th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/master/subparameter/detail', item.entiId, item.id, item.fref]"><i
                        class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" *ngIf="enti.enti.tpprAsociado.puerto" [innerHTML]="item.prmtAsociado.prto.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.prmtAsociado.etiqueta"></td>

                <td nowrap="nowrap" [innerHTML]="item.version.fini | date: 'dd/MM/yyyy'"></td>
                <td nowrap="nowrap" [innerHTML]="item.version.ffin | date: 'dd/MM/yyyy'"></td>

                <td nowrap="nowrap" *ngFor="let entdId of enti.entdGridList"
                    [ngSwitch]="enti.entdMap[entdId].tpdt.tipoElemento"><i *ngSwitchCase="'BO'" class="fa"
                    [ngClass]="item.itdtMap[entdId].cantidadEntera == 1 ? 'fa-check' : 'fa-remove'"></i> <span
                    *ngSwitchCase="'NE'" [innerHTML]="item.itdtMap[entdId].cantidadEntera | number" class="pull-right"></span>
                    <span *ngSwitchCase="'ND'" [innerHTML]="item.itdtMap[entdId].cantidadDecimal | number : '1.6-6'"
                    class="pull-right"></span> <span *ngSwitchCase="'CR'" [innerHTML]="item.itdtMap[entdId].cadena"
                    [ngbTooltip]="'cdrf_' + enti.entdMap[entdId].tpdt.id + '_' + item.itdtMap[entdId].cadena | translate"
                    container="body"></span> <span *ngSwitchCase="'PR'"
                    [innerHTML]="item.itdtMap[entdId].prmt?.parametro"
                    [ngbTooltip]="item.itdtMap[entdId].prmt?.etiqueta" container="body"></span> <span
                    *ngSwitchCase="'SR'" [innerHTML]="item.itdtMap[entdId].srvc?.etiqueta"></span> <span
                    *ngSwitchCase="'TX'" [innerHTML]="item.itdtMap[entdId].cadena"></span> <span *ngSwitchCase="'FE'"
                    [innerHTML]="item.itdtMap[entdId].fecha | date : 'dd/MM/yyyy'"></span> <span *ngSwitchCase="'FH'"
                    [innerHTML]="item.itdtMap[entdId].fecha | date : 'dd/MM/yyyy HH:mm'"></span><span *ngSwitchDefault>Unknown
                        Datatype!: {{enti.entdMap[entdId].tpdt.tipoElemento}}</span></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class SubparameterGridFragmentComponent {
    @Input() enti: any;
    @Input() itemList: any[];

    constructor() { }
}
