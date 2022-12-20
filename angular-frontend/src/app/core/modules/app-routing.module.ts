import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemCardComponent } from 'src/app/elements/components/item-card/item-card.component';
import { ItemsListComponent } from 'src/app/elements/components/items-list/items-list.component';

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
