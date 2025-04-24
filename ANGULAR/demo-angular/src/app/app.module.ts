import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscListComponent } from './asc-list/asc-list.component';
import { AscNavigationComponent } from './asc-navigation/asc-navigation.component';
import { AscTextFieldComponent } from './asc-text-field/asc-text-field.component';
import { HomeComponent } from './home/home.component';
import { ObservableComponent } from './observable/observable.component';
import { TodoCompletPipe } from './todo-complet.pipe';
import { TodoDetailComponent } from './todo-detail/todo-detail.component';
import { TodoComponent } from './todo/todo.component';
import { MatiereComponent } from './matiere/matiere.component';
import { jwtHeaderInterceptor } from './jwt-header.interceptor';

@NgModule({
  declarations: [ // Déclaration dans notre module de tout ce qui est utilisé dans notre module principal
    AppComponent,
    TodoCompletPipe,
    AscBoldComponent,
    AscTextFieldComponent,
    AscListComponent,
    AscNavigationComponent,
    HomeComponent,
    TodoComponent,
    TodoDetailComponent,
    ObservableComponent,
    MatiereComponent
  ],
  
  imports: [ // Tous les modules dont on a besoin dans notre module à nous
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    // HttpClientModule
  ],

  providers: [ // Tous les services injectables
    provideHttpClient(withFetch(), withInterceptors([ jwtHeaderInterceptor ])) // Remplace l'import de HttpClientModule
  ],

  bootstrap: [ // Le composant principal de notre module, si besoin
    AppComponent
  ]
})
export class AppModule { }
