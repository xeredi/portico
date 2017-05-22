import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-i18n-info-edit',
    template: `
<div class="row">
    <div *ngFor="let availableLanguage of availableLanguages" class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
        <label>{{availableLanguage}}</label> <input type="text" [(ngModel)]="i18nMap[availableLanguage].text"
            name="i18nMap[{{availableLanguage}}].text" class="form-control form-control-sm" />
    </div>
</div>
    `
} )
export class I18nInfoEditComponent {
    private _availableLanguages: string[] = [];
    private _i18nMap: Map<string, any> = new Map<string, any>();

    @Input()
    set availableLanguages( availableLanguages: string[] ) {
        // console.log( "Setting availableLanguages" );

        this._availableLanguages = availableLanguages;

        for ( let availableLanguage of this._availableLanguages ) {
            if ( !this.i18nMap[availableLanguage] ) {
                this.i18nMap[availableLanguage] = {};
            }
        }
    }

    get availableLanguages(): string[] { return this._availableLanguages; }

    @Input()
    set i18nMap( i18nMap: Map<string, any> ) {
        // console.log( "Setting i18nMap" );

        for ( let key in i18nMap ) {
            this._i18nMap[key] = i18nMap[key];
        }
    }

    get i18nMap(): Map<string, any> { return this._i18nMap; }
}
