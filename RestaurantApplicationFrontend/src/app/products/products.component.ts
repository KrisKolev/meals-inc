import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { ProductsService } from "./products.service";
import {MatTableDataSource} from "@angular/material/table";
import {Product} from "../IProduct";
import {MatPaginator} from "@angular/material/paginator";
import {Subscription} from "rxjs";
import {Employees} from "../IEmployees";
import {FormBuilder, FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'price', 'action'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  dataSource!: MatTableDataSource<Product>;

  private subs = new Subscription();
  private dataArray: any;

  title = "Products";

  productName = new FormControl('', [Validators.required]);
  productPrice = new FormControl('', [Validators.required]);

  constructor(public service: ProductsService) {  }

  ngOnInit(): void {
    this.subs.add(this.service.getProducts().subscribe(data => {
      this.dataArray = data;
      this.dataSource = new MatTableDataSource<Product>(this.dataArray);
      this.dataSource.paginator = this.paginator;
    }));
  }

  onCreateProduct() {
    let prodName:string = this.productName.value;
    let prodPrice:number = this.productPrice.value;

    if (prodName == "" || prodPrice == null)
    {
      alert("Fill in all the fields");
    }
    else
    {
      this.service.createProduct(prodName, prodPrice).subscribe(res => (console.log(res)));

      location.reload();
    }
  }

  deleteProduct(productID: number) {
    if (confirm("Are you sure you want to delete that product")) {
      this.service.deleteProduct(productID).subscribe((res) => {
        console.log(res);
      });

      location.reload();
    }
  }

  applyFilter(filterValue: string){
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

  onClickAlert() {
    alert("potato");
  }
}
