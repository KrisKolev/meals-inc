
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Table } from './../ITable';

@Injectable({
    providedIn: 'root'
})
export class TablesService {

    readonly REST_API_TABLES;

    constructor(private http: HttpClient) {
        this.REST_API_TABLES = 'http://localhost:8080/tables';
    }

    getTables() {
        return this.http.get(`${this.REST_API_TABLES}`);
    }

    getSight(id:string){
      return this.http.get(`${this.REST_API_TABLES}`+{id})
    }
}
