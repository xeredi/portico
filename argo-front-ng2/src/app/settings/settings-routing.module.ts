import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

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

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'superport/grid', component: SuperportGridComponent, canActivate: [PermissionGuard] }
    , { path: 'superport/create', component: SuperportEditComponent, canActivate: [PermissionGuard] }
    , { path: 'port/grid', component: PortGridComponent, canActivate: [PermissionGuard] }
    , { path: 'port/create', component: PortEditComponent, canActivate: [PermissionGuard] }
    , { path: 'configuration/grid', component: ConfigurationGridComponent, canActivate: [PermissionGuard] }
    , { path: 'configuration/detail/:key', component: ConfigurationComponent, canActivate: [PermissionGuard] }
    , { path: 'i18n-message/grid', component: I18nMessageGridComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class SettingsRoutingModule { }
