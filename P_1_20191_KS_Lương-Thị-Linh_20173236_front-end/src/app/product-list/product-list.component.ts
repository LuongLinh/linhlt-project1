import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../modules/product';
import { Observable, Subject } from 'rxjs';

import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  constructor(private productservice: ProductService) {}

  productsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  products: Observable<Product[]>;
  product: Product = new Product();
  deleteMessage = false;
  productlist: any;
  isupdated = false;

  ngOnInit() {
    this.isupdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [
        [6, 16, 20, -1],
        [6, 16, 20, 'All']
      ],
      processing: true
    };
    this.productservice.getProductList().subscribe(data => {
      this.products = data;
      this.dtTrigger.next();
    });
  }

  deleteProduct(id: number) {
    this.productservice.deleteProduct(id).subscribe(
      data => {
        console.log(data);
        this.deleteMessage = true;
        this.productservice.getProductList().subscribe(data => {
          this.products = data;
        });
      },
      error => console.log(error)
    );
  }

  updateProduct(id: number) {
    this.productservice.getProduct(id).subscribe(
      data => {
        this.productlist = data;
      },
      error => console.log(error)
    );
  }

    productupdateform = new FormGroup({
      product_id: new FormControl(),
      product_name: new FormControl(),
      product_price: new FormControl(),
      product_description: new FormControl(),

      category_type: new FormControl(),
      image1: new FormControl(),
      image2: new FormControl(),
      image3: new FormControl(),
    });


  updatePro(updpro) {
    this.product = new Product();
    this.product.product_id = this.ProductId.value;
    this.product.product_name = this.ProductName.value;
    this.product.product_price = this.ProductPrice.value;
    this.product.product_description = this.ProductDescription.value;
    this.product.category_type = this.CategoryType.value,
    this.product.image1 = this.Image1.value,
    this.product.image2 = this.Image2.value,
    this.product.image3 = this.Image3.value,
      console.log(this.CategoryType.value);

    this.productservice
      .updateProduct(this.product.product_id, this.product)
      .subscribe(
        _data => {
          this.isupdated = true;
          this.productservice.getProductList().subscribe(data => {
            this.products = data;
          });
        },
        error => console.log(error)
      );
  }


  get ProductName() {
    return this.productupdateform.get('product_name');
  }

  get ProductPrice() {
    return this.productupdateform.get('product_price');
  }

  get ProductDescription() {
    return this.productupdateform.get('product_description');
  }

  get CategoryType() {
    return this.productupdateform.get('category_type');
  }

  get Image1() {
    return this.productupdateform.get('image1');
  }

  get Image2() {
    return this.productupdateform.get('image2');
  }


  get Image3() {
    return this.productupdateform.get('image3');
  }

  get ProductId() {
    return this.productupdateform.get('product_id');
  }

  changeisUpdate() {
    this.isupdated = false;
  }
}
