import { Component, Input } from '@angular/core';

@Component( {
    selector: 'app-i18n-info-detail',
    template: `
<div class="row">
    <div *ngFor="let availableLanguage of availableLanguages" class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
        <label>{{availableLanguage}}</label>
        <p class="form-control-static form-control-sm">{{i18nMap[availableLanguage]?.text}}</p>
    </div>
</div>
`
} )
export class I18nInfoDetailComponent {
    @Input() availableLanguages: string[] = [];
    @Input() i18nMap: any = {};
}
