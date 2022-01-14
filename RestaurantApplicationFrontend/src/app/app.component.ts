import {Component, ViewEncapsulation, OnInit, OnDestroy} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnDestroy{
  title = 'Meals INC.';

  constructor() { }

  ngOnDestroy(): void {
    // localStorage.removeItem('currentEmployee');
    // location.reload()
  }
}

