import { NgModule } from '@angular/core';

import { ItemRoutingModule } from './item-routing.module';
import { SharedModule } from '../shared/shared.module';

import { ParameterService } from './parameter.service';
import { ServiceService } from './service.service';
import { SubserviceService } from './subservice.service';

import { ParameterTypeaheadComponent } from './parameter-typeahead.component';
import { ServiceTypeaheadComponent } from './service-typeahead.component';
import { SubserviceTypeaheadComponent } from './subservice-typeahead.component';
import { ItemDetailFragmentComponent } from './item-detail-fragment.component';
import { ItemEditFragmentComponent } from './item-edit-fragment.component';
import { ItemFilterFragmentComponent } from './item-filter-fragment.component';

@NgModule( {
    imports: [
        ItemRoutingModule
        , SharedModule
    ]
    , declarations: [
        ParameterTypeaheadComponent
        , ServiceTypeaheadComponent
        , SubserviceTypeaheadComponent
        , ItemDetailFragmentComponent
        , ItemEditFragmentComponent
        , ItemFilterFragmentComponent
    ]
    , providers: [
        ParameterService
        , ServiceService
        , SubserviceService
    ]
    , exports: [
        ParameterTypeaheadComponent
        , ServiceTypeaheadComponent
        , SubserviceTypeaheadComponent
        , ItemDetailFragmentComponent
        , ItemEditFragmentComponent
        , ItemFilterFragmentComponent
    ]
} )
export class ItemModule { }
