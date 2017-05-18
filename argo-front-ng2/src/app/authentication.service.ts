import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

    constructor( private http: Http ) { }

    login( username: string, password: string ) {
        return this.http.post( '/seguridad/usuario-acceso.action', { model: { login: username, contrasenia: password } } )
            .map(( response: Response ) => {
                let serverResponse = response.json();
                if ( serverResponse && serverResponse.model ) {
                    localStorage.setItem( 'currentUser', JSON.stringify( serverResponse.model ) );
                }
            } );
    }

    logout() {
        localStorage.removeItem( 'currentUser' );
    }
}

// http://localhost:8081/seguridad/usuario-acceso.action