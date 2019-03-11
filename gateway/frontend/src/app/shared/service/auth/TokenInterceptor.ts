import {Injectable, Injector} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpResponse, HttpErrorResponse
} from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import {AuthGuard} from "./AuthGuard";
import {Router} from "@angular/router";

@Injectable()

export class TokenInterceptor implements HttpInterceptor{

  constructor(private injector: Injector) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const auth = this.injector.get(AuthGuard);

    const authToken = auth.getToken();
      if (authToken == null) {
        request = request.clone({
          setHeaders: {},
          responseType: "json"
        });
        return next.handle(request).do((event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            // do stuff with response if you want
          }
        });
      } else {
        request = request.clone({
          setHeaders: {
            Authorization: `Bearer ${auth.getToken()}`
          },
          responseType: "json"
        });
        return next.handle(request).do((event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            // do stuff with response if you want
          }
        });
      }

  }
}
