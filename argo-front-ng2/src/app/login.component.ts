import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AuthenticationService } from './authentication.service';
import { AlertService } from './shared/alert.service';

@Component( {
    moduleId: module.id,
    template: `
<div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-3">A R G O</h1>
            <form name="form" (ngSubmit)="f.form.valid && login()" #f="ngForm"
                novalidate>
                <div class="form-group"
                    [ngClass]="{ 'has-error': f.submitted && !username.valid }">
                    <label for="username">Username</label> <input type="text"
                        class="form-control" name="username" [(ngModel)]="model.username"
                        #username="ngModel" required />
                    <div *ngIf="f.submitted && !username.valid" class="help-block">Username
                        is required</div>
                </div>
                <div class="form-group"
                    [ngClass]="{ 'has-error': f.submitted && !password.valid }">
                    <label for="password">Password</label> <input type="password"
                        class="form-control" name="password" [(ngModel)]="model.password"
                        #password="ngModel" required />
                    <div *ngIf="f.submitted && !password.valid" class="help-block">Password
                        is required</div>
                </div>
                <div class="form-group">
                    <button [disabled]="loading" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
</div>
    `
} )
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService ) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    login() {
        this.loading = true;
        this.authenticationService.login( this.model.username, this.model.password )
            .subscribe(
            data => {
                this.router.navigate( [this.returnUrl] );
            },
            error => {
                this.alertService.error( error );
                this.loading = false;
            } );
    }
}

