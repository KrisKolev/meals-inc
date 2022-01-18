import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {AuthenticationService} from "../service/authentication.service";

@Injectable({
  providedIn: 'root'
})
export class OrdersDialogService {

  readonly REST_API_TABLES;

  constructor(private http:HttpClient, private authService: AuthenticationService) {
    this.REST_API_TABLES = 'http://localhost:8080/tables';
  }

  getAssigned(tableId: number) {
    const httpParams = new HttpParams({
      fromObject: {
        tableId: tableId
      }
    });

    const httpHeaders = new HttpHeaders({
      'Authorization':this.authService.auth
    });
    return this.http.get(`${this.REST_API_TABLES}/getAssigned`, {params: httpParams ,headers: httpHeaders});
  }

  assignProduct(tableId: number,
                productID: number) {
    const httpParams = new HttpParams({
      fromObject: {
        tableId: tableId,
        productID: productID
      }
    });

    const httpHeaders = new HttpHeaders({
      'Authorization':this.authService.auth
    });
    return this.http.post(`${this.REST_API_TABLES}/assignProduct`, null, {params: httpParams, headers:httpHeaders});
  }

  deleteAssigned(tableId: number) {
    const httpParams = new HttpParams({
      fromObject: {
        tableId: tableId
      }
    });

    const httpHeaders = new HttpHeaders({
      'Authorization':this.authService.auth
    });
    return this.http.delete(`${this.REST_API_TABLES}/deleteAssigned`, {params: httpParams, headers: httpHeaders});
  }
}
