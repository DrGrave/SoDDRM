import {Observable} from 'rxjs/Observable';
import {AuthenticationService} from '../shared/service/auth/authentication.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  isLoggedIn$: Observable<boolean>; // {1}
  username: string =  localStorage.getItem('username');


  constructor(private authService: AuthenticationService) {
  }

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn; // {2}
  }

  onLogout() {
    this.authService.logout();                      // {3}
  }
}
