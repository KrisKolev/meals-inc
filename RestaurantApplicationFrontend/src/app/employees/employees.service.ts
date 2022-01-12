
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Employees } from '../IEmployees';
import {AuthenticationService} from "../service/authentication.service";

@Injectable({
    providedIn: 'root'
})
export class EmployeesService {

    readonly REST_API_EMPLOYEES;

    constructor(private http: HttpClient, private authService: AuthenticationService) {
        this.REST_API_EMPLOYEES = 'http://localhost:8080/employees';
    }

    getEmployees() {
      const httpHeaders = new HttpHeaders({
        'Authorization':this.authService.auth
      });

        return this.http.get(`${this.REST_API_EMPLOYEES}`, {headers: httpHeaders});
    }

    createEmployee(employeeName: string,
                   employeeRole: string,
                   employeeUsername: string,
                   employeePassword: string) {
      const httpParams = new HttpParams({
        fromObject: {
          employeeName: employeeName,
          employeeRole: employeeRole,
          employeeUsername: employeeUsername,
          employeePassword: employeePassword
        }
      });

      const httpHeaders = new HttpHeaders({
        'Authorization':this.authService.auth
      });
      return this.http.post(`${this.REST_API_EMPLOYEES}`, null, {params: httpParams, headers:httpHeaders});
    }

    deleteEmployee(employeeId: number) {
      const httpParams = new HttpParams({
        fromObject: {
          employeeId: employeeId
        }
      });

      const httpHeaders = new HttpHeaders({
        'Authorization':this.authService.auth
      });
      return this.http.delete(`${this.REST_API_EMPLOYEES}`, {params: httpParams, headers:httpHeaders});
    }
}
