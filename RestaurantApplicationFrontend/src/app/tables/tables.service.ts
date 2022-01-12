
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Table } from './../ITable';
import {AuthenticationService} from "../service/authentication.service";

@Injectable({
    providedIn: 'root'
})
export class TablesService {

    readonly REST_API_TABLES;

    constructor(private http: HttpClient, private authService: AuthenticationService) {
        this.REST_API_TABLES = 'http://localhost:8080/tables';
    }

    getTables() {
      const httpHeaders = new HttpHeaders({
        'Authorization':this.authService.auth
      });

      return this.http.get(`${this.REST_API_TABLES}`, {headers: httpHeaders});
    }

    getSight(id:string){
      return this.http.get(`${this.REST_API_TABLES}`+{id})
    }
}
