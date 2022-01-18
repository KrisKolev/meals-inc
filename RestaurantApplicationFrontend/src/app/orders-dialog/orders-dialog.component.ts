import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {TablesService} from "../tables/tables.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Product} from "../IProduct";
import {Subscription} from "rxjs";
import {ProductsService} from "../products/products.service";
import {OrdersDialogService} from "./orders-dialog.service";

@Component({
  selector: 'app-orders-dialog',
  templateUrl: './orders-dialog.component.html',
  styleUrls: ['./orders-dialog.component.css']
})
export class OrdersDialogComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'price', 'action'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  dataSource!: MatTableDataSource<Product>;

  private subs = new Subscription();
  private dataArray: any;
  mealsArray: any;
  totalPrice: number;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public service: ProductsService,
              public ordersService: OrdersDialogService) { }

  ngOnInit(): void {
    this.subs.add(this.service.getProducts().subscribe(data => {
      this.dataArray = data;
      this.dataSource = new MatTableDataSource<Product>(this.dataArray);
      this.dataSource.paginator = this.paginator;
    }));
    this.subs.add(this.ordersService.getAssigned(this.data.tableId).subscribe(ordersData => {
      this.mealsArray = ordersData;
    }))
  }

  assignProduct(tableId:number, productID: number) {
    this.ordersService.assignProduct(tableId, productID).subscribe((res) => {
      console.log(res);
    });

    location.reload();
  }

  deleteProduct(tableId:number) {
    this.ordersService.deleteAssigned(tableId).subscribe((res) => {
      console.log(res);
    });

    location.reload();
  }

  applyFilter(filterValue: string){
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }

  currentPrice: number;
  newPrice: number;
}
