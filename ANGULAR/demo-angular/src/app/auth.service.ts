import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from './auth-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public token: string = "";

  constructor(private http: HttpClient) { }

  public authenticate() {
    this.http.post<AuthResponse>("http://localhost:8080/api/connexion", {
      login: "user",
      password: "123456$"
    }).subscribe(resp => {
      this.token = resp.token;
    });
  }
}
