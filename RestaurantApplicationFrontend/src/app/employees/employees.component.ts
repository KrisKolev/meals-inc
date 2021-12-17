
import {AfterViewInit, Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {EmployeesService} from "./employees.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Employees} from "../IEmployees";
import {MatSort} from "@angular/material/sort";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements AfterViewInit {

  hidePassword = true;
  pw = new FormControl('');

  displayedColumns: string[] = ['id', 'name', 'role', 'action'];
  dataSource: MatTableDataSource<Employees>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  title = "Employees";

  employees: any;

  constructor(service: EmployeesService) {
    this.employees = service.getEmployees().subscribe((res) => {
      this.employees = res;
      this.dataSource = this.employees;
    });
  }

  ngOnInit(): void {

  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  // TODO: Implement this search function

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.dataSource.filter = filterValue.trim().toLowerCase();
  //   if (this.dataSource.paginator) {
  //     this.paginator.firstPage();
  //   }
  // }
}
