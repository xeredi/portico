import { NgModule } from '@angular/core';

import { SharedModule } from '../shared/shared.module';
import { ItemModule } from '../item/item.module';

import { MasterRoutingModule } from './master-routing.module';

import { MasterService } from './master.service';
import { SubparameterService } from './subparameter.service';

import { HomeComponent } from './home.component';
import { ParameterGridComponent } from './parameter-grid.component';
import { ParameterDetailComponent } from './parameter-detail.component';
import { ParameterEditComponent } from './parameter-edit.component';
import { SubparameterGridFragmentComponent } from './subparameter-grid-fragment.component';
import { SubparameterDetailComponent } from './subparameter-detail.component';
import { SubparameterEditComponent } from './subparameter-edit.component';

@NgModule( {
    imports: [
        MasterRoutingModule
        , SharedModule
        , ItemModule
    ]
    , declarations: [
        HomeComponent
        , ParameterGridComponent
        , ParameterDetailComponent
        , ParameterEditComponent
        , SubparameterGridFragmentComponent
        , SubparameterDetailComponent
        , SubparameterEditComponent
    ]
    , providers: [
        MasterService
        , SubparameterService
    ]
    , exports: [
    ]
} )
export class MasterModule { }
