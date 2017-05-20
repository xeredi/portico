import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';

import { SecurityRoutingModule } from './security-routing.module';
import { HomeComponent } from './home.component';
import { GroupGridComponent } from './group-grid.component';
import { GroupComponent } from './group.component';
import { GroupEditComponent } from './group-edit.component';
import { UserGridComponent } from './user-grid.component';
import { UserComponent } from './user.component';
import { UserEditComponent } from './user-edit.component';

import { UserService } from './user.service';
import { GroupService } from './group.service';

@NgModule( {
    imports: [
        FormsModule,
        CommonModule,
        SecurityRoutingModule
    ],
    declarations: [
        HomeComponent
        , GroupGridComponent
        , GroupComponent
        , GroupEditComponent
        , UserGridComponent
        , UserComponent
        , UserEditComponent
    ],
    providers: [
        UserService
        , GroupService
    ]
} )
export class SecurityModule { }
