import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';

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
  }

  ngOnDestroy(): void {
    console.log("DESTRUCTION MASSIVE !");
    this.simpleCounterSub.unsubscribe();
  }
}
