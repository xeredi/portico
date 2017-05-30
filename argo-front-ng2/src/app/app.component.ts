import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component( {
    moduleId: module.id,
    selector: 'app',
    template: `
<!-- main app container -->
<div class="jumbotron">
    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <span class="navbar-brand">ARGO</span>

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li *ngIf="existsLocalStorageItem('currentUser')" class="nav-item active"><a class="nav-link"
                    [routerLink]="['/']">Home <span class="sr-only">(current)</span></a></li>
                <li *ngIf="existsLocalStorageItem('currentUser')" class="nav-item"><a class="nav-link"
                    [routerLink]="['/login']">Logout</a></li>
                <li *ngIf="!existsLocalStorageItem('currentUser')" class="nav-item"><a class="nav-link"
                    [routerLink]="['/login']">Login</a></li>
            </ul>
        </div>
    </nav>

        <alert></alert>
        <router-outlet></router-outlet>
</div>
    `
} )
export class AppComponent {

    constructor( private translate: TranslateService ) {
        translate.addLangs( ["es", "ca", "en"] );
        translate.setDefaultLang( 'es' );
        translate.use( 'es' );
    }

    public localStorageItem( id: string ): string {
        return localStorage.getItem( id );
    }

    public existsLocalStorageItem( id: string ): boolean {
        return localStorage.getItem( id ) != null;
    }
}

