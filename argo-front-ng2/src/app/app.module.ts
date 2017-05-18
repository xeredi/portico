import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login.component';
import { HomeComponent } from './home.component';
import { AlertComponent } from './alert.component';

import { PermissionGuard } from './permission.guard';

import { AlertService } from './alert.service';
import { AuthenticationService } from './authentication.service';

import { SecurityModule } from './security/security.module';


@NgModule( {
    declarations: [
        AppComponent,
        LoginComponent,
        HomeComponent,
        AlertComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
        SecurityModule
    ],
    providers: [
        PermissionGuard,
        AlertService,
        AuthenticationService
    ],
    bootstrap: [AppComponent]
} )
export class AppModule { }