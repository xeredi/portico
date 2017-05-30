import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpModule, Http, XHRBackend, RequestOptions } from '@angular/http';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { NguiDatetimePickerModule } from '@ngui/datetime-picker';

import { httpFactory } from "./http.factory";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login.component';
import { HomeComponent } from './home.component';

import { AuthenticationService } from './authentication.service';

import { SharedModule } from './shared/shared.module';
import { SecurityModule } from './security/security.module';
import { SettingsModule } from './settings/settings.module';
import { MetamodelModule } from './metamodel/metamodel.module';
import { BillingModule } from './billing/billing.module';

import { AlertService } from './shared/alert.service';

export function HttpLoaderFactory( http: Http ) {
    return new TranslateHttpLoader( http );
}

@NgModule( {
    declarations: [
        AppComponent
        , LoginComponent
        , HomeComponent
    ]
    , imports: [
        BrowserModule
        , FormsModule
        , HttpModule
        , NgbModule.forRoot()
        , TranslateModule.forRoot( {
            loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [Http]
            }
        } )
        , NguiDatetimePickerModule
        , AppRoutingModule
        , SharedModule
        , SecurityModule
        , SettingsModule
        , MetamodelModule
        , BillingModule
    ]
    , providers: [
        AuthenticationService
        , { provide: LocationStrategy, useClass: HashLocationStrategy }
        , {
            provide: Http,
            deps: [XHRBackend, RequestOptions, AlertService, Router],
            useFactory: httpFactory
        }
        /*
*/
    ]
    , bootstrap: [AppComponent]
    , exports: [
        BrowserModule
        , HttpModule
        , TranslateModule
    ]
} )
export class AppModule { }