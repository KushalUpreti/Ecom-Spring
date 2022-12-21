import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from 'src/app/elements/pages/cart-page/cart-page.component';
import { SharedModule } from './shared.module';

const routes: Routes = [{ path: '', component: CartPageComponent }];

@NgModule({
  declarations: [CartPageComponent],
  imports: [CommonModule, RouterModule.forChild(routes), SharedModule],
})
export class CartPageModule {}
