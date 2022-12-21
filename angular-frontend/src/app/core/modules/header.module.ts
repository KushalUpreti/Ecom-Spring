import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../header/header.component';
import { MaterialModule } from './material.module';
import { UsernamePipe } from 'src/app/shared/pipes/username.pipe';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [HeaderComponent, UsernamePipe],
  imports: [CommonModule, MaterialModule, RouterModule],
  exports: [HeaderComponent],
})
export class HeaderModule {}
