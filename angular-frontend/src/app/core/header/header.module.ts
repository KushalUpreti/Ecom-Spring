import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header.component';
import { MaterialModule } from '../modules/material.module';
import { UsernamePipe } from 'src/app/shared/pipes/username.pipe';

@NgModule({
  declarations: [HeaderComponent, UsernamePipe],
  imports: [CommonModule, MaterialModule],
  exports: [HeaderComponent],
})
export class HeaderModule {}
