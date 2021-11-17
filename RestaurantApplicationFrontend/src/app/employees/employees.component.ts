import {AfterContentInit, AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { EmployeesService } from "./employees.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";
import {Employees} from "../IEmployees";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements AfterViewInit {

  displayedColumns: string[] = ['position', 'name', 'role', 'action'];
  dataSource: MatTableDataSource<Employees>;

  // @ViewChild(MatPaginator) paginator: MatPaginator;

  title = "Employees";

  employees: any;

  constructor(service: EmployeesService) {
    this.employees = service.getEmployees().subscribe((res) => {
      this.employees = res;
    });
    this.dataSource = new MatTableDataSource<Employees>();
  }

  ngOnInit(): void {
    // this.dataSource.paginator = this.paginator;
  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }
}
