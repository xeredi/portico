import { XHRBackend, Http, RequestOptions } from "@angular/http";
import { Router } from '@angular/router';

import { InterceptedHttp } from "./http.interceptor";
import { AlertService } from "./shared/alert.service";
import { SpinnerService } from "./shared/spinner.service";

export function httpFactory(
    xhrBackend: XHRBackend
    , requestOptions: RequestOptions
    , alertService: AlertService
    , spinnerService: SpinnerService
    , router: Router
): Http {
    return new InterceptedHttp( xhrBackend, requestOptions, alertService, spinnerService, router );
}