import { Component } from '@angular/core';
import { DataService } from '../../data.service';
import { Product } from '../../Product';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProductService } from '../product.service';




@Component({
  selector: 'app-datacomponent',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './datacomponent.component.html',
  styleUrl: './datacomponent.component.css'
})

export class DatacomponentComponent {
val="";
  prod : Product = new Product("","","",0,0);
  productData:Product[] = []; 
  //We are saving the products file contents into productData variabel..we will use this only
// constructor(private service: DataService){
//   this.productData=service.getProducts();
//   console.log(this.productData);
// }
constructor(private productService:ProductService){}
countt=0;
myFunction(event:any):void{
  this.val = event.target.value;
  this.countt = this.productData.filter((i) => i.brand == this.val).length;
}

  today: number = Date.now();

a: number = 0.259;
  b: number = 1.3495;
onSubmit():void{
  console.log(this.prod);
  this.productData.push(this.prod);
  console.log(this.productData);
  this.productService.saveProduct(this.prod).subscribe(
    (data)=>{console.log(data);},
    // (error)=>{console.error(error);}
  );
}
}

