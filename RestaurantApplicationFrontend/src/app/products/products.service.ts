
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Product } from "../IProduct";
import {AuthenticationService} from "../service/authentication.service";

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    readonly REST_API_PRODUCTS;

    constructor(private http: HttpClient, private authService: AuthenticationService) {
        this.REST_API_PRODUCTS = 'http://localhost:8080/products';
    }

    getProducts() {
      const httpHeaders = new HttpHeaders({
        'Authorization':this.authService.auth
      });

      return this.http.get(`${this.REST_API_PRODUCTS}`, {headers: httpHeaders});
    }

    createProduct(productName: string, productPrice: number) {
        const httpParams = new HttpParams({
          fromObject: {
            productName: productName,
            productPrice: productPrice
          }
        });
        return this.http.post(`${this.REST_API_PRODUCTS}`, null, {params: httpParams});
    }

    deleteProduct(productID: number) {
      const httpParams = new HttpParams({
        fromObject: {
          productID: productID
        }
      });
      return this.http.delete(`${this.REST_API_PRODUCTS}`, {params: httpParams});
    }

    // assignProduct()
}

