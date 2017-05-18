import { XHRBackend, Http, RequestOptions } from "@angular/http";
import { InterceptedHttp } from "./http.interceptor";

import { AlertService } from "./shared/alert.service";

export function httpFactory( xhrBackend: XHRBackend, requestOptions: RequestOptions, alertService: AlertService ): Http {
    return new InterceptedHttp( xhrBackend, requestOptions, alertService );
}