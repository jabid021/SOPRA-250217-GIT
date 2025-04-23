import { Component, Input } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  standalone: false,
  templateUrl: './asc-text-field.component.html',
  styleUrl: './asc-text-field.component.css'
})
export class AscTextFieldComponent {
  @Input() label: string = "";
  @Input() value: string = "";
}
