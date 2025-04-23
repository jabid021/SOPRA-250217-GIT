import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { TodoCompletPipe } from './todo-complet.pipe';

@NgModule({
  declarations: [ // Déclaration dans notre module de tout ce qui est utilisé dans notre module principal
    AppComponent, TodoCompletPipe
  ],
  
  imports: [ // Tous les modules dont on a besoin dans notre module à nous
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],

  providers: [ // Tous les services injectables

  ],

  bootstrap: [ // Le composant principal de notre module, si besoin
    AppComponent
  ]
})
export class AppModule { }
