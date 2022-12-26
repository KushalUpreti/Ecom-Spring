import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-page',
  templateUrl: './item-page.component.html',
  styleUrls: ['./item-page.component.scss'],
})
export class ItemPageComponent implements OnInit {
  constructor(
    private readonly http: HttpClient,
    private readonly router: Router
  ) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  item: any = null;

  carouselItems = [
    {
      imageURL:
        'http://api.letsdiskuss.com/resources/static/asset/uploads/1650505823637-aviv-rachmadian-7F7kEHj72MQ-unsplash-scaled.jpg',
      title: "Women's Fashion",
      caption:
        'Pick outfits that fit the setting. Let your characters change outfits.',
    },
    {
      imageURL:
        'http://api.letsdiskuss.com/resources/static/asset/uploads/1650505823637-aviv-rachmadian-7F7kEHj72MQ-unsplash-scaled.jpg',
      title: "Women's Fashion",
      caption:
        'Pick outfits that fit the setting. Let your characters change outfits.',
    },
    {
      imageURL:
        'http://api.letsdiskuss.com/resources/static/asset/uploads/1650505823637-aviv-rachmadian-7F7kEHj72MQ-unsplash-scaled.jpg',
      title: "Women's Fashion",
      caption:
        'Pick outfits that fit the setting. Let your characters change outfits.',
    },
  ];
  showText: boolean = false;

  ngOnInit(): void {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const id = urlParams.get('id');

    if (!id) {
      return;
    }

    this.http
      .get<any>(`http://localhost:8080/api/guest/item/getItem/${id}`)
      .subscribe((item) => {
        this.item = item;
      });
  }
}
