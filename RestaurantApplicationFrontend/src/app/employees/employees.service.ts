
import {HttpClient, HttpParams} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Employees } from '../IEmployees';

@Injectable({
    providedIn: 'root'
})
export class EmployeesService {

    readonly REST_API_EMPLOYEES;

    constructor(private http: HttpClient) {
        this.REST_API_EMPLOYEES = 'http://localhost:8080/employees';
    }

    getEmployees() {
        return this.http.get(`${this.REST_API_EMPLOYEES}`);
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
      return this.http.post(`${this.REST_API_EMPLOYEES}`, null, {params: httpParams});
    }

    deleteEmployee(employeeId: number) {
      const httpParams = new HttpParams({
        fromObject: {
          employeeId: employeeId
        }
      });
      return this.http.delete(`${this.REST_API_EMPLOYEES}`, {params: httpParams});
    }
}
