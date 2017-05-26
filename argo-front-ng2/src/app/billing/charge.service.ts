import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { CrudService } from '../shared/crud.service';

@Injectable()
export class ChargeService extends CrudService {
    constructor( private http: Http ) {
        super( '/facturacion/cargo', 'crgo', http );
    }
}
