import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { SettingsModule } from '../settings/settings.module';

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

@NgModule( {
    imports: [
        FormsModule
        , CommonModule
        , NgbModule
        , MetamodelRoutingModule
        , SettingsModule
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
    ]
    , providers: [
        ParameterTypeService
        , EntityDatagroupService
        , EntityDatatypeService
    ]
    , schemas: [
        CUSTOM_ELEMENTS_SCHEMA
    ]
} )
export class MetamodelModule { }
