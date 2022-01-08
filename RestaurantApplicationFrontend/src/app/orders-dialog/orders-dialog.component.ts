import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {TablesService} from "../tables/tables.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Product} from "../IProduct";
import {Subscription} from "rxjs";
import {ProductsService} from "../products/products.service";

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

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              public service: ProductsService) { }

  ngOnInit(): void {
    this.subs.add(this.service.getProducts().subscribe(data => {
      this.dataArray = data;
      this.dataSource = new MatTableDataSource<Product>(this.dataArray);
      this.dataSource.paginator = this.paginator;
    }));
  }

  applyFilter(filterValue: string){
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}
