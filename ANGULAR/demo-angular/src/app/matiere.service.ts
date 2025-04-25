import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, startWith, Subject, switchMap } from 'rxjs';
import { Matiere } from './matiere';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {
  private refresh$: Subject<void> = new Subject<void>();
  private API_URL: string = `${ environment.API_URL }/matiere`;

  constructor(private http: HttpClient) { }

  public refresh() {
    this.refresh$.next();
  }

  public findAll(): Observable<Matiere[]> {
    // return this.http.get<Matiere[]>("http://localhost:8080/api/matiere", {
    //   headers: {
    //     'Authorization': "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzQ1NDk4MjQ0LCJleHAiOjE3NDU1MDE4NDR9.Z59OkTHV204DT4W3LE_IV76a0wYut_lDsL7aQsAlH-6x_qnM_lGZWgO8jJOoifiOJjqkmTVMTsGEnnMMftZfIA"
    //   }
    // });
    
    // return this.http.get<Matiere[]>("http://localhost:8080/api/matiere");

    return this.refresh$.pipe(
      // Pour forcer une première initialisation de la liste
      startWith(null),
      
      // Transformer le "void" en Array<Todo> en allant chercher les infos
      switchMap(() => {
        return this.http.get<Matiere[]>(this.API_URL)
      })
    );
  }

  public save(matiere: any) {
    if (matiere.id) {
      return this.http.put<Matiere>(`${ this.API_URL }/${ matiere.id }`, matiere);
    }
    
    return this.http.post<Matiere>(this.API_URL, matiere);
  }
  
  public delete(matiere: any) {
    return this.http.delete<void>(`${ this.API_URL }/${ matiere.id }`);
  }
}
