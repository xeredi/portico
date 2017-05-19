import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SettingsRoutingModule } from './settings-routing.module';
import { HomeComponent } from './home.component';
import { SuperportGridComponent } from './superport-grid.component';
import { SuperportComponent } from './superport.component';
import { SuperportEditComponent } from './superport-edit.component';
import { PortGridComponent } from './port-grid.component';
import { PortComponent } from './port.component';
import { PortEditComponent } from './port-edit.component';
import { ConfigurationGridComponent } from './configuration-grid.component';
import { ConfigurationComponent } from './configuration.component';
import { ConfigurationEditComponent } from './configuration-edit.component';
import { I18nMessageGridComponent } from './i18n-message-grid.component';
import { I18nMessageComponent } from './i18n-message.component';
import { I18nMessageEditComponent } from './i18n-message-edit.component';

@NgModule( {
    imports: [
        CommonModule,
        SettingsRoutingModule
    ],
    declarations: [HomeComponent, SuperportGridComponent, SuperportComponent, SuperportEditComponent, PortGridComponent, PortComponent, PortEditComponent, ConfigurationGridComponent, ConfigurationComponent, ConfigurationEditComponent, I18nMessageGridComponent, I18nMessageComponent, I18nMessageEditComponent]
} )
export class SettingsModule { }
