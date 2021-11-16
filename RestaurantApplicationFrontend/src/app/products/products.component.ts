import {AfterViewInit, Component, OnInit} from '@angular/core';
import { ProductsService } from "./products.service";
import {MatTableDataSource} from "@angular/material/table";
import {Product} from "../IProduct";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'price', 'action'];
  dataSource: MatTableDataSource<Product>;

  title = "Products";

  products: any;

  constructor(service: ProductsService) {
    this.products = service.getProducts().subscribe((res) => {
      this.products = res;
    });
    this.dataSource = new MatTableDataSource<Product>();
  }

  ngOnInit(): void {
  }

  ngAfterViewInit() {

  }
}
