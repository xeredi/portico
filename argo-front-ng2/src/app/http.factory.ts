import { XHRBackend, Http, RequestOptions } from "@angular/http";
import { Router } from '@angular/router';

import { InterceptedHttp } from "./http.interceptor";
import { AlertService } from "./shared/alert.service";

export function httpFactory( xhrBackend: XHRBackend, requestOptions: RequestOptions, alertService: AlertService, router: Router ): Http {
    return new InterceptedHttp( xhrBackend, requestOptions, alertService, router );
}