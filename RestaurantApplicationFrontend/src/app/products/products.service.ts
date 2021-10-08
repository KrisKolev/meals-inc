
import { HttpClient } from "@angular/common/http";
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
        console.log("hello");
        return this.http.get(`${this.REST_API_PRODUCTS}`);
    }
}

