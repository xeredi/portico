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
    ]
    , providers: [
        ParameterTypeService
        , EntityDatagroupService
        , EntityDatatypeService
        , EntityActionService
        , SubparameterTypeService
    ]
    , schemas: [
    ]
} )
export class MetamodelModule { }
