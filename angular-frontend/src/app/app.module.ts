import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StoreModule } from '@ngrx/store';
import { AppComponent } from './app.component';
import { HeaderModule } from './core/header/header.module';
import { AppRoutingModule } from './core/modules/app-routing.module';
import { MaterialModule } from './core/modules/material.module';
import { ItemCardComponent } from './elements/components/item-card/item-card.component';
import { ItemsListComponent } from './elements/components/items-list/items-list.component';

@NgModule({
  declarations: [AppComponent, ItemCardComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    HeaderModule,
    StoreModule.forRoot({}, {}),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
