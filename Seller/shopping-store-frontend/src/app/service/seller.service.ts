import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seller } from '../model/seller';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  private baseURL = "http://localhost:8080/api/v1/sellers";
  constructor(private httpClient: HttpClient) { }

  getSellersList(): Observable<Seller[]>{
    return this.httpClient.get<Seller[]>(`${this.baseURL}`);
  }

  getSellerById(id: number): Observable<Seller>{
    return this.httpClient.get<Seller>(`${this.baseURL}/${id}`);
  }

  updateSeller(id: number, seller: Seller): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, seller);
  }

  deleteSeller(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
