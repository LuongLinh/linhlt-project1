import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';
import { AdminModule } from './admin/admin.module';


import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { GirlComponent } from './girl/girl.component';
import { BoyComponent } from './boy/boy.component';
import { SlideComponent } from './slide/slide.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { LoginComponent } from './login/login.component';
import { UserListComponent } from './user-list/user-list.component';
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { ProductOrderComponent } from './product-order/product-order.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    AddProductComponent,
    ProductListComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    ProductComponent,
    GirlComponent,
    BoyComponent,
    SlideComponent,
    ProductDetailComponent,
    LoginComponent,
    UserListComponent,
    OrderDetailComponent,
    ProductOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataTablesModule,
    AdminModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
