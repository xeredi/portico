import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { CrudService } from '../shared/crud.service';

@Injectable()
export class ParameterTypeService extends CrudService {
    constructor( private http: Http ) {
        super( '/metamodelo/tipo-parametro', 'prto', http );
    }
}
