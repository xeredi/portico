import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';

import { MetamodelRoutingModule } from './metamodel-routing.module';
import { HomeComponent } from './home.component';

import { ParameterTypeService } from './parameter-type.service';
import { ParameterTypeGridComponent } from './parameter-type-grid.component';
import { ParameterTypeDetailComponent } from './parameter-type-detail.component';
import { ParameterTypeEditComponent } from './parameter-type-edit.component';

import { EntityDatagroupService } from './entity-datagroup.service';
import { EntityDatagroupGridFragmentComponent } from './entity-datagroup-grid-fragment.component';
import { EntityDatagroupDetailComponent } from './entity-datagroup-detail.component';
import { EntityDatagroupEditComponent } from './entity-datagroup-edit.component';

import { EntityDatatypeService } from './entity-datatype.service';
import { EntityDatatypeGridFragmentComponent } from './entity-datatype-grid-fragment.component';
import { EntityDatatypeDetailComponent } from './entity-datatype-detail.component';
import { EntityDatatypeEditComponent } from './entity-datatype-edit.component';

import { EntityActionService } from './entity-action.service';
import { EntityActionGridFragmentComponent } from './entity-action-grid-fragment.component';
import { EntityActionDetailComponent } from './entity-action-detail.component';
import { EntityActionEditComponent } from './entity-action-edit.component';

import { SubparameterTypeService } from './subparameter-type.service';
import { SubparameterTypeGridFragmentComponent } from './subparameter-type-grid-fragment.component';
import { SubparameterTypeDetailComponent } from './subparameter-type-detail.component';
import { SubparameterTypeEditComponent } from './subparameter-type-edit.component';

import { ServiceTypeService } from './service-type.service';
import { ServiceTypeGridComponent } from './service-type-grid.component';
import { ServiceTypeDetailComponent } from './service-type-detail.component';
import { ServiceTypeEditComponent } from './service-type-edit.component';

import { SpecialActionService } from './special-action.service';
import { SpecialActionGridFragmentComponent } from './special-action-grid-fragment.component';
import { SpecialActionDetailComponent } from './special-action-detail.component';
import { SpecialActionEditComponent } from './special-action-edit.component';

import { ModuleService } from './module.service';
import { ModuleGridComponent } from './module-grid.component';
import { ModuleDetailComponent } from './module-detail.component';
import { ModuleEditComponent } from './module-edit.component';

import { DataTypeService } from './data-type.service';
import { DataTypeGridComponent } from './data-type-grid.component';
import { DataTypeDetailComponent } from './data-type-detail.component';
import { DataTypeEditComponent } from './data-type-edit.component';

import { StatusChangeService } from './status-change.service';
import { StatusChangeDatatypeService } from './status-change-datatype.service';
import { StatusChangeGridFragmentComponent } from './status-change-grid-fragment.component';
import { StatusChangeDetailComponent } from './status-change-detail.component';
import { StatusChangeEditComponent } from './status-change-edit.component';
import { StatusChangeDatatypeGridFragmentComponent } from './status-change-datatype-grid-fragment.component';
import { StatusChangeDatatypeDetailComponent } from './status-change-datatype-detail.component';
import { StatusChangeDatatypeEditComponent } from './status-change-datatype-edit.component';

import { SubserviceTypeService } from './subservice-type.service';
import { SubserviceTypeGridFragmentComponent } from './subservice-type-grid-fragment.component';
import { SubserviceTypeDetailComponent } from './subservice-type-detail.component';
import { SubserviceTypeEditComponent } from './subservice-type-edit.component';
import { EntityGridFragmentComponent } from './entity-grid-fragment.component';

import { ReferenceCodeService } from './reference-code.service';
import { ReferenceCodeGridFragmentComponent } from './reference-code-grid-fragment.component';
import { ReferenceCodeDetailComponent } from './reference-code-detail.component';
import { ReferenceCodeEditComponent } from './reference-code-edit.component';

@NgModule( {
    imports: [
        MetamodelRoutingModule
        , SharedModule
    ]
    , declarations: [
        HomeComponent
        , ParameterTypeGridComponent
        , ParameterTypeDetailComponent
        , ParameterTypeEditComponent
        , EntityDatagroupGridFragmentComponent
        , EntityDatagroupDetailComponent
        , EntityDatagroupEditComponent
        , EntityDatatypeGridFragmentComponent
        , EntityDatatypeDetailComponent
        , EntityDatatypeEditComponent
        , EntityActionGridFragmentComponent
        , EntityActionDetailComponent
        , EntityActionEditComponent
        , SubparameterTypeGridFragmentComponent
        , SubparameterTypeDetailComponent
        , SubparameterTypeEditComponent
        , ServiceTypeGridComponent
        , ServiceTypeDetailComponent
        , ServiceTypeEditComponent
        , StatusChangeGridFragmentComponent
        , SpecialActionGridFragmentComponent
        , SpecialActionDetailComponent
        , SpecialActionEditComponent
        , ModuleGridComponent
        , ModuleDetailComponent
        , ModuleEditComponent
        , DataTypeGridComponent
        , DataTypeDetailComponent
        , DataTypeEditComponent
        , StatusChangeDetailComponent
        , StatusChangeEditComponent
        , StatusChangeDatatypeGridFragmentComponent
        , StatusChangeDatatypeDetailComponent
        , StatusChangeDatatypeEditComponent
        , SubserviceTypeGridFragmentComponent
        , SubserviceTypeDetailComponent
        , SubserviceTypeEditComponent
        , EntityGridFragmentComponent
        , ReferenceCodeGridFragmentComponent
        , ReferenceCodeDetailComponent
        , ReferenceCodeEditComponent
    ]
    , providers: [
        ParameterTypeService
        , EntityDatagroupService
        , EntityDatatypeService
        , EntityActionService
        , SubparameterTypeService
        , ServiceTypeService
        , SubserviceTypeService
        , SpecialActionService
        , ModuleService
        , DataTypeService
        , ReferenceCodeService
        , StatusChangeService
        , StatusChangeDatatypeService
    ]
    , schemas: [
    ]
} )
export class MetamodelModule { }
