import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo',
  standalone: false,
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  private _formTodo: Todo = new Todo(0, "", false, 0);
  public todos$!: Observable<Array<Todo>>;

  constructor(private service: TodoService) {
    this.todos$ = this.service.findAll();
  }

  public get todos(): Array<Todo> {
    return [];
    // return this.service.findAll();
  }

  public get formTodo(): Todo {
    return this._formTodo;
  }

  public refreshTodos() {
    // this.todos$ = this.service.findAll();
    this.service.refresh();
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
