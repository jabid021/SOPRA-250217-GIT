import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../matiere';
import { MatiereService } from '../matiere.service';

@Component({
  selector: 'app-matiere',
  standalone: false,
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})
export class MatiereComponent implements OnInit {
  public matieres$!: Observable<Matiere[]>;

  constructor(private service: MatiereService) { }
  
  ngOnInit(): void {
    this.matieres$ = this.service.findAll();
  }
}
