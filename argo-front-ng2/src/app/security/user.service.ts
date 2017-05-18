import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';

@Injectable()
export class UserService {

    constructor( private http: Http ) { }

    edit( accion: string, id: any ) {
        return this.http.post( '/seguridad/usuario-edit.action', { accion: accion, model: id, prefix: "usro" } ).map(( response: Response ) => response.json() );
    }

    save( accion: string, item: any ) {
        return this.http.post( '/seguridad/usuario-edit.action', { accion: accion, model: item, prefix: "usro" } ).map(( response: Response ) => response.json() );
    }
}
