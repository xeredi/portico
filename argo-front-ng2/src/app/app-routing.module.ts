import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { LoginComponent } from './login.component';

import { PermissionGuard } from './shared/permission.guard';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'login', component: LoginComponent }
    , { path: 'security', loadChildren: './security/security.module#SecurityModule' }

    // otherwise redirect to home
    , { path: '**', redirectTo: '' }
];

@NgModule( {
    imports: [RouterModule.forRoot( routes )],
    exports: [RouterModule]
} )
export class AppRoutingModule { }