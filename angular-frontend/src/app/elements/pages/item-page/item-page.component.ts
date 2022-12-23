import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { AuthService } from 'src/app/core/services/auth.service';
import {
  removeItemFromRemote,
  resetCart,
} from 'src/app/core/store/cart/cart.actions';

@Component({
  selector: 'app-item-page',
  templateUrl: './item-page.component.html',
  styleUrls: ['./item-page.component.scss'],
})
export class ItemPageComponent implements OnInit {
  constructor(
    private readonly http: HttpClient,
    private readonly authService: AuthService,
    private readonly store: Store,
    private readonly router: Router,
    private readonly route: ActivatedRoute
  ) {}

  item: any = null;

  ngOnInit(): void {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');

    if (!id) {
      return;
    }
    this.http
      .get<any>(`http://localhost:8080/api/item/getItem/${id}`)
      .subscribe((item) => {
        this.item = item;
      });
  }
}
