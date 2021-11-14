import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { EmployeesService } from "./employees.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";

// export interface EmployeeData {
//   id: string;
//   name: string;
//   role: string;
// }

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'role', 'action'];
  //dataSource: MatTableDataSource<EmployeeData>;

  //@ViewChild(MatPaginator) paginator: MatPaginator;
  //@ViewChild(MatSort) sort: MatSort;

  title = "Employees";

  employees: any;

  constructor(service: EmployeesService) {
    this.employees = service.getEmployees().subscribe((res) => {
      this.employees = res;
    });
    //this.dataSource = new MatTableDataSource<EmployeeData>();
  }

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.dataSource.filter = filterValue.trim().toLowerCase();
  //
  //   if (this.dataSource.paginator) {
  //     this.dataSource.paginator.firstPage();
  //   }
  // }

  ngOnInit(): void {
  }

  // ngAfterViewInit() {
  //   this.dataSource.paginator = this.paginator;
  //   this.dataSource.sort = this.sort;
  // }
}
