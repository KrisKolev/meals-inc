import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrdersPageService {

  readonly REST_API_TABLES;

  constructor(private http: HttpClient) {
    this.REST_API_TABLES = 'http://localhost:8080/tables';
  }

  getTables() {
    return this.http.get(`${this.REST_API_TABLES}`);
  }
}
