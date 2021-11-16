
import { HttpClient } from "@angular/common/http";
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
}
