import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  getProductList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'products-list');
  }

  createProduct(product: object): Observable<object> {
    return this.http.post(`${this.baseUrl}` + 'save-product', product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-product/${id}`, { responseType: 'text' });
  }

  getProduct(id: number | string ): Observable<object> {
    return this.http.get(`${this.baseUrl}/product/${id}`);
  }

  updateProduct(id: number, value: any): Observable<object> {
    return this.http.post(`${this.baseUrl}/update-product/${id}`, value);
  }

}
