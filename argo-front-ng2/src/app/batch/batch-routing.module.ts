import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { ProcessGridComponent } from './process-grid.component';
import { ProcessDetailComponent } from './process-detail.component';


const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'process/grid', component: ProcessGridComponent, canActivate: [PermissionGuard] }
    , { path: 'process/detail/:id', component: ProcessDetailComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [
        RouterModule.forChild( routes )
    ]
    , exports: [RouterModule]
} )
export class BatchRoutingModule { }
