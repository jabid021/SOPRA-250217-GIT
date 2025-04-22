import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  standalone: false
})
export class AppComponent {
  private _title: string = 'demo-angular QUE JAI CHANGE';

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
}
