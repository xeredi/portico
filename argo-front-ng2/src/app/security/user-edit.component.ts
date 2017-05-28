import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { UserService } from './user.service';

@Component( {
    selector: 'app-user-edit',
    templateUrl: './user-edit.component.html'
} )
export class UserEditComponent implements OnInit {

    model: any = {};
    grpoList: any[] = [];
    prtoList: any[] = [];
    sprtList: any[] = [];
    orgaEntiId: number;
    fref: Date;

    constructor(
        private route: ActivatedRoute
        , private router: Router
        , private location: Location
        , private userService: UserService
    ) { }

    ngOnInit() {
        console.log( "User edit" );

        this.userService.edit( "create", { id: null } ).subscribe( resp => {
            this.model = resp.model;
            this.grpoList = resp.grpoList;
            this.sprtList = resp.sprtList;
            this.prtoList = resp.prtoList;
            this.orgaEntiId = resp.orgaEntiId;
            this.fref = resp.fref;

            console.log( "Model" );
            console.log( this.model );
        } );
    }

    updateGroups( event: KeyboardEvent, grpoId: number ) {
        console.log( "UpdateGroups:" + grpoId );
    }

    save() {
        console.log( "User save" );

        this.userService.save( "create", this.model ).subscribe( resp => {
            console.log( "User saved" );

            if ( !resp.actionErrors ) {
                console.log( "Go to user detail" );

                this.router.navigate( ['/security/user-detail', resp.model.id] );
            }
        } );
    }

    cancel() {
        this.location.back();
    }
}