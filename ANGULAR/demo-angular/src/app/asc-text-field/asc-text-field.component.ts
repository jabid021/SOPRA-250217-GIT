import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  standalone: false,
  templateUrl: './asc-text-field.component.html',
  styleUrl: './asc-text-field.component.css'
})
export class AscTextFieldComponent {
  @Input() label: string = "";
  @Input() value: string = "";
  @Output() clicked = new EventEmitter<string>();
  @Output() valueChange = new EventEmitter<string>();

  public onOutputClicked() {
    this.clicked.emit(this.value);
    this.valueChange.emit(this.value);
  }
}
