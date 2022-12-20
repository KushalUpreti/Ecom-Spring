import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { ItemCardComponent } from 'src/app/elements/components/item-card/item-card.component';
import { ItemsListComponent } from 'src/app/elements/components/items-list/items-list.component';
import { MaterialModule } from './material.module';

@NgModule({
  declarations: [ItemCardComponent, ItemsListComponent],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  exports: [
    ItemCardComponent,
    ItemsListComponent,
    ReactiveFormsModule,
    CommonModule,
    MaterialModule,
  ],
  providers: [],
})
export class SharedModule {}
