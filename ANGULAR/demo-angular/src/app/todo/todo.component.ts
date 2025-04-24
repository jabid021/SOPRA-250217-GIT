import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-todo',
  standalone: false,
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  private _formTodo: Todo = new Todo(0, "", false, 0);
  public obs$!: Observable<Todo[]>;

  constructor(private service: TodoService, private http: HttpClient) {
    this.obs$ = this.http.get<Todo[]>("https://jsonplaceholder.typicode.com/todos");

    // obs$.subscribe(todos => {
    //   console.log("LISTE = ", todos);
    // });

    console.log("ARRIVE ICI");
  }

  public get todos(): Array<Todo> {
    return this.service.findAll();
  }

  public get formTodo(): Todo {
    return this._formTodo;
  }

  public addOrEditTodo() {
    this.service.save(this._formTodo);
    this._formTodo = new Todo(0, "", false, 0);
  }

  public editTodo(todo: Todo) {
    this._formTodo = new Todo(todo.id, todo.title, todo.completed, todo.userId);
  }

  public cancelEditTodo() {
    this._formTodo = new Todo(0, "", false, 0);
  }

  public deleteTodo(todo: Todo) {
    this.service.deleteById(todo.id);
  }
}
