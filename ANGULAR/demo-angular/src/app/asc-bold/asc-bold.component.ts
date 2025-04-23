import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'asc-bold',
  standalone: false,
  templateUrl: './asc-bold.component.html',
  styleUrl: './asc-bold.component.css'
})
export class AscBoldComponent {
  @HostListener('click')
  public onClick() {
    alert('cliqué !')
  }
}
