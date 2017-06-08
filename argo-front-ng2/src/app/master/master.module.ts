import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { NguiDatetimePickerModule } from '@ngui/datetime-picker';

import { SharedModule } from '../shared/shared.module';
import { MasterRoutingModule } from './master-routing.module';

import { MasterService } from './master.service';
import { ParameterService } from './parameter.service';
import { SubparameterService } from './subparameter.service';

import { HomeComponent } from './home.component';
import { ParameterGridComponent } from './parameter-grid.component';
import { ParameterDetailComponent } from './parameter-detail.component';
import { ParameterEditComponent } from './parameter-edit.component';
import { ParameterTypeaheadComponent } from './parameter-typeahead.component';
import { SubparameterGridFragmentComponent } from './subparameter-grid-fragment.component';
import { SubparameterDetailComponent } from './subparameter-detail.component';
import { SubparameterEditComponent } from './subparameter-edit.component';

@NgModule( {
    imports: [
        FormsModule
        , CommonModule
        , NgbModule
        , TranslateModule
        , NguiDatetimePickerModule

        , SharedModule
        , MasterRoutingModule
    ]
    , declarations: [
        HomeComponent
        , ParameterGridComponent
        , ParameterDetailComponent
        , ParameterEditComponent
        , ParameterTypeaheadComponent
        , SubparameterGridFragmentComponent
        , SubparameterDetailComponent
        , SubparameterEditComponent
    ]
    , providers: [
        MasterService
        , ParameterService
        , SubparameterService
    ]
    , exports: [
        ParameterTypeaheadComponent
    ]
} )
export class MasterModule { }
