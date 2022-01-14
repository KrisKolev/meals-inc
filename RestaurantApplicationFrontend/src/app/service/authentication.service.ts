import { Injectable, OnDestroy } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService{

  currentEmployee: any;

  constructor(private http: HttpClient) {
    if (localStorage.getItem('currentEmployee'))
    {
      let employeeString: any = localStorage.getItem('currentEmployee');
      this.currentEmployee = JSON.parse(employeeString.toString());
    }
  }

  login(employeeUsername: string, employeePassword: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'ContentType': 'application/json'
      })
    };

    this.http.post(`http://localhost:8080/login`,
      {employeeUsername, employeePassword},
      {headers: httpOptions.headers}).subscribe(res => {
      console.log(res)
      localStorage.setItem('currentEmployee', JSON.stringify(res));
      location.reload();
    });
  }

  logout() {
    localStorage.removeItem('currentEmployee');
    location.reload()
  }

  get isManager() {
    if (this.currentEmployee)
    {
      if (this.currentEmployee.EmployeeType == "[Manager]")
      {
        return true;
      }
    }
    return false;
  }

  get isEmployee() {
    if (this.currentEmployee)
    {
      if (this.currentEmployee.EmployeeType == "[Waiter]" ||
        this.currentEmployee.EmployeeType == "[Bartender]" ||
        this.currentEmployee.EmployeeType == "[Waitress]")
      {
        return true;
      }
    }
    return false;
  }

  get auth() {
    if (this.currentEmployee)
    {
      return this.currentEmployee.Authorization;
    }
    return null;
  }
}
