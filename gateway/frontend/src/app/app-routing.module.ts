import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginPageComponent} from './login-page/login-page.component';
import {RegPageComponent} from './registration/reg-page.component';
import {EmailConfirmPageComponent} from './email-confirm-page/email-confirm-page.component';
import {RegistrationSuccessPageComponent} from './registration-success-page/registration-success-page.component';
import {HomePageComponent} from './home-page/home-page.component';
import {AuthGuard} from './shared/service/auth/AuthGuard';
const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginPageComponent},
  {path: 'registration', component: RegPageComponent},
  {path: 'email-confirm-page', component: EmailConfirmPageComponent},
  {path: 'registration-success-page', component: RegistrationSuccessPageComponent},
  {path: 'home-page', component: HomePageComponent, canActivate: [AuthGuard]},
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
