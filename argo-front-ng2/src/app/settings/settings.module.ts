import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { SharedModule } from '../shared/shared.module';

import { SettingsRoutingModule } from './settings-routing.module';
import { HomeComponent } from './home.component';
import { SuperportGridComponent } from './superport-grid.component';
import { SuperportDetailComponent } from './superport-detail.component';
import { SuperportEditComponent } from './superport-edit.component';
import { PortGridComponent } from './port-grid.component';
import { PortDetailComponent } from './port-detail.component';
import { PortEditComponent } from './port-edit.component';
import { ConfigurationGridComponent } from './configuration-grid.component';
import { ConfigurationComponent } from './configuration.component';
import { ConfigurationEditComponent } from './configuration-edit.component';
import { I18nMessageGridComponent } from './i18n-message-grid.component';
import { I18nMessageComponent } from './i18n-message.component';
import { I18nMessageEditComponent } from './i18n-message-edit.component';

import { SuperportService } from './superport.service';
import { PortService } from './port.service';
import { ConfigurationService } from './configuration.service';
import { I18nMessageService } from './i18n-message.service';

@NgModule( {
    imports: [
        FormsModule
        , CommonModule
        , NgbModule

        , SharedModule
        , SettingsRoutingModule
    ]
    , declarations: [
        HomeComponent
        , SuperportGridComponent
        , SuperportDetailComponent
        , SuperportEditComponent
        , PortGridComponent
        , PortDetailComponent
        , PortEditComponent
        , ConfigurationGridComponent
        , ConfigurationComponent
        , ConfigurationEditComponent
        , I18nMessageGridComponent
        , I18nMessageComponent
        , I18nMessageEditComponent
    ]
    , providers: [
        SuperportService
        , PortService
        , ConfigurationService
        , I18nMessageService
    ]
    , schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
} )
export class SettingsModule { }
