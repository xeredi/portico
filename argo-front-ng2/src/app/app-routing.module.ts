import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home.component';
import { LoginComponent } from './login.component';

import { PermissionGuard } from './shared/permission.guard';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'login', component: LoginComponent }
    , { path: 'security', loadChildren: './security/security.module#SecurityModule' }
    , { path: 'settings', loadChildren: './settings/settings.module#SettingsModule' }
    , { path: 'metamodel', loadChildren: './metamodel/metamodel.module#MetamodelModule' }
    , { path: 'billing', loadChildren: './billing/billing.module#BillingModule' }
    , { path: 'master', loadChildren: './master/master.module#MasterModule' }
    , { path: 'service', loadChildren: './service/service.module#ServiceModule' }

    // otherwise redirect to home
    , { path: '**', redirectTo: '' }
];

@NgModule( {
    imports: [RouterModule.forRoot( routes )],
    exports: [RouterModule]
} )
export class AppRoutingModule { }
