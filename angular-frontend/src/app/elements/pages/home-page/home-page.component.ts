import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent implements OnInit {
  categories: any = [];

  constructor(private readonly http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get<any>(`http://localhost:8080/api/category/`)
      .subscribe((categories) => {
        this.categories = categories;
      });
  }
}
