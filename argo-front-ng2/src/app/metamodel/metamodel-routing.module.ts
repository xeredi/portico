import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { ModuleGridComponent } from './module-grid.component';
import { ModuleDetailComponent } from './module-detail.component';
import { ModuleEditComponent } from './module-edit.component';
import { DataTypeGridComponent } from './data-type-grid.component';
import { DataTypeDetailComponent } from './data-type-detail.component';
import { DataTypeEditComponent } from './data-type-edit.component';
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
import { StatusChangeDetailComponent } from './status-change-detail.component';
import { StatusChangeEditComponent } from './status-change-edit.component';
import { StatusChangeDatatypeDetailComponent } from './status-change-datatype-detail.component';
import { StatusChangeDatatypeEditComponent } from './status-change-datatype-edit.component';
import { SubserviceTypeDetailComponent } from './subservice-type-detail.component';
import { SubserviceTypeEditComponent } from './subservice-type-edit.component';
import { ReferenceCodeDetailComponent } from './reference-code-detail.component';
import { ReferenceCodeEditComponent } from './reference-code-edit.component';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'module/grid', component: ModuleGridComponent, canActivate: [PermissionGuard] }
    , { path: 'module/detail/:id', component: ModuleDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'module/edit/:action', component: ModuleEditComponent, canActivate: [PermissionGuard] }
    , { path: 'module/edit/:action/:id', component: ModuleEditComponent, canActivate: [PermissionGuard] }
    , { path: 'data-type/grid', component: DataTypeGridComponent, canActivate: [PermissionGuard] }
    , { path: 'data-type/detail/:id', component: DataTypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'data-type/edit/:action', component: DataTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'data-type/edit/:action/:id', component: DataTypeEditComponent, canActivate: [PermissionGuard] }
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
    , { path: 'status-change/detail/:id', component: StatusChangeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'status-change/edit/:action/:entityId', component: StatusChangeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'status-change/edit/:action/:entityId/:id', component: StatusChangeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'status-change-datatype/detail/:statusChangeId/:dataTypeId', component: StatusChangeDatatypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'status-change-datatype/edit/:action/:statusChangeId', component: StatusChangeDatatypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'status-change-datatype/edit/:action/:statusChangeId/:dataTypeId', component: StatusChangeDatatypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice-type/detail/:id', component: SubserviceTypeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice-type/edit/:action/:serviceTypeId', component: SubserviceTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'subservice-type/edit/:action/:serviceTypeId/:id', component: SubserviceTypeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'reference-code/detail/:id', component: ReferenceCodeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'reference-code/edit/:action/:datatypeId', component: ReferenceCodeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'reference-code/edit/:action/:datatypeId/:id', component: ReferenceCodeEditComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class MetamodelRoutingModule { }
