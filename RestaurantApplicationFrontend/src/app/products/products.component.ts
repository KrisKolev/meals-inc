import { Component, OnInit } from '@angular/core';
import { ProductsService } from "./products.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  title = "Products";

  products: any;

  constructor(service: ProductsService) {
    this.products = service.getProducts().subscribe((res) => {
      this.products = res;
    });
  }

  ngOnInit(): void {
  }

}
