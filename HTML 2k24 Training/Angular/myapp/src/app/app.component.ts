import { CommonModule } from '@angular/common';
import { AfterContentInit, Component, DoCheck, input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { ColourmineComponent } from './colourmine/colourmine.component';//We have created our own compnent named "colormine" ...now we are importing this so that to include the colormine code
import {  DatacomponentComponent } from './datacomponent/datacomponent.component';
import { FormsComponent } from './forms/forms.component';
import { NewformsComponent } from './newforms/newforms.component';
import { ReactiveComponent } from './reactive/reactive.component';
import { FormBuilderComponent } from './formbuilder/formbuilder.component';
import { HttpClientModule } from '@angular/common/http';

// import { FormBuilderComponent } from './formbuilder/formbuilder.component';



//We need formsModule to make our input work 
// we need commonModule for ngIf and ngFor to work
//All these are jst imported by writing the namme ...but to make it work we need to write this line in @Component{
//imports: [RouterOutlet,FormsModule,CommonModule]
//}


@Component({
  selector: 'app-root-kausthub',
  standalone: true,
  imports: [RouterOutlet,FormsModule,ReactiveComponent,CommonModule,FormBuilderComponent,ColourmineComponent,DatacomponentComponent,FormsComponent,NewformsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnChanges,OnInit,DoCheck,AfterContentInit{
  title: string="Form Parent"
 
  constructor(){
    console.log("constructor() is called.......From Parent");
  }
  ngAfterContentChecked(): void {
      console.log("ngAfterContentChecked() is called....... From Parent");
  }
  ngAfterContentInit():void{
    console.log("ngAfterContentInit() is called.........From Parent");
  }
  ngDoCheck():void{
    console.log("ngDoCheck() is called.........From Parent");
  }
  ngOnChanges(changes: SimpleChanges): void{
    console.log("ngOnChanges() is called........From Parent");
  }
  ngOnInit(): void{
    console.log("ngOnInit() is called........From Parent");
  }
  keyCapture(event: string){
    this.title=event
  }
  sendMessage(): void{
    console.log("Click event fired........From Parent")
  }
 
  // implements OnInit,OnChanges,DoCheck,AfterContentInit
  // ngOnInit(): void {
  //   throw new Error('Method not implemented.');
  // }
  // ngOnChanges(changes: SimpleChanges): void {
  //   throw new Error('Method not implemented.');
  // }
  // ngDoCheck(): void {
  //   throw new Error('Method not implemented.');
  // }
  // ngAfterContentInit(): void {
  //   throw new Error('Method not implemented.');
  // }
  // title = 'Kausthub Rao'; //interpolation
  productid="6617";
  productname="soap";
  desc="cleaning purpose";
  stock=30;
  val="";
  orderquantity =0;
  evenColor="red";
  oddColor="blue";
  available=this.orderquantity>0;//gives ture or false 
  instock=this.stock>10;
  listtemp=[{prod:"bag",price:200},{prod:"pen",price:20},{prod:"eraser",price:2}];
  products=[{productId:"6617",price:200,description:"helli"},{productId:"pen",price:20,description:"helli"},{productId:"eraser",price:2,description:"helli"}];
  // The orderqunatity=0 is an intial value ...why ...because we are taking a inpuut tag and what ever number we are entering inthe input tag we are printing it ..for that we need to intialise..else will give error
  orderDate:Date=new Date;
  printOrder(input : any):void{
    alert(input+"OrderQunatiy");
  }
  colurchange():void{
    alert("helllo");

  }

}
// import { Component } from '@angular/core';
// import { OutletContext } from '@angular/router';
// import { reduce } from 'rxjs';
// // router-OutletContext
 
// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   title = 'Kausthub';
//   company = " From UST";
//   productId="AZO1010";
//   description = "Dual camera, dual sim, 256gb, 4gb ram";
//   available = true;
//   quant = 100
//   orderqty = 0;
//   deliverColor = "red";
 
 
//   printOrder():void{
//     alert(" order placed = "+ this.orderqty );
//   }
 
 
 
//   products = [
//     { productId: "1234", description: "Mobile", price: "70000" },
//     { productId: "123", description: "Laptop", price: "75000" },
//     { productId: "1235", description: "Ipad", price: "30000" },
//     { productId: "1234", description: "iPhone15", price: "90000" },
//     { productId: "1234", description: "TV", price: "50000" }
 
//   ];
// }