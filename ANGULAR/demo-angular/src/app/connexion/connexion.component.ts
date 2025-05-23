import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { AuthRequest } from '../auth-request';

@Component({
  selector: 'app-connexion',
  standalone: false,
  templateUrl: './connexion.component.html',
  styleUrl: './connexion.component.css'
})
export class ConnexionComponent implements OnInit {
  public authForm!: FormGroup;
  public loginCtrl!: FormControl;
  public passwordCtrl!: FormControl;

  constructor(private service: AuthService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.loginCtrl = this.formBuilder.control('Valeur par défaut', Validators.required);
    this.passwordCtrl = this.formBuilder.control('', [ Validators.required, Validators.minLength(6) ]);

    // this.authForm = this.formBuilder.group({
    //   login: this.formBuilder.control('Valeur par défaut', Validators.required),
    //   password: this.formBuilder.control('', [ Validators.required, Validators.minLength(6) ])
    // });

    this.authForm = this.formBuilder.group({
      login: this.loginCtrl,
      password: this.passwordCtrl
    });
  }

  public authenticate() {
    this.service.authenticate(new AuthRequest(this.authForm.value.login, this.authForm.value.password));

    // FIXME : Si l'auth échoue, on est quand même redirigé
    this.router.navigate([ '/home' ]);
  }
}
