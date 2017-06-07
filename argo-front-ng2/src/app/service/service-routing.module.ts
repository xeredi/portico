import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { ServiceGridComponent } from './service-grid.component';
import { ServiceDetailComponent } from './service-detail.component';
import { ServiceEditComponent } from './service-edit.component';
import { ServiceTypeaheadComponent } from './service-typeahead.component';
import { SubserviceGridComponent } from './subservice-grid.component';
import { SubserviceDetailComponent } from './subservice-detail.component';
import { SubserviceEditComponent } from './subservice-edit.component';
import { SubserviceTypeaheadComponent } from './subservice-typeahead.component';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'service/grid/:entiId', component: ServiceGridComponent, canActivate: [PermissionGuard] }
    , { path: 'service/detail/:entiId/:id', component: ServiceDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'service/edit/:action/:entiId', component: ServiceEditComponent, canActivate: [PermissionGuard] }
    , { path: 'service/edit/:action/:entiId/:id', component: ServiceEditComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice/grid/:entiId', component: SubserviceGridComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice/detail/:entiId/:id/:date', component: SubserviceDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice/edit/:action/:entiId/:serviceId', component: SubserviceEditComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice/edit/:action/:entiId/:serviceId/:id', component: SubserviceEditComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class ServiceRoutingModule { }
