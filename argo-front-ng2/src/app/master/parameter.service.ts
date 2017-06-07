import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { CrudService } from '../shared/crud.service';

@Injectable()
export class ParameterService extends CrudService {
    constructor( private http: Http ) {
        super( http );

        this.setParams( '/maestro/parametro', 'prmt' );
    }
}
