import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { FormControl, Validators } from '@angular/forms';
import { catchError, EMPTY, switchMap, TimeoutError } from 'rxjs';

@Component({
  selector: 'app-additem-page',
  templateUrl: './additem-page.component.html',
  styleUrls: ['./additem-page.component.scss'],
})
export class AdditemPageComponent implements OnInit {
  title = new FormControl('', [Validators.required]);
  description = new FormControl('', [Validators.required]);
  price = new FormControl('', [Validators.min(1)]);
  categories = [];
  selected = -1;

  constructor(private readonly http: HttpClient) {}

  ngOnInit(): void {
    this.http
      .get<any>(`http://localhost:8080/api/category/`)
      .subscribe((categories) => {
        this.categories = categories;
      });
  }

  addItem() {
    let title = this.title.value;
    let description = this.description.value;
    let price: number = +this.price.value;

    this.http
      .post<any>(`http://localhost:8080/api/admin/addItem/${this.selected}`, {
        title,
        description,
        price,
      })
      .subscribe((res) => {
        alert('Called');
      });
  }

  getTitleErrorMessage() {
    if (this.title.hasError('required')) {
      return 'You must enter a value';
    }
    return '';
  }
  getDescErrorMessage() {
    if (this.description.hasError('required')) {
      return 'You must enter a value';
    }
    return '';
  }
  getPriceErrorMessage() {
    if (this.description.hasError('min')) {
      return 'Enter min price of 1';
    }
    return '';
  }
}
