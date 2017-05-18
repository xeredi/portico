import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login.component';
import { HomeComponent } from './home.component';

import { AuthenticationService } from './authentication.service';

import { SharedModule } from './shared/shared.module';
import { SecurityModule } from './security/security.module';


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
        SecurityModule
    ],
    providers: [
        AuthenticationService
    ],
    bootstrap: [AppComponent]
} )
export class AppModule { }