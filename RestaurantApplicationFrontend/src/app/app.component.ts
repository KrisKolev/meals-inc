import {Component, ViewEncapsulation} from '@angular/core';
import {ProductsService} from "./products/products.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
  title = 'Restaurant Application';

  constructor(service: ProductsService) {

  }
}

