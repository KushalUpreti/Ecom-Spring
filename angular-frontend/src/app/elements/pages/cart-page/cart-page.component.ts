import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.scss'],
})
export class CartPageComponent implements OnInit {
  constructor(private readonly http: HttpClient) {}

  cartItems: any = [
    {
      id: 1,
      itemId: 2,
      title: 'Spidr Bottle',
      cartId: 3,
      price: 333,
      quantity: 1,
    },
    {
      id: 1,
      itemId: 2,
      title: 'Spidr Bottle',
      cartId: 3,
      price: 111,
      quantity: 4,
    },
    {
      id: 1,
      itemId: 2,
      title: 'Spidr Bottle',
      cartId: 3,
      price: 333,
      quantity: 3,
    },
  ];

  ngOnInit(): void {
    // this.http
    //   .get<any>(' http://localhost:3000/periodicElement')
    //   .subscribe((cartItems) => {
    //     this.cartItems = cartItems;
    //   });
  }

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
}
