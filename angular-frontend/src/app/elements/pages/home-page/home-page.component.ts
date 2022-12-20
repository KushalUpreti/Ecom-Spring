import { Component } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent {
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
}
