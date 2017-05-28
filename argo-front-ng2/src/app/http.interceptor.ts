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
        console.log( "handleResponse: " + res.toString() );

        var json = res.json();

        console.log( "jsonResponse: " + JSON.stringify( json ) );

        if ( json.responseCode == "login" ) {
            console.log( "Needs login!!!" );
            this.router.navigate( ['/login'] );

            return Observable.empty();
        }

        if ( Object.keys( json.errorMessages ).length > 0 ) {
            console.log( "has Errors!!!" );
            this.alertService.error( json.errorMessages, false );

            return Observable.empty();
        }

        return res;
    }

    private handleError( res: Response ) {
        this.alertService.error( ["handleError: " + res.toString()], false );

        console.log( "handleError: " + res.toString() );

        if ( res.status === 401 || res.status === 403 ) {
            console.log( "send to login. cause: " + res.toString() );
            this.router.navigate( ['/login'] );
        }

        return Observable.throw( res );
    }

    private onFinally() {
        return () => console.log( 'onFinally' );
    }
}