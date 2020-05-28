import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UserListComponent } from './user-list/user-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: 'admin', component: HomeComponent,
    children: [
            { path: 'add-product', component: AddProductComponent},
            { path: 'view-product', component: ProductListComponent},
            { path: 'user', component: UserListComponent},
    ] },
];

@NgModule({
  declarations: [ProductListComponent, AddProductComponent, UserListComponent, HomeComponent],
  imports: [
    CommonModule,
    RouterModule,
    RouterModule.forChild(routes)
  ]
})
export class AdminModule { }
