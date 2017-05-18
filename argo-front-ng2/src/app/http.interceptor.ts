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
            .catch( this.onCatch() )
            .finally( this.onFinally() );

        return observableRequest;
    }

    /**
     * Interceptor para captura genérica de errores http
     * */
    private onCatch() {
        this.alertService.success( "onCatch: ", false );

        return ( res: Response ) => {
            this.alertService.error( "onCatch Error: " + res.toString(), false );

            console.log( "onCatch Error: " + res.toString() );

            // Security errors
            if ( res.status === 401 || res.status === 403 ) {
                // redirigir al usuario para pedir credenciales
                //                this.router.navigate( ['user/login'] );
            }
            // To Do: Gestión común de otros errores...
            return Observable.throw( res );
        };
    }

    private onFinally() {
        return () => console.log( 'onFinally' );
    }
}