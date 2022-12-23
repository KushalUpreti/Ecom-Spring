import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { AuthService } from 'src/app/core/services/auth.service';
import { removeItemFromRemote } from 'src/app/core/store/cart/cart.actions';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.scss'],
})
export class CartPageComponent implements OnInit {
  constructor(
    private readonly http: HttpClient,
    private readonly authService: AuthService,
    private readonly store: Store
  ) {}

  cartItems: any = [];

  ngOnInit(): void {
    this.http
      .get<any>(
        `http://localhost:8080/api/cart/getCartItems/${
          this.authService.getAuth().id
        }`
      )
      .subscribe((cartItems) => {
        this.cartItems = cartItems;
      });
  }

  removeCartItem = (cartItemId: number) => {
    this.store.dispatch(removeItemFromRemote({ cartItemId }));
    let filteredList = this.cartItems.filter((item) => item.id !== cartItemId);
    this.cartItems = [...filteredList];
  };

  getTotalQuantity(): number {
    let sum: number = 0;
    this.cartItems.forEach((element) => {
      sum += element.quantity;
    });
    return sum;
  }

  getTotalPrice(): number {
    let sum: number = 0;
    this.cartItems.forEach((element) => {
      sum += element.price;
    });
    return sum;
  }

  placeOrder(): void {}
}
