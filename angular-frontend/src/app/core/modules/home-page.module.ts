import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarouselComponent } from 'src/app/elements/components/carousel/carousel.component';
import { HomePageComponent } from 'src/app/elements/pages/home-page/home-page.component';
import { SharedModule } from './shared.module';

const routes: Routes = [{ path: '', component: HomePageComponent }];

@NgModule({
  declarations: [CarouselComponent, HomePageComponent],
  imports: [SharedModule, RouterModule.forChild(routes)],
})
export class HomePageModule {}
