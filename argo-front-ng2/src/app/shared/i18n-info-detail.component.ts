import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-i18n-info-detail',
    template: `
<div class="row" *ngIf=i18nMap>
    <div *ngFor="let availableLanguage of availableLanguages" class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
        <div *ngIf="i18nMap[availableLanguage]?.text">
            <label [innerHTML]="availableLanguage"></label>
            <p class="form-control-static form-control-sm" [innerHTML]="i18nMap[availableLanguage].text"></p>
        </div>
    </div>
</div>
`
} )
export class I18nInfoDetailComponent {
    private _availableLanguages: string[];
    private _i18nMap: Map<string, any>;

    @Input()
    set availableLanguages( availableLanguages: string[] ) {
        console.log('set availableLanguages');

        this._availableLanguages = availableLanguages;
    }

    get availableLanguages(): string[] { return this._availableLanguages; }

    @Input()
    set i18nMap( i18nMap: Map<string, any> ) {
        console.log('set i18nMap');

        this._i18nMap = i18nMap;
    }

    get i18nMap(): Map<string, any> { return this._i18nMap; }
}
