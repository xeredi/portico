import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PermissionGuard } from '../shared/permission.guard';

import { HomeComponent } from './home.component';
import { AssessmentGridComponent } from './assessment-grid.component';
import { AssessmentDetailComponent } from './assessment-detail.component';
import { AssessmentEditComponent } from './assessment-edit.component';
import { AssessmentLineDetailComponent } from './assessment-line-detail.component';
import { AssessmentLineEditComponent } from './assessment-line-edit.component';
import { AssessmentDetailDetailComponent } from './assessment-detail-detail.component';
import { AssessmentDetailEditComponent } from './assessment-detail-edit.component';
import { ChargeGridComponent } from './charge-grid.component';
import { ChargeDetailComponent } from './charge-detail.component';
import { ChargeEditComponent } from './charge-edit.component';
import { BillSeriesGridComponent } from './bill-series-grid.component';
import { BillSeriesDetailComponent } from './bill-series-detail.component';
import { BillSeriesEditComponent } from './bill-series-edit.component';
import { RuleDetailComponent } from './rule-detail.component';
import { RuleEditComponent } from './rule-edit.component';
import { IncompatibleRuleDetailComponent } from './incompatible-rule-detail.component';
import { IncompatibleRuleEditComponent } from './incompatible-rule-edit.component';
import { AspectGridComponent } from './aspect-grid.component';
import { AspectDetailComponent } from './aspect-detail.component';
import { AspectEditComponent } from './aspect-edit.component';
import { AspectChargeDetailComponent } from './aspect-charge-detail.component';
import { AspectChargeEditComponent } from './aspect-charge-edit.component';

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment/grid', component: AssessmentGridComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment/detail/:id', component: AssessmentDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment/edit/:action', component: AssessmentEditComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment/edit/:action/:id', component: AssessmentEditComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment-line/detail/:id', component: AssessmentLineDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment-line/edit/:action/:assessmentId', component: AssessmentLineEditComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment-line/edit/:action/:assessmentId/:id', component: AssessmentLineEditComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment-detail/detail/:id', component: AssessmentDetailDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment-detail/edit/:action/:assessmentLineId', component: AssessmentDetailEditComponent, canActivate: [PermissionGuard] }
    , { path: 'assessment-detail/edit/:action/:assessmentLineId/:id', component: AssessmentDetailEditComponent, canActivate: [PermissionGuard] }
    , { path: 'charge/grid', component: ChargeGridComponent, canActivate: [PermissionGuard] }
    , { path: 'charge/detail/:id/:date', component: ChargeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'charge/edit/:action', component: ChargeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'charge/edit/:action/:id/:date', component: ChargeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'rule/detail/:id/:date', component: RuleDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'rule/edit/:action/:chargeId/:date', component: RuleEditComponent, canActivate: [PermissionGuard] }
    , { path: 'rule/edit/:action/:chargeId/:date/:id', component: RuleEditComponent, canActivate: [PermissionGuard] }
    , { path: 'incompatible-rule/detail/:id/:date', component: IncompatibleRuleDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'incompatible-rule/edit/:action/:ruleId/:date', component: IncompatibleRuleEditComponent, canActivate: [PermissionGuard] }
    , { path: 'incompatible-rule/edit/:action/:ruleId/:date/:id', component: IncompatibleRuleEditComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect/grid', component: AspectGridComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect/detail/:id/:date', component: AspectDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect/edit/:action', component: AspectEditComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect/edit/:action/:id/:date', component: AspectEditComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect-charge/detail/:id/:date', component: AspectChargeDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect-charge/edit/:action/:aspectId/:date', component: AspectChargeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'aspect-charge/edit/:action/:aspectId/:date/:id', component: AspectChargeEditComponent, canActivate: [PermissionGuard] }
    , { path: 'bill-series/grid', component: BillSeriesGridComponent, canActivate: [PermissionGuard] }
    , { path: 'bill-series/detail/:id', component: BillSeriesDetailComponent, canActivate: [PermissionGuard] }
    , { path: 'bill-series/edit/:action', component: BillSeriesEditComponent, canActivate: [PermissionGuard] }
    , { path: 'bill-series/edit/:action/:id', component: BillSeriesEditComponent, canActivate: [PermissionGuard] }
];

@NgModule( {
    imports: [RouterModule.forChild( routes )],
    exports: [RouterModule]
} )
export class BillingRoutingModule { }
