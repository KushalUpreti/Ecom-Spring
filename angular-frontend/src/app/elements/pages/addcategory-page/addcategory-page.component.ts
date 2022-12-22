import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-addcategory-page',
  templateUrl: './addcategory-page.component.html',
  styleUrls: ['./addcategory-page.component.scss'],
})
export class AddCategoryPageComponent {
  title = new FormControl('', [Validators.required]);

  addItem() {
    let emailText = this.title.value;
  }

  getTitleErrorMessage() {
    if (this.title.hasError('required')) {
      return 'You must enter a value';
    }
    return '';
  }
}
