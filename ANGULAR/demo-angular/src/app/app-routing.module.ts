import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TodoComponent } from './todo/todo.component';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { ObservableComponent } from './observable/observable.component';
import { MatiereComponent } from './matiere/matiere.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { authGuard } from './auth.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'todo', component: TodoComponent },
  { path: 'todo/:id', component: TodoDetailComponent },
  { path: 'observable', component: ObservableComponent },
  { path: 'matiere', component: MatiereComponent, canActivate: [ authGuard ] },
  { path: 'connexion', component: ConnexionComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
