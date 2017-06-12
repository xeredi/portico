import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { NguiDatetimePickerModule } from '@ngui/datetime-picker';
import { NgSpinKitModule } from 'ng-spin-kit'

import { MasterModule } from '../master/master.module';
import { ServiceModule } from '../service/service.module';

import { PermissionGuard } from './permission.guard';

import { CrudService } from './crud.service';

import { AlertService } from './alert.service';
import { AlertComponent } from './alert.component';

import { I18nInfoDetailComponent } from './i18n-info-detail.component';
import { I18nInfoEditComponent } from './i18n-info-edit.component';

import { SpinnerService } from './spinner.service';
import { SpinnerComponent } from './spinner.component';


@NgModule( {
    imports: [
        CommonModule
        , FormsModule
        , NgbModule
        , TranslateModule
        , NguiDatetimePickerModule
        , NgSpinKitModule
    ]
    , declarations: [
        AlertComponent
        , I18nInfoDetailComponent
        , I18nInfoEditComponent
        , SpinnerComponent
    ]
    , providers: [
        PermissionGuard
        , AlertService
        , CrudService
        , SpinnerService
    ]
    , exports: [
        AlertComponent
        , I18nInfoDetailComponent
        , I18nInfoEditComponent
        , SpinnerComponent

        , CommonModule
        , FormsModule
        , TranslateModule
        , NgbModule
        , NguiDatetimePickerModule
    ]
} )
export class SharedModule { }
