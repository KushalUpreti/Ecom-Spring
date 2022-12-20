import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from 'src/app/elements/pages/login-page/login-page.component';
import { SharedModule } from './shared.module';

const routes: Routes = [{ path: '', component: LoginPageComponent }];

@NgModule({
  declarations: [LoginPageComponent],
  imports: [SharedModule, RouterModule.forChild(routes)],
})
export class LoginPageModule {}
