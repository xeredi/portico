import { Component, Input, OnInit } from '@angular/core';

@Component( {
    selector: 'app-assessment-line-grid-fragment',
    template: `
<div class="table-responsive" *ngIf="itemList">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th></th>
                <th *ngIf="existsEntity">Entidad</th>
                <th *ngIf="existsCharge">Cargo</th>
                <th>Regla</th>
                <th>Tipo</th>
                <th>Valor Base</th>
                <th>Importe Base</th>
                <th>Importe</th>
                <th *ngIf="existsSubtotal">Subtotal</th>
                <th>Nº Detalles</th>
                <th *ngIf="existsTax">Impuesto</th>

                <th *ngIf="existsSsrv">Subservicio</th>
                <th *ngIf="existsFini">Fec. Inicio</th>
                <th *ngIf="existsFfin">Fec. Fin</th>

                <th *ngIf="existsInfo1" colspan="2">Info 1</th>
                <th *ngIf="existsInfo2" colspan="2">Info 2</th>
                <th *ngIf="existsInfo3" colspan="2">Info 3</th>
                <th *ngIf="existsInfo4" colspan="2">Info 4</th>
                <th *ngIf="existsInfo5" colspan="2">Info 5</th>
                <th *ngIf="existsInfo6" colspan="2">Info 6</th>

                <th *ngIf="existsCuant1" colspan="2">Cuant 1</th>
                <th *ngIf="existsCuant2" colspan="2">Cuant 2</th>
                <th *ngIf="existsCuant3" colspan="2">Cuant 3</th>
                <th *ngIf="existsCuant4" colspan="2">Cuant 4</th>
                <th *ngIf="existsCuant5" colspan="2">Cuant 5</th>
                <th *ngIf="existsCuant6" colspan="2">Cuant 6</th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td nowrap="nowrap">
                    <a [routerLink]="['/billing/assessment-line/detail', item.id]"><i class="fa fa-search"></i></a>
                </td>
                <td *ngIf="existsEntity" nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId" [translate]="'enti_' + item.rgla.enti.id"></span>
                </td>
                <td *ngIf="existsCharge" nowrap="nowrap">
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
                <td *ngIf="existsSubtotal" nowrap="nowrap" class="number">
                    <span *ngIf="item.id == item.padreId" [innerHTML]="item.subtotal | number : '1.2-2'"></span>
                </td>
                <td nowrap="nowrap" class="number">
                    <span [innerHTML]="item.vlrdCount | number"></span>
                </td>
                <td *ngIf="existsTax" nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId" [innerHTML]="item.impuesto.parametro"
                        [ngbTooltip]="item.impuesto.etiqueta" container="body"></span>
                </td>
                <td *ngIf="existsSsrv" nowrap="nowrap" class="number">
                    <span *ngIf="item.id == item.padreId && item.ssrv" [innerHTML]="item.ssrv.numero | number"></span>
                </td>
                <td *ngIf="existsFini" nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId && item.fini" [innerHTML]="item.fini | date: 'dd/MM/yyyy HH:mm'"></span>
                </td>
                <td *ngIf="existsFfin" nowrap="nowrap">
                    <span *ngIf="item.id == item.padreId && item.ffin" [innerHTML]="item.ffin | date: 'dd/MM/yyyy HH:mm'"></span>
                </td>

                <td *ngIf="existsInfo1" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo1 && item.id == item.padreId && item.info1" [innerHTML]="item.rgla.version.etiqInfo1"></span>
                </td>
                <td *ngIf="existsInfo1" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo1 && item.id == item.padreId && item.info1" [innerHTML]="item.info1"></span>
                </td>
                <td *ngIf="existsInfo2" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo2 && item.id == item.padreId && item.info2" [innerHTML]="item.rgla.version.etiqInfo2"></span>
                </td>
                <td *ngIf="existsInfo2" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo2 && item.id == item.padreId && item.info2" [innerHTML]="item.info2"></span>
                </td>
                <td *ngIf="existsInfo3" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo3 && item.id == item.padreId && item.info3" [innerHTML]="item.rgla.version.etiqInfo3"></span>
                </td>
                <td *ngIf="existsInfo3" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo3 && item.id == item.padreId && item.info3" [innerHTML]="item.info3"></span>
                </td>
                <td *ngIf="existsInfo4" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo4 && item.id == item.padreId && item.info4" [innerHTML]="item.rgla.version.etiqInfo4"></span>
                </td>
                <td *ngIf="existsInfo4" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo4 && item.id == item.padreId && item.info4" [innerHTML]="item.info4"></span>
                </td>
                <td *ngIf="existsInfo5" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo5 && item.id == item.padreId && item.info5" [innerHTML]="item.rgla.version.etiqInfo5"></span>
                </td>
                <td *ngIf="existsInfo5" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo5 && item.id == item.padreId && item.info5" [innerHTML]="item.info5"></span>
                </td>
                <td *ngIf="existsInfo6" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo6 && item.id == item.padreId && item.info6" [innerHTML]="item.rgla.version.etiqInfo6"></span>
                </td>
                <td *ngIf="existsInfo6" nowrap="nowrap">
                    <span *ngIf="aspect.version.lgrpInfo6 && item.id == item.padreId && item.info6" [innerHTML]="item.info6"></span>
                </td>

                <td *ngIf="existsCuant1" nowrap="nowrap">
                    <span *ngIf="item.rgla.version.etiqCuant1" [innerHTML]="item.rgla.version.etiqCuant1"></span>
                </td>
                <td *ngIf="existsCuant1" nowrap="nowrap" class="number">
                    <span [innerHTML]="item.cuant1 | number"></span>
                </td>
                <td *ngIf="existsCuant2" nowrap="nowrap">
                    <span *ngIf="item.rgla.version.etiqCuant2" [innerHTML]="item.rgla.version.etiqCuant2"></span>
                </td>
                <td *ngIf="existsCuant2" nowrap="nowrap"class="number">
                    <span [innerHTML]="item.cuant2 | number"></span>
                </td>
                <td *ngIf="existsCuant3" nowrap="nowrap">
                    <span *ngIf="item.rgla.version.etiqCuant3" [innerHTML]="item.rgla.version.etiqCuant3"></span>
                </td>
                <td *ngIf="existsCuant3" nowrap="nowrap" class="number">
                    <span [innerHTML]="item.cuant3 | number"></span>
                </td>
                <td *ngIf="existsCuant4" nowrap="nowrap">
                    <span *ngIf="item.rgla.version.etiqCuant4" [innerHTML]="item.rgla.version.etiqCuant4"></span>
                </td>
                <td *ngIf="existsCuant4" nowrap="nowrap" class="number">
                    <span [innerHTML]="item.cuant4 | number"></span>
                </td>
                <td *ngIf="existsCuant5" nowrap="nowrap">
                    <span *ngIf="item.rgla.version.etiqCuant5" [innerHTML]="item.rgla.version.etiqCuant5"></span>
                </td>
                <td *ngIf="existsCuant5" nowrap="nowrap" class="number">
                    <span [innerHTML]="item.cuant5 | number"></span>
                </td>
                <td *ngIf="existsCuant6" nowrap="nowrap">
                    <span *ngIf="item.rgla.version.etiqCuant6" [innerHTML]="item.rgla.version.etiqCuant6"></span>
                </td>
                <td *ngIf="existsCuant6" nowrap="nowrap" class="number">
                    <span [innerHTML]="item.cuant6 | number"></span>
                </td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class AssessmentLineGridFragmentComponent implements OnInit {
    @Input() itemList: any[];
    @Input() aspect: any;

    private _existsEntity: boolean;
    private _existsCharge: boolean;
    private _existsSubtotal: boolean;
    private _existsTax: boolean;
    private _existsSsrv: boolean;
    private _existsFini: boolean;
    private _existsFfin: boolean;

    private _existsCuant1: boolean;
    private _existsCuant2: boolean;
    private _existsCuant3: boolean;
    private _existsCuant4: boolean;
    private _existsCuant5: boolean;
    private _existsCuant6: boolean;

    private _existsInfo1: boolean;
    private _existsInfo2: boolean;
    private _existsInfo3: boolean;
    private _existsInfo4: boolean;
    private _existsInfo5: boolean;
    private _existsInfo6: boolean;

    get existsEntity(): boolean { return this._existsEntity; }
    get existsCharge(): boolean { return this._existsCharge; }
    get existsSubtotal(): boolean { return this._existsSubtotal; }
    get existsTax(): boolean { return this._existsTax; }
    get existsSsrv(): boolean { return this._existsSsrv; }
    get existsFini(): boolean { return this._existsFini; }
    get existsFfin(): boolean { return this._existsFfin; }

    get existsCuant1(): boolean { return this._existsCuant1; }
    get existsCuant2(): boolean { return this._existsCuant2; }
    get existsCuant3(): boolean { return this._existsCuant3; }
    get existsCuant4(): boolean { return this._existsCuant4; }
    get existsCuant5(): boolean { return this._existsCuant5; }
    get existsCuant6(): boolean { return this._existsCuant6; }

    get existsInfo1(): boolean { return this._existsInfo1; }
    get existsInfo2(): boolean { return this._existsInfo2; }
    get existsInfo3(): boolean { return this._existsInfo3; }
    get existsInfo4(): boolean { return this._existsInfo4; }
    get existsInfo5(): boolean { return this._existsInfo5; }
    get existsInfo6(): boolean { return this._existsInfo6; }

    ngOnInit() {
        // console.log( "Init Variables" );
        this._existsEntity = false;
        this._existsCharge = false;
        this._existsSubtotal = false;
        this._existsTax = false;
        this._existsSsrv = false;
        this._existsFini = false;
        this._existsFfin = false;

        this._existsCuant1 = false;
        this._existsCuant2 = false;
        this._existsCuant3 = false;
        this._existsCuant4 = false;
        this._existsCuant5 = false;
        this._existsCuant6 = false;

        this._existsInfo1 = false;
        this._existsInfo2 = false;
        this._existsInfo3 = false;
        this._existsInfo4 = false;
        this._existsInfo5 = false;
        this._existsInfo6 = false;

        for ( let item of this.itemList ) {
            if ( item.id == item.padreId ) { this._existsEntity = true; }
            if ( item.id == item.padreId ) { this._existsCharge = true; }
            if ( item.id == item.padreId ) { this._existsSubtotal = true; }
            if ( item.id == item.padreId ) { this._existsTax = true; }
            if ( item.id == item.padreId && item.ssrv ) { this._existsSsrv = true; }
            if ( item.id == item.padreId && item.fini ) { this._existsFini = true; }
            if ( item.id == item.padreId && item.ffin ) { this._existsFfin = true; }

            if ( item.rgla.version.etiqCuant1 ) { this._existsCuant1 = true; }
            if ( item.rgla.version.etiqCuant2 ) { this._existsCuant2 = true; }
            if ( item.rgla.version.etiqCuant3 ) { this._existsCuant3 = true; }
            if ( item.rgla.version.etiqCuant4 ) { this._existsCuant4 = true; }
            if ( item.rgla.version.etiqCuant5 ) { this._existsCuant5 = true; }
            if ( item.rgla.version.etiqCuant6 ) { this._existsCuant6 = true; }

            if ( this.aspect.version.lgrpInfo1 && item.id == item.padreId && item.info1 ) { this._existsInfo1 = true; }
            if ( this.aspect.version.lgrpInfo2 && item.id == item.padreId && item.info2 ) { this._existsInfo2 = true; }
            if ( this.aspect.version.lgrpInfo3 && item.id == item.padreId && item.info3 ) { this._existsInfo3 = true; }
            if ( this.aspect.version.lgrpInfo4 && item.id == item.padreId && item.info4 ) { this._existsInfo4 = true; }
            if ( this.aspect.version.lgrpInfo5 && item.id == item.padreId && item.info5 ) { this._existsInfo5 = true; }
            if ( this.aspect.version.lgrpInfo6 && item.id == item.padreId && item.info6 ) { this._existsInfo6 = true; }
        }
    }
}
