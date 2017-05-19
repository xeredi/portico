import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { GroupGridComponent } from './group-grid.component';
import { GroupComponent } from './group.component';
import { GroupEditComponent } from './group-edit.component';
import { UserGridComponent } from './user-grid.component';
import { UserComponent } from './user.component';
import { UserEditComponent } from './user-edit.component';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'group/grid', component: GroupGridComponent, canActivate: [PermissionGuard] }
    , { path: 'group/create', component: GroupEditComponent, canActivate: [PermissionGuard] }
    , { path: 'user/grid', component: UserGridComponent, canActivate: [PermissionGuard] }
    , { path: 'user/create', component: UserEditComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class SecurityRoutingModule { }
