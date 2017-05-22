import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';

import { ConfigurationService } from './configuration.service';

@Component( {
    selector: 'app-configuration',
    template: `
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group">
        <a class="btn btn-primary" [routerLink]="['/settings/configuration/edit', 'edit', conf.key]"><i
            class="fa fa-edit"></i> Edit</a>
    </div>
</div>

<form>
    <fieldset class="form-group">
        <div class="row">
            <div class="col-sm-3 col-md-2 col-lg-1 form-group-sm">
                <label>Tipo Valor</label>
                <p class="form-control-static">{{conf.valueType}}</p>
            </div>
            <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                <label>Clave</label>
                <p class="form-control-static">{{conf.key}}</p>
            </div>
            <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                <label>Valor Defecto</label>
                <p class="form-control-static">{{conf.defaultValue}}</p>
            </div>
            <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                <label>Valor</label>
                <p class="form-control-static">{{conf.value}}</p>
            </div>
        </div>
    </fieldset>
</form>
`
} )
export class ConfigurationComponent implements OnInit {

    conf: any = {};

    constructor( private route: ActivatedRoute,
        private router: Router, private confService: ConfigurationService ) {
    }

    ngOnInit() {
        this.route.params
            .switchMap(( params: Params ) => this.confService.detail( { key: params['key'] } ) )
            .subscribe( resp => {
                this.conf = resp.model;
            } );
    }
}
