import { Component, ContentChild, TemplateRef } from '@angular/core';

@Component({
  selector: 'asc-list',
  standalone: false,
  templateUrl: './asc-list.component.html',
  styleUrl: './asc-list.component.css'
})
export class AscListComponent {
  @ContentChild('demonstration') demonstration!: TemplateRef<unknown>;

  leContext: any = {
    cle: {
      nom: "Un nom"
    },

    autre: "Toto"
  };
}
