import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { BillingRoutingModule } from './billing-routing.module';
import { HomeComponent } from './home.component';

import { AssessmentService } from './assessment.service';
import { AssessmentGridComponent } from './assessment-grid.component';
import { AssessmentDetailComponent } from './assessment-detail.component';
import { AssessmentEditComponent } from './assessment-edit.component';
import { AssessmentChargeGridFragmentComponent } from './assessment-charge-grid-fragment.component';
import { AssessmentTaxGridFragmentComponent } from './assessment-tax-grid-fragment.component';

import { AssessmentLineService } from './assessment-line.service';
import { AssessmentLineGridFragmentComponent } from './assessment-line-grid-fragment.component';
import { AssessmentLineDetailComponent } from './assessment-line-detail.component';
import { AssessmentLineEditComponent } from './assessment-line-edit.component';

import { AssessmentDetailService } from './assessment-detail.service';
import { AssessmentDetailGridFragmentComponent } from './assessment-detail-grid-fragment.component';
import { AssessmentDetailDetailComponent } from './assessment-detail-detail.component';
import { AssessmentDetailEditComponent } from './assessment-detail-edit.component';

import { ChargeService } from './charge.service';
import { ChargeGridComponent } from './charge-grid.component';
import { ChargeDetailComponent } from './charge-detail.component';
import { ChargeEditComponent } from './charge-edit.component';

import { RuleService } from './rule.service';
import { RuleGridFragmentComponent } from './rule-grid-fragment.component';
import { RuleDetailComponent } from './rule-detail.component';
import { RuleEditComponent } from './rule-edit.component';

import { IncompatibleRuleService } from './incompatible-rule.service';
import { IncompatibleRuleGridFragmentComponent } from './incompatible-rule-grid-fragment.component';
import { IncompatibleRuleDetailComponent } from './incompatible-rule-detail.component';
import { IncompatibleRuleEditComponent } from './incompatible-rule-edit.component';

@NgModule( {
    imports: [
        FormsModule
        , CommonModule
        , NgbModule
        , BillingRoutingModule
    ]
    , declarations: [
        HomeComponent
        , AssessmentGridComponent
        , AssessmentDetailComponent
        , AssessmentEditComponent
        , AssessmentChargeGridFragmentComponent
        , AssessmentTaxGridFragmentComponent
        , AssessmentLineGridFragmentComponent
        , AssessmentLineDetailComponent
        , AssessmentLineEditComponent
        , AssessmentDetailGridFragmentComponent
        , AssessmentDetailDetailComponent
        , AssessmentDetailEditComponent
        , ChargeGridComponent
        , ChargeDetailComponent
        , ChargeEditComponent
        , RuleGridFragmentComponent
        , RuleDetailComponent
        , RuleEditComponent
        , IncompatibleRuleGridFragmentComponent
        , IncompatibleRuleDetailComponent
        , IncompatibleRuleEditComponent
    ]
    , providers: [
        AssessmentService
        , AssessmentLineService
        , AssessmentDetailService
        , ChargeService
        , RuleService
        , IncompatibleRuleService
    ]
    , schemas: [CUSTOM_ELEMENTS_SCHEMA]
} )
export class BillingModule { }