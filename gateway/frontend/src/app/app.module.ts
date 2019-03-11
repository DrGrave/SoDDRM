  import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {RegPageComponent} from './registration/reg-page.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {
  MatAutocompleteModule,
  MatButtonModule, MatChipsModule, MatDatepickerModule, MatIconModule, MatInputModule, MatNativeDateModule,
  MatPaginatorModule,
  MatSelectModule, MatTabsModule,
  MatToolbarModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SharedModule} from './shared/shared.module';
import {AuthenticationService} from './shared/service/auth/authentication.service';
import {RegUserPageService} from './registration/reg-user-page.service';
import {EmailConfirmPageComponent} from './email-confirm-page/email-confirm-page.component';
import {EmailConfirmPageService} from './email-confirm-page/email-confirm-page.service';
import {EqualValidator} from './registration/equal-validator.directive';
import {RegistrationSuccessPageComponent} from './registration-success-page/registration-success-page.component';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import { LangSelectComponent } from './lang-select/lang-select.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HeaderComponent } from './header/header.component';
import {AuthGuard} from "./shared/service/auth/AuthGuard";
import {MatCardModule} from '@angular/material/card';
import {MatDialogModule} from '@angular/material';
import {HomePageService} from "./home-page/home-page.service";
  import {TokenInterceptor} from "./shared/service/auth/TokenInterceptor";
  import {HttpErrorInterceptor} from "./shared/service/auth/HttpErrorInterceptor";

  export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    LoginPageComponent,
    RegPageComponent,
    EmailConfirmPageComponent,
    EqualValidator,
    RegistrationSuccessPageComponent,
    LangSelectComponent,
    HomePageComponent,
    HeaderComponent,
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatCardModule,
    FormsModule,
    MatInputModule,
    MatDialogModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatIconModule,
    SharedModule,
    MatDatepickerModule,
    MatToolbarModule,
    MatChipsModule,
    MatAutocompleteModule,
    MatNativeDateModule,
    MatIconModule,
    MatTabsModule,
    MatPaginatorModule,
    MatSelectModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  providers: [
    RegUserPageService,
    HomePageService,
    AuthenticationService,
    EmailConfirmPageService,
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
