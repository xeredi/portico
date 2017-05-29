import { Injectable } from '@angular/core';

@Injectable()
export class I18nInfoService {

    constructor() { }

    normalize( i18nMap: Map<string, any>, availableLanguages: string[] ) {
        console.log( "normalize: " + JSON.stringify( i18nMap ) );

        var _i18nMap = new Map<string, any>();

        for ( let availableLanguage of availableLanguages ) {
            _i18nMap[availableLanguage] = i18nMap && i18nMap[availableLanguage] ? i18nMap[availableLanguage] : {}
        }

        console.log( "normalized: " + JSON.stringify( _i18nMap ) );

        return _i18nMap;
    }

}
