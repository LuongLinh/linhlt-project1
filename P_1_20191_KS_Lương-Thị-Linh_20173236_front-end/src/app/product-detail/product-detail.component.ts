import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Product } from '../modules/product';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent {
  constructor(
    private productservice: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  products: Product[];
  isLoadingResults = true;
  count: number;
  ngOnInit() {
    this.getProduct(this.route.snapshot.params['id']);
  }

  getProduct(id: any) {
    this.productservice.getProduct(id).subscribe((data: any) => {
      this.products = data;
      console.log(this.products);
      this.isLoadingResults = false;
    });
  }
}
