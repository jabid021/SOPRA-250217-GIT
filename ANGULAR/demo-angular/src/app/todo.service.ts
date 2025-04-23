import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  constructor() { }

  public demo() {
    alert('DEMO SERVICE !');
  }
}
