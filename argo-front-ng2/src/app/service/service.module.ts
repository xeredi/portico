import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule } from '@ngx-translate/core';
import { NguiDatetimePickerModule } from '@ngui/datetime-picker';

import { SharedModule } from '../shared/shared.module';

import { ServiceRoutingModule } from './service-routing.module';

import { ServiceHomeService } from './service-home.service';
import { ServiceService } from './service.service';
import { SubserviceService } from './subservice.service';

import { HomeComponent } from './home.component';
import { ServiceGridComponent } from './service-grid.component';
import { ServiceDetailComponent } from './service-detail.component';
import { ServiceEditComponent } from './service-edit.component';
import { ServiceTypeaheadComponent } from './service-typeahead.component';
import { SubserviceGridComponent } from './subservice-grid.component';
import { SubserviceGridFragmentComponent } from './subservice-grid-fragment.component';
import { SubserviceDetailComponent } from './subservice-detail.component';
import { SubserviceEditComponent } from './subservice-edit.component';
import { SubserviceTypeaheadComponent } from './subservice-typeahead.component';

@NgModule( {
    imports: [
        FormsModule
        , CommonModule
        , NgbModule
        , TranslateModule
        , NguiDatetimePickerModule

        , SharedModule
        , ServiceRoutingModule
    ]
    , declarations: [
        HomeComponent
        , ServiceGridComponent
        , ServiceDetailComponent
        , ServiceEditComponent
        , ServiceTypeaheadComponent
        , SubserviceGridComponent
        , SubserviceGridFragmentComponent
        , SubserviceDetailComponent
        , SubserviceEditComponent
        , SubserviceTypeaheadComponent
    ]
    , providers: [
        ServiceHomeService
        , ServiceService
        , SubserviceService
    ]
} )
export class ServiceModule { }
