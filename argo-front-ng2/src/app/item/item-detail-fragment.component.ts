import { Component, Input } from '@angular/core';

@Component( {
    selector: 'argo-item-detail-fragment',
    template: `
<div class="row">
    <div *ngFor="let entdId of enti.entdList" class="form-group-sm" [ngClass]="enti.entdMap[entdId].spanCss">
        <label [translate]="'entd_' + enti.entdMap[entdId].id"></label>
        <p class="form-control-static form-control-sm" [ngSwitch]="enti.entdMap[entdId].tpdt.tipoElemento">
            <i *ngSwitchCase="'BO'" class="fa"
                [ngClass]="itemMap[entdId].cantidadEntera == 1 ? 'fa-check' : 'fa-remove'"></i> <span
                *ngSwitchCase="'NE'" [innerHTML]="itemMap[entdId].cantidadEntera | number" class="pull-right"></span> <span
                *ngSwitchCase="'ND'" [innerHTML]="itemMap[entdId].cantidadDecimal | number : '1.0-6'" class="pull-right"></span><span
                *ngSwitchCase="'CR'"><span *ngIf="itemMap[entdId].cadena"
                [innerHTML]="'cdrf_' + enti.entdMap[entdId].tpdt.id + '_' + itemMap[entdId].cadena | translate"></span></span>
            <span *ngSwitchCase="'PR'"> <a *ngIf="itemMap[entdId].prmt"
                [routerLink]="['/master/parameter/detail', enti.entdMap[entdId].tpdt.enti.id, itemMap[entdId].prmt.id, date]"
                [innerHTML]="itemMap[entdId].prmt.etiqueta"> </a></span> <span *ngSwitchCase="'SR'"> <a
                *ngIf="itemMap[entdId].srvc"
                [routerLink]="['/service/service/detail', enti.entdMap[entdId].tpdt.enti.id, itemMap[entdId].srvc.id]"
                [innerHTML]="itemMap[entdId].srvc.etiqueta"> </a>
            </span> <span *ngSwitchCase="'TX'" [innerHTML]="itemMap[entdId].cadena"></span> <span *ngSwitchCase="'FE'"
                [innerHTML]="itemMap[entdId].fecha | date : 'dd/MM/yyyy'"></span> <span *ngSwitchCase="'FH'"
                [innerHTML]="itemMap[entdId].fecha | date : 'dd/MM/yyyy HH:mm'"></span> <span *ngSwitchDefault>Unknown
                Datatype!: {{enti.entdMap[entdId].tpdt.tipoElemento}}</span>
        </p>
    </div>
</div>
    `
} )
export class ItemDetailFragmentComponent {
    @Input() enti: any;
    @Input() itemMap: any;
    @Input() date: any;

    constructor() { }
}
