import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoComplet',
  standalone: false
})
export class TodoCompletPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    console.log("valeur ici", value);
    console.log("args ici", args);
    
    return "Démonstration";
  }
}
