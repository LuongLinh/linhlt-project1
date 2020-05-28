import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../modules/product';
import { Observable, Subject } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-girl',
  templateUrl: './girl.component.html',
  styleUrls: ['./girl.component.css']
})
export class GirlComponent implements OnInit {

  constructor(private productservice: ProductService) {}


  products: Observable<Product[]>;

  ngOnInit() {
    this.productservice.getProductList().subscribe(data => {
      this.products = data;
    });
    }

}
