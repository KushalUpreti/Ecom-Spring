import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./home-page.module').then((m) => m.HomePageModule),
  },
  {
    path: '**',
    loadChildren: () =>
      import('./notfound-page.module').then((m) => m.NotfoundPageModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
