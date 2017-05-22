import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

import { CrudService } from '../shared/crud.service';

@Injectable()
export class I18nMessageService extends CrudService {
    constructor( private http: Http ) {
        super( '/administracion/messagei18n/message-i18n', 'm18n', http );
    }
}
