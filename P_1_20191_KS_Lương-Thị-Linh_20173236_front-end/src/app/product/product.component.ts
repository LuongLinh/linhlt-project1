import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../modules/product';
import { Observable, Subject } from 'rxjs';

import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private productservice: ProductService) {}


  products: Observable<Product[]>;

  ngOnInit() {
    this.productservice.getProductList().subscribe(data => {
      this.products = data;
    });
    }

}
