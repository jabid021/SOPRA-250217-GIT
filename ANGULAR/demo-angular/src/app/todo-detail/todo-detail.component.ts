import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Todo } from '../todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-detail',
  standalone: false,
  templateUrl: './todo-detail.component.html',
  styleUrl: './todo-detail.component.css'
})
export class TodoDetailComponent implements OnInit {
  private _todo!: Todo;

  constructor(private route: ActivatedRoute, private service: TodoService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this._todo = this.service.findById(params['id']) ?? new Todo(0, "404", false, 0);
    });
  }

  public get todo(): Todo {
    return this._todo;
  }
}
