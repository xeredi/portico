import { Component, Input, OnInit } from '@angular/core';

@Component( {
    selector: 'app-assessment-detail-grid-fragment',
    template: `
<div class="table-responsive" *ngIf="itemList">
    <table class="table table-sm table-bordered table-hover table-condensed table-nonfluid">
        <thead class="thead-inverse">
            <tr>
                <th></th>

                <th>Regla</th>
                <th>Tipo</th>
                <th>Valor Base</th>
                <th *ngIf="existsImporteBase">Importe Base</th>
                <th>Importe</th>
                <th *ngIf="existsSsrv">Subservicio</th>
                <th *ngIf="existsFini">Fec. Inicio</th>
                <th *ngIf="existsFfin">Fec. Fin</th>

                <th *ngIf="existsInfo1" [innerHTML]="assessmentLineParent.rgla.version.etiqInfo1"></th>
                <th *ngIf="existsInfo2" [innerHTML]="assessmentLineParent.rgla.version.etiqInfo2"></th>
                <th *ngIf="existsInfo3" [innerHTML]="assessmentLineParent.rgla.version.etiqInfo3"></th>
                <th *ngIf="existsInfo4" [innerHTML]="assessmentLineParent.rgla.version.etiqInfo4"></th>
                <th *ngIf="existsInfo5" [innerHTML]="assessmentLineParent.rgla.version.etiqInfo5"></th>
                <th *ngIf="existsInfo6" [innerHTML]="assessmentLineParent.rgla.version.etiqInfo6"></th>

                <th *ngIf="existsCuant1" [innerHTML]="assessmentLineParent.rgla.version.etiqCuant1"></th>
                <th *ngIf="existsCuant2" [innerHTML]="assessmentLineParent.rgla.version.etiqCuant2"></th>
                <th *ngIf="existsCuant3" [innerHTML]="assessmentLineParent.rgla.version.etiqCuant3"></th>
                <th *ngIf="existsCuant4" [innerHTML]="assessmentLineParent.rgla.version.etiqCuant4"></th>
                <th *ngIf="existsCuant5" [innerHTML]="assessmentLineParent.rgla.version.etiqCuant5"></th>
                <th *ngIf="existsCuant6" [innerHTML]="assessmentLineParent.rgla.version.etiqCuant6"></th>
            </tr>
        </thead>
        <tbody>
            <tr *ngFor="let item of itemList">
                <td nowrap="nowrap"><a [routerLink]="['/billing/assessment-detail/detail', item.id]"><i
                        class="fa fa-search"></i></a></td>

                <td nowrap="nowrap" [innerHTML]="item.rgla.etiqueta"></td>
                <td nowrap="nowrap" [innerHTML]="item.rgla.tipo"></td>
                <td nowrap="nowrap" class="number" [innerHTML]="item.valorBase | number : '1.6-6'"></td>
                <td *ngIf="existsImporteBase" nowrap="nowrap" class="number"><span *ngIf="item.id != item.padreId"
                    [innerHTML]="item.importeBase | number : '1.2-2'"></span></td>
                <td nowrap="nowrap" class="number"><span [innerHTML]="item.importe | number : '1.2-2'"></span></td>
                <td *ngIf="existsSsrv" nowrap="nowrap" class="number"><span
                    *ngIf="item.id == item.padreId && item.ssrv" [innerHTML]="item.ssrv.numero | number"></span></td>
                <td *ngIf="existsFini" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.fini | date: 'dd/MM/yyyy HH:mm'"></span></td>
                <td *ngIf="existsFfin" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.ffin | date: 'dd/MM/yyyy HH:mm'"></span></td>

                <td *ngIf="existsInfo1" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.info1"></span></td>
                <td *ngIf="existsInfo2" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.info2"></span></td>
                <td *ngIf="existsInfo3" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.info3"></span></td>
                <td *ngIf="existsInfo4" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.info4"></span></td>
                <td *ngIf="existsInfo5" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.info5"></span></td>
                <td *ngIf="existsInfo6" nowrap="nowrap"><span *ngIf="item.id == item.padreId"
                    [innerHTML]="item.info6"></span></td>

                <td *ngIf="existsCuant1" nowrap="nowrap" class="number"><span [innerHTML]="item.cuant1 | number"></span>
                </td>
                <td *ngIf="existsCuant2" nowrap="nowrap" class="number"><span [innerHTML]="item.cuant2 | number"></span>
                </td>
                <td *ngIf="existsCuant3" nowrap="nowrap" class="number"><span [innerHTML]="item.cuant3 | number"></span>
                </td>
                <td *ngIf="existsCuant4" nowrap="nowrap" class="number"><span [innerHTML]="item.cuant4 | number"></span>
                </td>
                <td *ngIf="existsCuant5" nowrap="nowrap" class="number"><span [innerHTML]="item.cuant5 | number"></span>
                </td>
                <td *ngIf="existsCuant6" nowrap="nowrap" class="number"><span [innerHTML]="item.cuant6 | number"></span>
                </td>
            </tr>
        </tbody>
    </table>
</div>
    `
} )
export class AssessmentDetailGridFragmentComponent implements OnInit {
    @Input() itemList: any[];
    @Input() aspect: any;
    @Input() assessmentLine: any;
    @Input() assessmentLineParent: any;

    private _existsImporteBase: boolean;
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

    get existsImporteBase(): boolean { return this._existsImporteBase; }
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
        console.log( "Init Variables" );

        this._existsImporteBase = false;
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
            if ( this.assessmentLine.id != this.assessmentLine.padreId ) { this._existsImporteBase = true; }
            if ( this.assessmentLine.rgla.enti.tipo == 'S' ) { this._existsSsrv = true; }
            if ( this.assessmentLine.rgla.crgo.version.temporal ) { this._existsFini = true; }
            if ( this.assessmentLine.rgla.crgo.version.temporal ) { this._existsFfin = true; }

            if ( this.assessmentLineParent.rgla.version.etiqCuant1 ) { this._existsCuant1 = true; }
            if ( this.assessmentLineParent.rgla.version.etiqCuant2 ) { this._existsCuant2 = true; }
            if ( this.assessmentLineParent.rgla.version.etiqCuant3 ) { this._existsCuant3 = true; }
            if ( this.assessmentLineParent.rgla.version.etiqCuant4 ) { this._existsCuant4 = true; }
            if ( this.assessmentLineParent.rgla.version.etiqCuant5 ) { this._existsCuant5 = true; }
            if ( this.assessmentLineParent.rgla.version.etiqCuant6 ) { this._existsCuant6 = true; }

            if ( !this.aspect.version.lgrpInfo1 && this.assessmentLineParent.rgla.version.etiqInfo1 ) { this._existsInfo1 = true; }
            if ( !this.aspect.version.lgrpInfo2 && this.assessmentLineParent.rgla.version.etiqInfo2 ) { this._existsInfo2 = true; }
            if ( !this.aspect.version.lgrpInfo3 && this.assessmentLineParent.rgla.version.etiqInfo3 ) { this._existsInfo3 = true; }
            if ( !this.aspect.version.lgrpInfo4 && this.assessmentLineParent.rgla.version.etiqInfo4 ) { this._existsInfo4 = true; }
            if ( !this.aspect.version.lgrpInfo5 && this.assessmentLineParent.rgla.version.etiqInfo5 ) { this._existsInfo5 = true; }
            if ( !this.aspect.version.lgrpInfo6 && this.assessmentLineParent.rgla.version.etiqInfo6 ) { this._existsInfo6 = true; }
        }
    }
}
