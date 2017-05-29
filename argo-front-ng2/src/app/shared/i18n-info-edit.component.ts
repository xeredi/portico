import { Component, Input } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR, NG_VALIDATORS } from '@angular/forms';

@Component( {
    selector: 'app-i18n-info-edit',
    template: `
<div class="row" *ngIf=i18nMap>
    <div *ngFor="let availableLanguage of availableLanguages" class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
        <label>{{availableLanguage}}</label> <input type="text"
            name="i18nMap[{{availableLanguage}}].text"
            [(ngModel)]="i18nMap[availableLanguage].text"
            class="form-control form-control-sm" />
    </div>
</div>
    `
} )
export class I18nInfoEditComponent implements ControlValueAccessor {
    private _availableLanguages: string[];
    private _i18nMap: Map<string, any>;

    @Input()
    set availableLanguages( availableLanguages: string[] ) {
        console.log( 'set availableLanguages' );
        this._availableLanguages = availableLanguages;
    }

    get availableLanguages(): string[] { return this._availableLanguages; }

    @Input()
    set i18nMap( i18nMap: Map<string, any> ) {
        console.log( 'set i18nMap' );
        this._i18nMap = i18nMap;
    }

    get i18nMap(): Map<string, any> { return this._i18nMap; }

    writeValue( value ) : void {
        console.log( 'writeValue' );
        if ( value ) {
            this._i18nMap = value;
        }
    }

    registerOnChange(fn: any) : void {
        console.log( 'registerOnChange' );
    }

    registerOnTouched(fn: any) : void {
        console.log( 'registerOnTouched' );
    }

    setDisabledState(isDisabled: boolean) : void {
        console.log( 'setDisabledState' );
    }
}
