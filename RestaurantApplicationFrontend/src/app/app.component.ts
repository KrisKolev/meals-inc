import { Component } from '@angular/core';
import { ProductsService } from "./products/products.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Restaurant Application';

  constructor(service: ProductsService) {
    
  }
}

