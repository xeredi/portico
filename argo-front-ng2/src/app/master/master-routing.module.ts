import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { ParameterGridComponent } from './parameter-grid.component';
import { ParameterDetailComponent } from './parameter-detail.component';
import { ParameterEditComponent } from './parameter-edit.component';
import { ParameterTypeaheadComponent } from './parameter-typeahead.component';
import { SubparameterDetailComponent } from './subparameter-detail.component';
import { SubparameterEditComponent } from './subparameter-edit.component';

@NgModule( {
    imports: [
        RouterModule.forChild( [
            { path: 'master-home', component: HomeComponent, canActivate: [PermissionGuard] }
            , { path: 'parameter/grid/:entiId', component: ParameterGridComponent, canActivate: [PermissionGuard] }
            , { path: 'parameter/detail/:entiId/:id/:date', component: ParameterDetailComponent, canActivate: [PermissionGuard] }
            , { path: 'parameter/edit/:action/:entiId', component: ParameterEditComponent, canActivate: [PermissionGuard] }
            , { path: 'parameter/edit/:action/:entiId/:id/:date', component: ParameterEditComponent, canActivate: [PermissionGuard] }
            , { path: 'subparameter/detail/:entiId/:id/:date', component: SubparameterDetailComponent, canActivate: [PermissionGuard] }
            , { path: 'subparameter/edit/:action/:entiId/:parameterId', component: SubparameterEditComponent, canActivate: [PermissionGuard] }
            , { path: 'subparameter/edit/:action/:entiId/:parameterId/:id/:date', component: SubparameterEditComponent, canActivate: [PermissionGuard] }
        ] )
    ]
    , exports: [RouterModule]
} )
export class MasterRoutingModule { }
