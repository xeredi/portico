import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { SuperportGridComponent } from './superport-grid.component';
import { SuperportDetailComponent } from './superport-detail.component';
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
    , { path: 'superport/detail/:id', component: SuperportDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'superport/edit/:action', component: SuperportEditComponent, canActivate: [PermissionGuard] }
    , { path: 'superport/edit/:action/:id', component: SuperportEditComponent, canActivate: [PermissionGuard] }
    , { path: 'superport/create', component: SuperportEditComponent, canActivate: [PermissionGuard] }
    , { path: 'port/grid', component: PortGridComponent, canActivate: [PermissionGuard] }
    , { path: 'port/detail/:id', component: PortComponent, canActivate: [PermissionGuard] }
    , { path: 'port/edit/:action', component: PortEditComponent, canActivate: [PermissionGuard] }
    , { path: 'port/edit/:action/:id', component: PortEditComponent, canActivate: [PermissionGuard] }
    , { path: 'port/create', component: PortEditComponent, canActivate: [PermissionGuard] }
    , { path: 'configuration/grid', component: ConfigurationGridComponent, canActivate: [PermissionGuard] }
    , { path: 'configuration/detail/:key', component: ConfigurationComponent, canActivate: [PermissionGuard] }
    , { path: 'configuration/edit/:action/:key', component: ConfigurationEditComponent, canActivate: [PermissionGuard] }
    , { path: 'i18n-message/grid', component: I18nMessageGridComponent, canActivate: [PermissionGuard] }
    , { path: 'i18n-message/detail/:key', component: I18nMessageComponent, canActivate: [PermissionGuard] }
    , { path: 'i18n-message/edit/:action/:key', component: I18nMessageEditComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class SettingsRoutingModule { }
