import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SecurityRoutingModule } from './security-routing.module';
import { HomeComponent } from './home.component';
import { GroupGridComponent } from './group-grid.component';
import { GroupComponent } from './group.component';
import { GroupEditComponent } from './group-edit.component';
import { UserGridComponent } from './user-grid.component';
import { UserComponent } from './user.component';
import { UserEditComponent } from './user-edit.component';

@NgModule( {
    imports: [
        CommonModule,
        SecurityRoutingModule
    ],
    declarations: [HomeComponent, GroupGridComponent, GroupComponent, GroupEditComponent, UserGridComponent, UserComponent, UserEditComponent]
} )
export class SecurityModule { }
