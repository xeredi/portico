import { Component, OnInit } from '@angular/core';

import { I18nMessageService } from './i18n-message.service';

@Component( {
    selector: 'app-i18n-message-grid',
    template: `
<table class="table table-sm table-bordered table-hover">
    <thead class="thead-inverse">
        <tr>
            <th nowrap="nowrap"></th>
            <th nowrap="nowrap">Clave</th>
            <th *ngFor="let availableLanguage of availableLanguages" nowrap="nowrap">{{availableLanguage}}</th>
        </tr>
    </thead>
    <tbody>
        <tr *ngFor="let key of keyList">
            <td><a [routerLink]="['/settings/i18n-message/detail', key]"><i class="fa fa-search"></i></a></td>
            <td nowrap="nowrap">{{key}}</td>
            <td *ngFor="let availableLanguage of availableLanguages" nowrap="nowrap">{{keyMap[key][availableLanguage]}}</td>
        </tr>
    </tbody>
</table>
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
