import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo',
  standalone: false,
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent implements OnInit {
  private _todo: Todo = new Todo(1, "Test", false, 42);
  private _todos: Array<Todo> = new Array<Todo>();
  private _formTodo: Todo = new Todo(0, "", false, 0);
  private todoId: number = 0;

  ngOnInit(): void {
    this.todos.push(new Todo(0, "Exemple", true, 0));
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

  public addTodo() {
    this._formTodo.id = ++this.todoId;
    
    this._todos.push(this._formTodo);

    this._formTodo = new Todo(0, "", false, 0);
  }
}
