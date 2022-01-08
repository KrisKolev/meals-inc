import {Component, Inject, OnInit} from '@angular/core';
import {OrdersPageService} from "./orders-page.service";
import {Subscription} from "rxjs";
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {OrdersDialogComponent} from "../orders-dialog/orders-dialog.component";
import {TablesService} from "../tables/tables.service";

@Component({
  selector: 'app-orders-page',
  templateUrl: './orders-page.component.html',
  styleUrls: ['./orders-page.component.css']
})
export class OrdersPageComponent implements OnInit {

  tables: any;
  tableById: any;
  title = "Orders";

  constructor(public service: TablesService,
              public readonly dialog:MatDialog) { }

  openThisDialog(i:number, tableName:string) {
    this.dialog.open(OrdersDialogComponent, {
      data: {
        tableName: tableName
      }
    });
  }

  getTableById(id: string) {
    this.tableById = this.service.getSight(id).subscribe((s) => {
      this.tableById = s
    });
  }

  ngOnInit(): void {
    this.tables = this.service.getTables().subscribe((res) => {
      this.tables = res;
    })
  }
}
