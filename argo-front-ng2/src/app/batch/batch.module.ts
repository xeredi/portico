import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';

import { ProcessService } from './process.service';

import { BatchRoutingModule } from './batch-routing.module';
import { HomeComponent } from './home.component';
import { ProcessGridComponent } from './process-grid.component';
import { ProcessDetailComponent } from './process-detail.component';
import { ProcessFilterFragmentComponent } from './process-filter-fragment.component';
import { ProcessItemFragmentComponent } from './process-item-fragment.component';
import { ProcessMessageGridFragmentComponent } from './process-message-grid-fragment.component';
import { FileInfoFragmentComponent } from './file-info-fragment.component';

@NgModule( {
    imports: [
        CommonModule
        , BatchRoutingModule
        , SharedModule
    ]
    , declarations: [
        HomeComponent
        , ProcessGridComponent
        , ProcessDetailComponent, ProcessFilterFragmentComponent, ProcessItemFragmentComponent, ProcessMessageGridFragmentComponent, FileInfoFragmentComponent
    ]
    , providers: [
        ProcessService
    ]
} )
export class BatchModule { }
