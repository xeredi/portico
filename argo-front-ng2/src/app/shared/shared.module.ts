import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlertComponent } from './alert.component';

import { PermissionGuard } from './permission.guard';

import { AlertService } from './alert.service';


@NgModule( {
    imports: [
        CommonModule
    ],
    declarations: [
        AlertComponent
    ],
    providers: [
        PermissionGuard,
        AlertService
    ], exports: [
        AlertComponent
    ]
} )
export class SharedModule { }
