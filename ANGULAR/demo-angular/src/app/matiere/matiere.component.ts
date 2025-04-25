import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Matiere } from '../matiere';
import { MatiereService } from '../matiere.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-matiere',
  standalone: false,
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})
export class MatiereComponent implements OnInit, OnDestroy {
  matiereForm!: FormGroup;
  matieres$!: Observable<Matiere[]>;
  editingMatiere!: Matiere | null;
  subscriptions: any = [];

  constructor(private service: MatiereService, private formBuilder: FormBuilder) { }
  
  ngOnInit(): void {
    this.matiereForm = this.formBuilder.group({
      libelle: this.formBuilder.control('', Validators.required)
    });
    
    this.matieres$ = this.service.findAll();
  }

  ngOnDestroy(): void {
    this.unsub('addOrEdit');
    this.unsub('delete');
  }

  public addOrEditMatiere() {
    this.unsub('addOrEdit');

    this.subscriptions['addOrEdit'] = this.service.save({
      id: this.editingMatiere?.id,
      ...this.matiereForm.value
    }).subscribe(() => this.service.refresh());

    this.editingMatiere = null;
    this.matiereForm.get('libelle')?.setValue("");
  }

  public editMatiere(matiere: Matiere) {
    this.matiereForm.get('libelle')?.setValue(matiere.libelle);
    this.editingMatiere = matiere;
  }

  public deleteMatiere(matiere: Matiere) {
    this.unsub('delete');

    this.subscriptions['delete'] = this.service.delete(matiere).subscribe(() => this.service.refresh());
  }

  private unsub(name: string) {
    if (this.subscriptions[name]) {
      this.subscriptions[name].unsubscribe();
      this.subscriptions[name] = null;
    }
  }
}
