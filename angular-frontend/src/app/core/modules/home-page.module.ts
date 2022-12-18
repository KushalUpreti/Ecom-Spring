import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarouselComponent } from 'src/app/elements/components/carousel/carousel.component';
import { ItemsListComponent } from 'src/app/elements/components/items-list/items-list.component';
import { HomePageComponent } from 'src/app/elements/pages/home-page/home-page.component';

const routes: Routes = [{ path: '', component: HomePageComponent }];

@NgModule({
  declarations: [CarouselComponent, HomePageComponent, ItemsListComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
})
export class HomePageModule {}
