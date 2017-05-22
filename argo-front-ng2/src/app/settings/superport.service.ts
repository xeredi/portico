import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { CrudService } from '../shared/crud.service';

@Injectable()
export class SuperportService extends CrudService {
    constructor( private http: Http ) {
        super( '/administracion/puerto/superpuerto', 'sprt', http );
    }
}
