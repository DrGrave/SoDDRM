import {Injectable} from '@angular/core';
import {
  CanActivate,
  Router
} from '@angular/router';
import {AuthenticationService} from './authentication.service';

import 'rxjs/add/operator/take';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthenticationService,
              private router: Router) {
  }

  canActivate() {
    if (localStorage.getItem('access_token')) {
      // logged in so return true
      return true;
    }

    // not logged in so redirect to login page
    this.router.navigate(['/login']);
    return false;
  }

  public getToken(): string {
    return localStorage.getItem('access_token');
  }
}
