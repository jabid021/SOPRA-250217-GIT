import { Component } from '@angular/core';
import { AuthRequest } from '../auth-request';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  standalone: false,
  templateUrl: './connexion.component.html',
  styleUrl: './connexion.component.css'
})
export class ConnexionComponent {
  private _authRequest: AuthRequest = new AuthRequest("", "");

  public get authRequest() {
    return this._authRequest;
  }

  constructor(private service: AuthService, private router: Router) { }

  public authenticate() {
    this.service.authenticate(this._authRequest);

    // FIXME : Si l'auth échoue, on est quand même redirigé
    this.router.navigate([ '/home' ]);
  }
}
