import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Type} from './Type';
@Injectable({
  providedIn: 'root'
})
export class ActionService {
  private readonly header: HttpHeaders;
  private doactionUrl = 'http://localhost:8080/api/v1';

  simplesearch(searchoption: string, searchcontent: string): Observable<Type[]> {
    const url = `${this.doactionUrl}/search/${searchoption}/${searchcontent}`;
    return this.http.get<Type[]>(url);
  }

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*'
    });
  }
}
