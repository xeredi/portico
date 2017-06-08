import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { NguiDatetimePickerModule } from '@ngui/datetime-picker';

import { PermissionGuard } from './permission.guard';

import { CrudService } from './crud.service';

import { AlertService } from './alert.service';
import { AlertComponent } from './alert.component';

import { I18nInfoDetailComponent } from './i18n-info-detail.component';
import { I18nInfoEditComponent } from './i18n-info-edit.component';

import { ItemDetailFragmentComponent } from './item-detail-fragment.component';
import { ItemEditFragmentComponent } from './item-edit-fragment.component';
import { ItemFilterFragmentComponent } from './item-filter-fragment.component';


@NgModule( {
    imports: [
        CommonModule
        , FormsModule
        , NgbModule
        , TranslateModule
        , NguiDatetimePickerModule
    ]
    , declarations: [
        AlertComponent
        , I18nInfoDetailComponent
        , I18nInfoEditComponent
        , ItemDetailFragmentComponent
        , ItemEditFragmentComponent
        , ItemFilterFragmentComponent
    ]
    , providers: [
        PermissionGuard
        , AlertService
        , CrudService
    ]
    , exports: [
        AlertComponent
        , I18nInfoDetailComponent
        , I18nInfoEditComponent
        , ItemDetailFragmentComponent
        , ItemEditFragmentComponent
        , ItemFilterFragmentComponent
    ]
} )
export class SharedModule { }
