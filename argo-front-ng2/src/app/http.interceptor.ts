import { Injectable } from "@angular/core";
import { ConnectionBackend, RequestOptions, Request, RequestOptionsArgs, Response, Http, Headers } from "@angular/http";
import { Router } from "@angular/router";
import { Observable } from "rxjs/Rx";

import { AlertService } from "./shared/alert.service";

@Injectable()
export class InterceptedHttp extends Http {
    alertService: AlertService;
    router: Router;

    constructor( backend: ConnectionBackend, defaultOptions: RequestOptions,
        alertService: AlertService, router: Router ) {
        super( backend, defaultOptions );

        this.alertService = alertService;
        this.router = router;
    }

    request( request: string | Request, options: RequestOptionsArgs = { headers: new Headers() } ): Observable<Response> {
        var url = ( typeof request === 'string' ? request : request['url'] );

        console.log( "request: " + url );

        // FIXME Mirar si hay forma más elegante de hacer que funcione angular translate
        return url.startsWith( "/assets/i18n" ) ? super.request( request, options ) : this.interceptResponse( request, options );
    }

    private interceptResponse( request: string | Request, options: RequestOptionsArgs ): Observable<Response> {
        // console.log( "interceptResponse: " + ( typeof request === 'string' ? request : request['url'] ) );

        const observableRequest = super
            .request( request, options )
            .do( res => this.handleResponse( res ) )
            .catch( res => this.handleError( res ) )
            .finally( this.onFinally() );

        return observableRequest;
    }

    private handleResponse( res: Response ) {
        console.log( "handleResponse: " );
        // console.log( "handleResponse: " + res.toString() );
        var json = res.json();

        // console.log( "jsonResponse: " + JSON.stringify( json ) );

        // console.log( "Checking errors" );
        if ( json.actionErrors && Object.keys( json.actionErrors ).length > 0 ) {
            console.log( "has Errors!!!" );
            throw res;
        }

        // console.log( "Checking login" );
        if ( json.responseCode && json.responseCode == "login" ) {
            console.log( "Needs login!!!" );
            this.router.navigate( ['/login'] );

            return Observable.empty();
        }

        // console.log( "All OK" );

        return res;
    }

    private handleError( res: Response ) {
        console.log( "handleError: " + res.toString() );
        console.log( "res.status: " + res.status );
        console.log( "Checking login" );
        if ( res.status === 401 || res.status === 403 ) {
            // console.log( "send to login. cause: " + res.toString() );
            this.router.navigate( ['/login'] );
        }

        console.log( "Checking errors" );
        try {
            var json = res.json();

            console.log( "jsonErrors: " + JSON.stringify( json ) );
            if ( json.actionErrors && Object.keys( json.actionErrors ).length > 0 ) {
                console.log( "alertErrors: " + JSON.stringify( json.actionErrors ) );
                this.alertService.error( json.actionErrors, false );
            }
        } catch ( e ) {
            console.log( "not json!!!" );
            this.alertService.error( [res.toString()], false );
        }

        return Observable.throw( res );
    }

    private onFinally() {
        return () => { };
    }
}