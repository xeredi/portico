import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class CrudService {
    _http: Http
    _urlBase: string;
    _prefix: string;

    constructor( urlBase: string, prefix: string, http: Http ) {
        this._urlBase = urlBase;
        this._prefix = prefix;
        this._http = http;
    }

    edit( accion: string, id: any ) {
        return this._http.post( this._urlBase + '-edit.action', { accion: accion, model: id, prefix: this._prefix } ).map(( response: Response ) => response.json() );
    }

    save( accion: string, item: any ) {
        return this._http.post( this._urlBase + '-save.action', { accion: accion, model: item, prefix: this._prefix } ).map(( response: Response ) => response.json() );
    }

    list( searchCriteria: any ) {
        return this._http.post( this._urlBase + '-list.action', { model: searchCriteria, prefix: this._prefix } ).map(( response: Response ) => response.json() );
    }

    detail( id: any ) {
        return this._http.post( this._urlBase + '-detail.action', { model: id, prefix: this._prefix } ).map(( response: Response ) => response.json() );
    }
}
