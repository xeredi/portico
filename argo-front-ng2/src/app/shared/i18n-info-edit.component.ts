import { Component, Input, OnInit } from '@angular/core';

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
export class I18nInfoEditComponent implements OnInit {
    @Input() availableLanguages: string[];
    @Input() i18nMap: Map<string, any>;

    ngOnInit() {
        for ( let availableLanguage of this.availableLanguages ) {
            this.i18nMap[availableLanguage] = this.i18nMap[availableLanguage] ? this.i18nMap[availableLanguage] : {}
        }
    }
}
