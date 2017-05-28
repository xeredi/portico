import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { CrudService } from '../shared/crud.service';

@Injectable()
export class ConfigurationService extends CrudService {
    constructor( private http: Http ) {
        super( http );

        this.setParams( '/administracion/configuration/configuration', 'conf' );
    }
}
