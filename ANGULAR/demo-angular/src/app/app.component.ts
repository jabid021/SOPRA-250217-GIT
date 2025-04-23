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
  private _todos: Array<Todo> = new Array<Todo>();
  private _formTodo: Todo = new Todo(0, "", false, 0);
  private todoId: number = 0;

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

  public get todo(): Todo {
    return this._todo;
  }

  public get todos(): Array<Todo> {
    return this._todos;
  }

  public get formTodo(): Todo {
    return this._formTodo;
  }

  public changeTitle() {
    this._title = "Nouveau titre";
  }

  public inputTitle(evt: any) {
    this._title = evt.target.value;
  }

  public addTodo() {
    this._formTodo.id = ++this.todoId;
    
    this._todos.push(this._formTodo);

    this._formTodo = new Todo(0, "", false, 0);
  }
}
