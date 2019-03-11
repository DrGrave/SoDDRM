import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class EmailConfirmPageService {
  private url = '/api/main/user/confirm?link=';

  constructor(private http: HttpClient) {
  }

  sendLink(link: string): Observable<any> {
    return this.http.post(this.url + link, null);
  }
}
