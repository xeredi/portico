import { Component, Input } from '@angular/core';

@Component( {
    selector: 'argo-process-item-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th></th>
                <th [translate]="'prit_tipo'"></th>
                <th [translate]="'prit_nombre'"></th>
            </tr>
        </thead>

        <tbody>
            <tr *ngFor="let item of itemList">
                <td [ngSwitch]="item.tipo"><a *ngSwitchCase="'srvc'"
                    [routerLink]="['/service/service/detail', item.entiId, item.itemId]"><i class="fa fa-search"></i></a>
                    <a *ngSwitchCase="'ssrv'" [routerLink]="['/service/subservice/detail', item.entiId, item.itemId]"><i
                        class="fa fa-search"></i></a> <a *ngSwitchCase="'vlrc'"
                    [routerLink]="['/billing/assessment/detail', item.itemId]"><i class="fa fa-search"></i></a> <span
                    *ngSwitchDefault>TIPO DESCONOCIDO {{item.tipo}}</span></td>
                <td [ngSwitch]="item.tipo"><span *ngSwitchCase="'srvc'" [translate]="'enti_' + item.entiId"></span>
                    <span *ngSwitchCase="'ssrv'" [translate]="'enti_' + item.entiId"></span> <span *ngSwitchDefault
                    [translate]="'ItemTipo_' + item.tipo"></span></td>
                <td [innerHTML]="item.etiqueta"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class ProcessItemFragmentComponent {
    @Input() itemList: any[];

    constructor() { }
}
