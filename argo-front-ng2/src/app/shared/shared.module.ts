import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlertComponent } from './alert.component';

import { PermissionGuard } from './permission.guard';

import { AlertService } from './alert.service';
import { CrudService } from './crud.service';


@NgModule( {
    imports: [
        CommonModule
    ],
    declarations: [
        AlertComponent
    ],
    providers: [
        PermissionGuard,
        AlertService,
        CrudService
    ], exports: [
        AlertComponent
    ]
} )
export class SharedModule { }
