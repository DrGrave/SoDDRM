import {Component, OnInit, ViewChild} from '@angular/core';
import {HomePageService} from './home-page.service';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MatDatepickerInputEvent, MatPaginator} from "@angular/material";


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


}


