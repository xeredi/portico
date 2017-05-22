import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http, XHRBackend, RequestOptions } from '@angular/http';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

import { httpFactory } from "./http.factory";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login.component';
import { HomeComponent } from './home.component';

import { AuthenticationService } from './authentication.service';

import { SharedModule } from './shared/shared.module';
import { SecurityModule } from './security/security.module';
import { SettingsModule } from './settings/settings.module';

import { AlertService } from './shared/alert.service';


@NgModule( {
    declarations: [
        AppComponent,
        LoginComponent,
        HomeComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
        SharedModule,
        SecurityModule,
        SettingsModule
    ],
    providers: [
        AuthenticationService
        , { provide: LocationStrategy, useClass: HashLocationStrategy }
        , {
            provide: Http,
            deps: [XHRBackend, RequestOptions, AlertService],
            useFactory: httpFactory
        }
    ],
    bootstrap: [AppComponent]
} )
export class AppModule { }