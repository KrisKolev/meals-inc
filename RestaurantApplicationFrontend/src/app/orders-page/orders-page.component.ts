import { Component, OnInit } from '@angular/core';
import {OrdersPageService} from "./orders-page.service";
import {Subscription} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {OrdersDialogComponent} from "../orders-dialog/orders-dialog.component";

@Component({
  selector: 'app-orders-page',
  templateUrl: './orders-page.component.html',
  styleUrls: ['./orders-page.component.css']
})
export class OrdersPageComponent implements OnInit {

  tables: any;
  title = "Orders";

  constructor(public service: OrdersPageService, public dialog: MatDialog) { }

  openThisDialog() {
    this.dialog.open(OrdersDialogComponent);
  }

  ngOnInit(): void {
    this.tables = this.service.getTables().subscribe((res) => {
      this.tables = res;
    })
  }
}
