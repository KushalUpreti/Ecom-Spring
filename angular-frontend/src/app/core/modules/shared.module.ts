import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ItemCardComponent } from 'src/app/elements/components/item-card/item-card.component';
import { ItemsListComponent } from 'src/app/elements/components/items-list/items-list.component';
import { MaterialModule } from './material.module';

@NgModule({
  declarations: [ItemCardComponent, ItemsListComponent],
  imports: [CommonModule, MaterialModule],
  exports: [ItemCardComponent, ItemsListComponent],
  providers: [],
})
export class SharedModule {}
