import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './reactive.component.html',
  styleUrl: './reactive.component.css'
})
export class ReactiveComponent {
  productForm=new FormGroup(
    {
    productid:new FormControl('10',[Validators.required,Validators.min(100),Validators.max(1000)]),
    // the abovve will only take values from 1 to 100 or any min value to any max value..the 10 will be default value
    brand:new FormControl('',Validators.maxLength(20)),
    description:new FormControl(''),
    qty:new FormControl(0),
    price:new FormControl(0),
  }
);
onSubmit(){
  console.error(this.productForm);
  console.warn(this.productForm.value);
  console.log(this.productForm.controls['price'].value);
}
}
