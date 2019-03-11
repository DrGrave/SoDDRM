import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';
import {EmailConfirmPageService} from './email-confirm-page.service';


@Component({
  selector: 'app-email-confirm-page',
  templateUrl: './email-confirm-page.component.html',
  styleUrls: ['./email-confirm-page.component.scss']
})
export class EmailConfirmPageComponent implements OnInit {

  private id: number;
  private error: string;

  private routeSubscription: Subscription;
  private querySubscription: Subscription;
  private myLink: string;

  constructor(private activateRoute: ActivatedRoute, private emailConfService: EmailConfirmPageService, private router: Router) {
    this.routeSubscription = activateRoute.params.subscribe(params => this.id = params['id']);
    this.querySubscription = activateRoute.queryParams.subscribe(
      (queryParam: any) => {
        this.myLink = queryParam['link'];
      }
    );
  }

  ngOnInit() {
    this.emailConfService.sendLink(this.myLink)
      .subscribe(data => {
        if (data.code === 'ok') {
          this.router.navigateByUrl('/login');
        } else {
          this.error = 'Error in token';
        }
      });
  }
}
