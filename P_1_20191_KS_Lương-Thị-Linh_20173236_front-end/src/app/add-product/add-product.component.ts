import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../modules/product';

import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private productservice: ProductService) { }

  get ProductName() {
    return this.productsaveform.get('product_name');
  }

  get ProductPrice() {
    return this.productsaveform.get('product_price');
  }

  get ProductDescription() {
    return this.productsaveform.get('product_description');
  }

  get CategoryType() {
    return this.productsaveform.get('category_type');
  }

  get Image1() {
    return this.productsaveform.get('image1');
  }

  get Image2() {
    return this.productsaveform.get('image2');
  }


  get Image3() {
    return this.productsaveform.get('image3');
  }

  product: Product = new Product();
  submitted = false;

  productsaveform = new FormGroup ({

    product_name: new FormControl(),
    product_price: new FormControl(),
    product_description: new FormControl(),

    category_type: new FormControl(),
    image1: new FormControl(),
    image2: new FormControl(),
    image3: new FormControl(),
  });

  ngOnInit() {
    this.submitted = false;
  }

  saveProduct(saveProduct) {
    this.product = new Product();
    this.product.product_name = this.ProductName.value;
    this.product.product_price = this.ProductPrice.value;
    this.product.product_description = this.ProductDescription.value;
    this.product.category_type = this.CategoryType.value,
    this.product.image1 = this.Image1.value,
    this.product.image2 = this.Image2.value,
    this.product.image3 = this.Image3.value,
    this.submitted = true;
    this.save();
  }


  save() {
    this.productservice.createProduct(this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
  }

  addProductForm() {
    this.submitted = false;
    this.productsaveform.reset();
  }
}
