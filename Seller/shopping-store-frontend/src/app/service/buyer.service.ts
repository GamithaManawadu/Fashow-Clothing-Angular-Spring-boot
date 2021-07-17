import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Buyer } from '../model/buyer';

@Injectable({
  providedIn: 'root'
})
export class BuyerService {

  private baseURL = "http://localhost:8080/api/v1/buyers";
  constructor(private httpClient: HttpClient) { }

  getBuyersList(): Observable<Buyer[]>{
    return this.httpClient.get<Buyer[]>(`${this.baseURL}`);
  }

  getBuyerById(id: number): Observable<Buyer>{
    return this.httpClient.get<Buyer>(`${this.baseURL}/${id}`);
  }

  updateBuyer(id: number, buyer: Buyer): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, buyer);
  }

  deleteBuyer(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
