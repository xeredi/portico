import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { ParameterTypeGridComponent } from './parameter-type-grid.component';
import { ParameterTypeDetailComponent } from './parameter-type-detail.component';
import { ParameterTypeEditComponent } from './parameter-type-edit.component';
import { ServiceTypeGridComponent } from './service-type-grid.component';
import { ServiceTypeDetailComponent } from './service-type-detail.component';
import { ServiceTypeEditComponent } from './service-type-edit.component';
import { EntityDatagroupDetailComponent } from './entity-datagroup-detail.component';
import { EntityDatagroupEditComponent } from './entity-datagroup-edit.component';
import { EntityDatatypeDetailComponent } from './entity-datatype-detail.component';
import { EntityDatatypeEditComponent } from './entity-datatype-edit.component';
import { EntityActionDetailComponent } from './entity-action-detail.component';
import { EntityActionEditComponent } from './entity-action-edit.component';
import { SubparameterTypeDetailComponent } from './subparameter-type-detail.component';
import { SubparameterTypeEditComponent } from './subparameter-type-edit.component';
import { SpecialActionDetailComponent } from './special-action-detail.component';
import { SpecialActionEditComponent } from './special-action-edit.component';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'parameter-type/grid', component: ParameterTypeGridComponent, canActivate: [PermissionGuard] }
    , { path: 'parameter-type/detail/:id', component: ParameterTypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'parameter-type/edit/:action', component: ParameterTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'parameter-type/edit/:action/:id', component: ParameterTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-datagroup/detail/:id', component: EntityDatagroupDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-datagroup/edit/:action/:entityId', component: EntityDatagroupEditComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-datagroup/edit/:action/:entityId/:id', component: EntityDatagroupEditComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-datatype/detail/:id', component: EntityDatatypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-datatype/edit/:action/:entityId', component: EntityDatatypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-datatype/edit/:action/:entityId/:id', component: EntityDatatypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-action/detail/:id', component: EntityActionDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-action/edit/:action/:entityId', component: EntityActionEditComponent, canActivate: [PermissionGuard] }
    , { path: 'entity-action/edit/:action/:entityId/:id', component: EntityActionEditComponent, canActivate: [PermissionGuard] }
    , { path: 'subparameter-type/detail/:id', component: SubparameterTypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'subparameter-type/edit/:action/:entityId', component: SubparameterTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'subparameter-type/edit/:action/:entityId/:id', component: SubparameterTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'service-type/grid', component: ServiceTypeGridComponent, canActivate: [PermissionGuard] }
    , { path: 'service-type/detail/:id', component: ServiceTypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'service-type/edit/:action', component: ServiceTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'service-type/edit/:action/:id', component: ServiceTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'special-action/detail/:id', component: SpecialActionDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'special-action/edit/:action/:entityId', component: SpecialActionEditComponent, canActivate: [PermissionGuard] }
    , { path: 'special-action/edit/:action/:entityId/:id', component: SpecialActionEditComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class MetamodelRoutingModule { }
