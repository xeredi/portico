import { Injectable } from "@angular/core";
import { ConnectionBackend, RequestOptions, Request, RequestOptionsArgs, Response, Http, Headers } from "@angular/http";
import { Router } from "@angular/router";
import { Observable } from "rxjs/Rx";

import { AlertService } from "./shared/alert.service";

@Injectable()
export class InterceptedHttp extends Http {
    alertService: AlertService;

    constructor( backend: ConnectionBackend, defaultOptions: RequestOptions,
        alertService: AlertService ) {
        super( backend, defaultOptions );

        this.alertService = alertService;
    }

    request( request: string | Request, options: RequestOptionsArgs = { headers: new Headers() } ): Observable<Response> {
        // console.log( "request: " + ( typeof request === 'string' ? request : request['url'] ) );
        // this.configureRequest( request, options );
        return this.interceptResponse( request, options );
    }

    private interceptResponse( request: string | Request, options: RequestOptionsArgs ): Observable<Response> {
        console.log( "interceptResponse: " + ( typeof request === 'string' ? request : request['url'] ) );

        const observableRequest = super
            .request( request, options )
            .do( res => this.handleResponse( res ) )
            .catch( res => this.handleError( res ) )
            .finally( this.onFinally() );

        return observableRequest;
    }

    private onDo() {
        return () => console.log( 'onDo' );
    }

    private handleResponse( res: Response ) {
        // this.alertService.success( "handleResponse: " + res.toString(), false );

        console.log( "handleResponse: " + res.toString() );

        var json = res.json();

        console.log( "jsonResponse: " + JSON.stringify( json ) );

        if ( Object.keys( json.errorMessages ).length > 0 ) {
            console.log( "has Errors!!!" );

            this.alertService.error( json.errorMessages, false );
        }

        return res;
    }

    private handleError( res: Response ) {
        this.alertService.error( ["handleError: " + res.toString()], false );

        console.log( "handleError: " + res.toString() );

        // Security errors
        if ( res.status === 401 || res.status === 403 ) {
            // redirigir al usuario para pedir credenciales
            //                this.router.navigate( ['user/login'] );
        }

        return Observable.throw( res );
    }

    private onFinally() {
        return () => console.log( 'onFinally' );
    }
}