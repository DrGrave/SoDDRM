import {Component, OnInit} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-lang-select',
  templateUrl: './lang-select.component.html',
  styleUrls: ['./lang-select.component.scss']
})
export class LangSelectComponent implements OnInit {

  private languageMap = [
    {value: 'ru', name: 'Русский'},
    {value: 'en', name: 'English'}];

  constructor(private translate: TranslateService) {
  }

  ngOnInit() {

  }

  private changeLanguage(event: any): void {
    this.translate.use(event.value);
    localStorage.setItem('isogj-locale', event.value);

    location.reload();
  }

}
