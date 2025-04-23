import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  private _title: string = 'demo-angular QUE JAI CHANGE';
  private _couleur: string = "black";
  public laDate: Date = new Date();

  public get couleur(): string {
    return this._couleur;
  }

  public set couleur(value: string) {
    this._couleur = value;
  }

  public demo: any = {
    nom: "Toto"
  };

  public get title(): string {
    return this._title;
  }

  public set title(value: string) {
    this._title = value;
  }
  
  public changeTitle() {
    this._title = "Nouveau titre";
  }

  public inputTitle(evt: any) {
    this._title = evt.target.value;
  }

  public onButtonClicked(value: string) {
    alert(value);
  }
}
