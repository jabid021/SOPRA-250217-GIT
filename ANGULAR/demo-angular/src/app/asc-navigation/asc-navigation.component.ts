import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'asc-navigation',
  standalone: false,
  templateUrl: './asc-navigation.component.html',
  styleUrl: './asc-navigation.component.css'
})
export class AscNavigationComponent implements OnInit {
  ngOnInit(): void {
    console.log("Initialisation !");
  }
}
