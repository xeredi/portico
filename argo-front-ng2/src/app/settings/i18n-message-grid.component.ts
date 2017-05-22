import { Component, OnInit } from '@angular/core';

import { I18nMessageService } from './i18n-message.service';

@Component( {
    selector: 'app-i18n-message-grid',
    templateUrl: './i18n-message-grid.component.html'
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
