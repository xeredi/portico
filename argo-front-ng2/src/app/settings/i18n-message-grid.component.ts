import { Component, OnInit } from '@angular/core';

import { I18nMessageService } from './i18n-message.service';

@Component( {
    selector: 'app-i18n-message-grid',
    template: `
<div *ngIf="keyMap">
    <div class="col-lg-3 col-xl-2 form-group-sm">
        <label [translate]="'filter'"></label>
        <input type="text" [(ngModel)]="filter" name="filter"
            class="form-control form-control-sm" />
    </div>

    <div class="table-responsive">
        <table class="table table-sm table-bordered table-hover">
            <thead class="thead-inverse">
                <tr>
                    <th nowrap="nowrap"></th>
                    <th nowrap="nowrap">Clave</th>
                    <th *ngFor="let availableLanguage of availableLanguages" nowrap="nowrap">{{availableLanguage}}</th>
                </tr>
            </thead>
            <tbody>
                <tr *ngFor="let key of keyList | i18nMessageFilter: filter">
                    <td><a [routerLink]="['/settings/i18n-message/detail', key]"><i class="fa fa-search"></i></a></td>
                    <td nowrap="nowrap">{{key}}</td>
                    <td *ngFor="let availableLanguage of availableLanguages" nowrap="nowrap">{{keyMap[key][availableLanguage]}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
    `
} )
export class I18nMessageGridComponent implements OnInit {

    keyList: any[] = [];
    keyMap: any;
    availableLanguages: string[];

    constructor( private m18nService: I18nMessageService ) { }

    ngOnInit() {
        this.m18nService.list( {} ).subscribe( resp => {
            this.keyList = resp.resultList;
            this.keyMap = resp.keyMap;
            this.availableLanguages = resp.availableLanguages;
        } );
    }

}
