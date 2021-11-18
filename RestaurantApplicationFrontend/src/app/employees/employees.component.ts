import {Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {EmployeesService} from "./employees.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Employees} from "../IEmployees";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'role', 'action'];
  dataSource: MatTableDataSource<Employees>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  title = "Employees";

  employees: any;

  constructor(service: EmployeesService) {
    this.employees = service.getEmployees().subscribe((res) => {
      this.employees = res;
    });
    this.dataSource = new MatTableDataSource<Employees>();
  }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }
}
