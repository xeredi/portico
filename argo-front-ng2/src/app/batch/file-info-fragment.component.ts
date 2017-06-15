import { Component, Input } from '@angular/core';

@Component( {
    selector: 'argo-file-info-fragment',
    template: `
<div class="table-responsive">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th></th>
                <th [translate]="'arch_nombre'"></th>
                <th [translate]="'arch_tamanio'"></th>
                <th [translate]="'arch_falta'"></th>
            </tr>
        </thead>

        <tbody>
            <tr *ngFor="let item of itemList">
                <td><i class="fa fa-save"></i></td>
                <td [innerHTML]="item.nombre"></td>
                <td [innerHTML]="item.tamanio | number" class="number"></td>
                <td [innerHTML]="item.falta | date: 'dd/MM/yyyy HH:mm'"></td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class FileInfoFragmentComponent {
    @Input() itemList: any[];

    constructor() { }
}
