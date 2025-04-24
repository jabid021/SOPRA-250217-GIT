import { Component, ContentChild, Input, TemplateRef } from '@angular/core';
import { Todo } from '../todo';

@Component({
  selector: 'asc-list',
  standalone: false,
  templateUrl: './asc-list.component.html',
  styleUrl: './asc-list.component.css'
})
export class AscListComponent {
  @Input() todos: Array<Todo> = new Array<Todo>();
  @ContentChild('todotpl') todotpl!: TemplateRef<unknown>;
  @ContentChild('autretpl') autretpl!: TemplateRef<unknown>;

  leContext: any = {
    cle: {
      nom: "Un nom"
    },

    autre: "Toto"
  };
}
