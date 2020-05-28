import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { AppComponent } from './app.component';
import { SlideComponent } from './slide/slide.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { GirlComponent } from './girl/girl.component';
import { BoyComponent } from './boy/boy.component';
import { UserListComponent } from './user-list/user-list.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', component: SlideComponent },
  { path: 'home', component: SlideComponent},
  { path: 'product/:id', component: ProductDetailComponent},
  { path: 'rg', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'girl', component: GirlComponent },
  { path: 'boy', component: BoyComponent },
  { path: 'add-product', component: AddProductComponent},
            { path: 'view-product', component: ProductListComponent},
            { path: 'user', component: UserListComponent},
  { path: 'admin', component: HomeComponent,
    children: [
            { path: 'add-product', component: AddProductComponent},
            { path: 'view-product', component: ProductListComponent},
            { path: 'user', component: UserListComponent},
    ] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
