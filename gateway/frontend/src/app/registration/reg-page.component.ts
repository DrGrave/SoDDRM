import {Component, OnInit} from '@angular/core';
import {RegUserPageService} from './reg-user-page.service';
import {
  AbstractControl, FormControl, FormGroup, FormGroupDirective, NgForm, NgModel, ValidationErrors,
  Validators
} from '@angular/forms';
import {Router} from '@angular/router';
import {ErrorStateMatcher} from '@angular/material';


@Component({
  selector: 'app-reg-page',
  templateUrl: './reg-page.component.html',
  styleUrls: ['./reg-page.component.scss']
})

export class RegPageComponent implements OnInit {
  minDate = new Date(1900, 0, 1);
  maxDate = new Date();

  constructor(private registerService: RegUserPageService, private router: Router) {
  }
  ifRegisterOk: boolean;
  loginAndEmailErrorStateMatcher = new LogintAndEmailErrorStateMatcher();

  regFormGroup: FormGroup;
  passwordPattern = '^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,}$';


  ngOnInit(): void {
    this.regFormGroup = new FormGroup({
      username: new FormControl('', {
        validators: [Validators.required, Validators.pattern('^[a-zA-Z]+$')],
        asyncValidators: [this.uniqueLoginValidator.bind(this)]
        }),
      password: new FormControl('',
        [Validators.required, Validators.pattern(this.passwordPattern)]),
      confirmPassword: new FormControl('',
        [Validators.required, Validators.pattern(this.passwordPattern)]),
      email: new FormControl('', {
        validators: [Validators.required, Validators.email],
        asyncValidators: [this.uniqueEmailValidator.bind(this)]
      }),
      firstName: new FormControl('',
        [Validators.required]),
      middleName: new FormControl(''),
      lastName: new FormControl('',
        [Validators.required]),
      birthday: new FormControl('', [Validators.required])
    });


  }

  private regMyUser() {
    this.registerService.addRegUser(this.regFormGroup.value).subscribe(user => {
      this.ifRegisterOk = user;
      this.sucsReg();
    });
  }

  sucsReg() {
    if (this.ifRegisterOk) {
      this.router.navigateByUrl('/registration-success-page');
    } else {
    }
  }


  uniqueLoginValidator(control: AbstractControl) {
    return this.registerService.checkLogin(control.value).map(data => {
      return data ? null : {loginUnique: {value: false}};
    });
  }


  uniqueEmailValidator(control: AbstractControl) {
    return this.registerService.checkEmail(control.value).map(data => {
      return data ? null : {emailUnique: {value: false}};
    });

  }
}


class LogintAndEmailErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted) );
  }
}

