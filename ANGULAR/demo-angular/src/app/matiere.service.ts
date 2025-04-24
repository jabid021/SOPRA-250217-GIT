import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from './matiere';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {
  constructor(private http: HttpClient) { }

  public findAll(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>("http://localhost:8080/api/matiere");
  }  
}
