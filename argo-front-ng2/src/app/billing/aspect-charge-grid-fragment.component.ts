import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-aspect-charge-grid-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th nowrap="nowrap"></th>
                <th nowrap="nowrap" [translate]="'crgo'"></th>
                <th nowrap="nowrap" [translate]="'fini'"></th>
                <th nowrap="nowrap" [translate]="'ffin'"></th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td><a [routerLink]="['/billing/aspect-charge/detail', item.id, item.fref]">
                    <i class="fa fa-search"></i></a></td>
                <td nowrap="nowrap" [innerHTML]="item.crgo.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.version.fini | date:'dd/MM/yyyy'"></td>
                <td nowrap="nowrap" [innerHTML]="item.version.ffin | date:'dd/MM/yyyy'"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class AspectChargeGridFragmentComponent {
    @Input() itemList: any[];
}
