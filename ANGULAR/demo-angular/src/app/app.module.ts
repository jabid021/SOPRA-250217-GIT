import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { TodoCompletPipe } from './todo-complet.pipe';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTextFieldComponent } from './asc-text-field/asc-text-field.component';
import { AscListComponent } from './asc-list/asc-list.component';
import { AscNavigationComponent } from './asc-navigation/asc-navigation.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [ // Déclaration dans notre module de tout ce qui est utilisé dans notre module principal
    AppComponent,
    TodoCompletPipe,
    AscBoldComponent,
    AscTextFieldComponent,
    AscListComponent,
    AscNavigationComponent,
    HomeComponent
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
