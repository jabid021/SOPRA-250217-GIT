import { Component, OnDestroy, OnInit } from '@angular/core';
import { count, Observable, scan, Subject, Subscription } from 'rxjs';

@Component({
  selector: 'app-observable',
  standalone: false,
  templateUrl: './observable.component.html',
  styleUrl: './observable.component.css'
})
export class ObservableComponent implements OnInit, OnDestroy {
  private simpleCounterObs$!: Observable<number>;
  private simpleCounterSub!: Subscription;
  public counters: number[] = [];

  public arrayCounterObs$!: Observable<number[]>;


  ngOnInit(): void {
    console.log("INITIALISATION");

    let counter = 1;
    
    this.simpleCounterObs$ = new Observable<number>(obs => {
      setInterval(() => {
        obs.next(counter++);
      }, 1_000);
    });

    this.simpleCounterSub = this.simpleCounterObs$.subscribe(val => {
      console.log(val);
      this.counters.push(val);
    });

    // this.arrayCounterObs$ = new Observable<number>(obs => {
    //   setInterval(() => {
    //     obs.next(counter);
    //   }, 1_000);
    // }).pipe(
    //   // C'est comme un reduce, mais en temps réel (reduce qui fera tout à la fin)
    //   // Dans le scan, on a une fonction lambda qui accumule
    //   // > Et la valeur initiale
    //   scan((accumulateur: number[], valeur: number) => [ ...accumulateur, valeur ], [])
    // );

    // Le Subject nous permettra d'alimenter le flux en de hors de la déclaration de l'Observable
    const arrayCounterSubject = new Subject<number>();

    this.arrayCounterObs$ = arrayCounterSubject.pipe(
      scan((accumulateur: number[], valeur: number) => [ ...accumulateur, valeur ], [])
    );

    setInterval(() => {
      arrayCounterSubject.next(counter);
    }, 1_000);
  }

  ngOnDestroy(): void {
    console.log("DESTRUCTION MASSIVE !");
    this.simpleCounterSub.unsubscribe();
  }
}
