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
    // return this.http.get<Matiere[]>("http://localhost:8080/api/matiere", {
    //   headers: {
    //     'Authorization': "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzQ1NDk4MjQ0LCJleHAiOjE3NDU1MDE4NDR9.Z59OkTHV204DT4W3LE_IV76a0wYut_lDsL7aQsAlH-6x_qnM_lGZWgO8jJOoifiOJjqkmTVMTsGEnnMMftZfIA"
    //   }
    // });
    
    return this.http.get<Matiere[]>("http://localhost:8080/api/matiere");
  }
}
