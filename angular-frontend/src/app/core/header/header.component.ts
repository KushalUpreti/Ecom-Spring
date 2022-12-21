import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Auth } from 'src/app/shared/interfaces/auth.interface';
import { Cart } from 'src/app/shared/interfaces/cart.interface';
import { AuthService } from '../services/auth.service';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  constructor(
    private readonly authService: AuthService,
    private readonly cartService: CartService,
    private readonly http: HttpClient
  ) {}

  categories: any = [
    {
      id: 1,
      title: 'Electronics',
      items: [
        {
          id: 1,
          title: 'Xiaomi M1',
          price: '220',
          imageUrl:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSazCJ5wQ2juv69gdoSzqzUTa5lq6DX_LWLpTuIVeG4fChKftcYjZ_qUGFbaxLhIrz7fL0&usqp=CAU',
        },
        {
          id: 3,
          title: 'Xiaomi M2',
          price: '220',
          imageUrl:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSazCJ5wQ2juv69gdoSzqzUTa5lq6DX_LWLpTuIVeG4fChKftcYjZ_qUGFbaxLhIrz7fL0&usqp=CAU',
        },
      ],
    },
    {
      id: 1,
      title: 'Fashion',
      items: [
        {
          id: 5,
          title: 'Air Jordan',
          price: '999',
          imageUrl:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSazCJ5wQ2juv69gdoSzqzUTa5lq6DX_LWLpTuIVeG4fChKftcYjZ_qUGFbaxLhIrz7fL0&usqp=CAU',
        },
        {
          id: 2,
          title: 'Trousers XL',
          price: '300',
          imageUrl:
            'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSazCJ5wQ2juv69gdoSzqzUTa5lq6DX_LWLpTuIVeG4fChKftcYjZ_qUGFbaxLhIrz7fL0&usqp=CAU',
        },
      ],
    },
  ];

  ngOnInit(): void {
    this.http
      .get<any>(
        `http://localhost:8080/api/cart/getCartItemCount/${
          this.authService.getAuth().id
        }`
      )
      .subscribe((count) => {
        this.cartService.setCart(count);
      });
  }

  getAuth(): Auth {
    return this.authService.getAuth();
  }

  getCount(): number {
    return this.cartService.getCart() ? this.cartService.getCart().count : 0;
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }

  logout(): void {
    this.authService.logout();
  }
}
