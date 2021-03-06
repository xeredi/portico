import { Component, OnInit } from '@angular/core';

import { ConfigurationService } from './configuration.service';

@Component( {
    selector: 'app-configuration-grid',
    template: `
<div *ngIf="confList">
    <div class="col-lg-3 col-xl-2 form-group-sm">
        <label [translate]="'filter'"></label>
        <input type="text" [(ngModel)]="filter" name="filter"
            class="form-control form-control-sm" />
    </div>

    <div class="table-responsive">
        <table class="table table-sm table-bordered table-hover table-condensed">
            <thead class="thead-inverse">
                <tr>
                    <th nowrap="nowrap"></th>
                    <th nowrap="nowrap">Clave</th>
                    <th nowrap="nowrap">Tipo</th>
                    <th nowrap="nowrap">Valor Defecto</th>
                    <th nowrap="nowrap">Valor</th>
                </tr>
            </thead>
            <tbody>
                <tr *ngFor="let item of confList | configurationFilter: filter">
                    <td><a [routerLink]="['/settings/configuration/detail', item.key]"><i class="fa fa-search"></i></a></td>
                    <td nowrap="nowrap">{{item.key}}</td>
                    <td nowrap="nowrap">{{item.valueType}}</td>
                    <td nowrap="nowrap">{{item.defaultValue}}</td>
                    <td nowrap="nowrap">{{item.value}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
        `
} )
export class ConfigurationGridComponent implements OnInit {

    confList: any[] = [];

    constructor( private confService: ConfigurationService ) {
    }

    ngOnInit() {
        console.log( "ConfigurationGrid" );

        this.confService.list( {} ).subscribe( resp => {
            this.confList = resp.resultList;
        } );
    }
}
