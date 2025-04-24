import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../matiere';
import { MatiereService } from '../matiere.service';

@Component({
  selector: 'app-matiere',
  standalone: false,
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})
export class MatiereComponent {
  public matieres$!: Observable<Matiere[]>;

  constructor(private service: MatiereService) {
    this.matieres$ = this.service.findAll();
  }
}
