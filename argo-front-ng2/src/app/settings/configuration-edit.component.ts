import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ConfigurationService } from './configuration.service';

@Component( {
    selector: 'app-configuration-edit',
    template: `
<div class="container-fluid">
    <form role="form" (ngSubmit)="save()">
        <fieldset class="form-group">
            <legend>Configuration Parameter</legend>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3 col-md-2 col-lg-1 form-group-sm">
                        <label>Tipo Valor</label>
                        <p class="form-control-static">{{model.valueType}}</p>
                    </div>
                    <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                        <label>Clave</label>
                        <p class="form-control-static">{{model.key}}</p>
                    </div>
                    <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                        <label>Valor Defecto</label>
                        <p class="form-control-static">{{model.defaultValue}}</p>
                    </div>
                    <div class="col-sm-9 col-md-8 col-lg-7 form-group-sm">
                        <label>Valor</label>
                        <input type="text" [(ngModel)]="model.value" name="value"
                            class="form-control form-control-sm" />
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-check"></i> <span>Save</span>
            </button>
            <button type="button" (click)="cancel()" class="btn btn-default">
                <i class="fa fa-close"></i> <span>Cancel</span>
            </button>
        </div>
    </form>
</div>
    `
} )
export class ConfigurationEditComponent implements OnInit {

    model: any = {};
    action: string;
    key: string;

    constructor( private location: Location, private route: ActivatedRoute,
        private router: Router, private modelService: ConfigurationService ) {
    }

    ngOnInit() {
        this.route.params.subscribe( params => {
            this.action = params['action'];
            this.key = params['key'];

            this.modelService.edit( this.action, { key: this.key } )
                .subscribe( resp => { this.model = resp.model } );
        } );
    }

    save() {
        this.modelService.save( this.action, this.model )
            .subscribe( resp => {
                this.location.back();
            } );
    }

    cancel() {
        this.location.back();
    }
}
