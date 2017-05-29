import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AlertComponent } from './alert.component';
import { I18nInfoDetailComponent } from './i18n-info-detail.component';
import { I18nInfoEditComponent } from './i18n-info-edit.component';

import { PermissionGuard } from './permission.guard';

import { AlertService } from './alert.service';
import { CrudService } from './crud.service';
import { I18nInfoService } from './i18n-info.service';


@NgModule( {
    imports: [
        CommonModule
        , FormsModule
    ]
    , declarations: [
        AlertComponent
        , I18nInfoDetailComponent
        , I18nInfoEditComponent
    ]
    , providers: [
        PermissionGuard
        , AlertService
        , CrudService
        , I18nInfoService
    ]
    , exports: [
        AlertComponent
        , I18nInfoDetailComponent
        , I18nInfoEditComponent
    ]
} )
export class SharedModule { }
