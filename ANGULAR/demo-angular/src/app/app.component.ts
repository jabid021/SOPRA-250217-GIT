import { Component } from '@angular/core';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  standalone: false
})
export class AppComponent {
  private _title: string = 'demo-angular QUE JAI CHANGE';
  private _couleur: string = "black";
  private _todo: Todo = new Todo(1, "Test", false, 42);

  public demo: any = {
    nom: "Toto"
  };

  public get title(): string {
    return this._title;
  }

  public set title(value: string) {
    this._title = value;
  }

  public get couleur(): string {
    return this._couleur;
  }

  public set couleur(value: string) {
    this._couleur = value;
  }

  public changeTitle() {
    this._title = "Nouveau titre";
  }

  public inputTitle(evt: any) {
    this._title = evt.target.value;
  }
}
