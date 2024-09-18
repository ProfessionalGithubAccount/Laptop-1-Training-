export class Product{
productId:string;
description:string;
qty:number;
price:number;
brand:string;

constructor(productId:string,brand:string,description:string,qty:number,price:number){
    this.productId=productId;
    this.brand=brand;
    this.description=description;
    this.qty=qty;
    this.price=price;
}
}