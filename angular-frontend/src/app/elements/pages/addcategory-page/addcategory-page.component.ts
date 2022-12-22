import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addcategory-page',
  templateUrl: './addcategory-page.component.html',
  styleUrls: ['./addcategory-page.component.scss'],
})
export class AddCategoryPageComponent {
  title = new FormControl('', [Validators.required]);

  constructor(private readonly http: HttpClient) {}

  addCategory() {
    let title = this.title.value;
    this.http
      .post<any>(`http://localhost:8080/api/admin/addCategory`, {
        title,
      })
      .subscribe((res) => {
        this.title.reset();
        alert('Category added');
      });
  }

  getTitleErrorMessage() {
    if (this.title.hasError('required')) {
      return 'You must enter a value';
    }
    return '';
  }
}
