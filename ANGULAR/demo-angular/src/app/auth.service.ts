import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from './auth-response';
import { AuthRequest } from './auth-request';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public token: string = "";

  constructor(private http: HttpClient) { }

  public authenticate(authRequest: AuthRequest) {
    this.http.post<AuthResponse>("http://localhost:8080/api/connexion", {
      login: authRequest.login,
      password: authRequest.password
    }).subscribe(resp => {
      this.token = resp.token;
    });
  }
}
