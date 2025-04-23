import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private _todos: Array<Todo> = new Array<Todo>();
  private todoId: number = 0;

  public findAll(): Array<Todo> {
    return this._todos;
  }

  public findById(id: number): Todo | undefined {
    return this._todos.find(t => t.id == id);
  }

  public save(todo: Todo): Todo {
    let savedTodo: Todo = todo;

    if (!todo.id) {
      savedTodo = new Todo(todo.id, todo.title, todo.completed, 0);

      savedTodo.id = ++this.todoId;

      this._todos.push(savedTodo);
    }

    else {
      savedTodo = this.findById(todo.id) ?? todo;
      savedTodo.title = todo.title;
    }

    return savedTodo;
  }

  public deleteById(id: number): void {
    const todo: Todo | undefined = this._todos.find(t => t.id == id);

    if (!todo) {
      return;
    }

    this._todos.splice(this._todos.indexOf(todo), 1);
  }
}
