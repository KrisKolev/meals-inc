
import {AfterViewInit, Component, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {EmployeesService} from "./employees.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Employees} from "../IEmployees";
import {MatSort} from "@angular/material/sort";
import {FormControl, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import localizeExtractLoader from "@angular-devkit/build-angular/src/extract-i18n/ivy-extract-loader";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  displayedColumns: string[] = ['id', 'name', 'role', 'action'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  dataSource!: MatTableDataSource<Employees>;

  private subs = new Subscription();
  private dataArray: any;

  title = "Employees";

  employeeName = new FormControl('', [Validators.required]);
  employeeRole = new FormControl('', [Validators.required]);
  employeeUsername = new FormControl('', [Validators.required]);
  employeePassword = new FormControl('', [Validators.required]);

  hidePassword = true;

  constructor(public service: EmployeesService) { }

  ngOnInit(): void {
    this.subs.add(this.service.getEmployees().subscribe(data => {
      this.dataArray = data;
      this.dataSource = new MatTableDataSource<Employees>(this.dataArray);
      this.dataSource.paginator = this.paginator;
    }));
  }

  onCreateEmployee() {
    let emplName:string = this.employeeName.value;
    let emplRole:string = this.employeeRole.value;
    let emplUsername:string = this.employeeUsername.value;
    let emplPassword:string = this.employeePassword.value;

    if (emplName == "" || emplRole == "" || emplUsername == "" || emplPassword == "")
    {
      alert("Fill in all the fields");
    }
    else
    {
      this.service.createEmployee(emplName, emplRole, emplUsername, emplPassword).subscribe(res => (console.log(res)));

      location.reload();
    }
  }

  deleteEmployee(employeeId: number) {
    if (confirm("Are you sure you want to delete that employee?"))
    {
      this.service.deleteEmployee(employeeId).subscribe((res) => {
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

}
