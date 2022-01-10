
import {HttpClient, HttpParams} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Product } from "../IProduct";

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    readonly REST_API_PRODUCTS;

    constructor(private http: HttpClient) {
        this.REST_API_PRODUCTS = 'http://localhost:8080/products';
    }

    getProducts() {
        return this.http.get(`${this.REST_API_PRODUCTS}`);
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

