import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from 'src/app/elements/pages/cart-page/cart-page.component';
import { SharedModule } from './shared.module';
import { CartItemComponent } from 'src/app/elements/components/cart-item/cart-item.component';
import { CartItemlistComponent } from 'src/app/elements/components/cart-itemlist/cart-itemlist.component';

const routes: Routes = [{ path: '', component: CartPageComponent }];

@NgModule({
  declarations: [CartPageComponent, CartItemComponent, CartItemlistComponent],
  imports: [CommonModule, RouterModule.forChild(routes)],
})
export class CartPageModule {}
