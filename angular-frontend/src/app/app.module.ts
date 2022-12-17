import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StoreModule } from '@ngrx/store';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './core/header/header.module';
import { MaterialModule } from './core/modules/material/material.module';
import { CarouselComponent } from './elements/components/carousel/carousel.component';
import { HomeComponent } from './elements/pages/home/home.component';

@NgModule({
  declarations: [AppComponent, CarouselComponent, HomeComponent],
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
