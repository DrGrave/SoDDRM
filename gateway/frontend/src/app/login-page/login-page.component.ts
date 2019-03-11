import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../shared/service/auth/authentication.service';

import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";



@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {


  private isAfto: boolean = true;
  private formSubmitAttempt: boolean;

  private token: string;


  constructor( private fb: FormBuilder, private authenticationService: AuthenticationService, private router: Router) {
  }

  form: FormGroup;

  ngOnInit() {
    this.form = this.fb.group({     // {5}
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }




  private authenticate(event) {
    if (this.form.valid) {
      this.authenticationService.login(this.form.value)
        .subscribe(data => {
          this.token = data.access_token;
          this.router.navigateByUrl("/home-page");

        });
      this.isAfto = false;
    }
    this.formSubmitAttempt = true;
  }

  isFieldInvalid(field: string) { // {6}
    return (
      (!this.form.get(field).valid && this.form.get(field).touched) ||
      (this.form.get(field).untouched && this.formSubmitAttempt)
    );
  }



}
