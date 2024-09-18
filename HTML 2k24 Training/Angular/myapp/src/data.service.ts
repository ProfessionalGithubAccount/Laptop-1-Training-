import { Injectable } from '@angular/core';
import { Product } from './Product';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  getProducts(): Product[] {
    return this.products; 
  }

  products:Product[]=[];
  
// Creating dummy data
  constructor() {
    this.products[0]=new Product("s108","Tata","Dish",10,2500);
    this.products[1]=new Product("k109","Wipro","Bulbs",210,300);
    this.products[2]=new Product("t101","TVS","Belts",210,5500);
    this.products[3]=new Product("q102","Reliance","DishTv",50,4500);
    this.products[4]=new Product("w103","Actfiber","router",60,1400);
    this.products[5]=new Product("e104","Samsung","smart tv",50,72500);
    this.products[6]=new Product("r105","LG","AC",20,52500);
    this.products[7]=new Product("y106","Crompton","fan",25,1500);
    this.products[8]=new Product("u107","One+","mobile",5,50500);

this.products[9] = new Product("s108", "Tata", "Salt", 100, 20);
this.products[10] = new Product("s109", "Tata", "Water Bottle", 200, 15);
this.products[11] = new Product("s110", "Tata", "Tea", 150, 250);
this.products[12] = new Product("w111", "Wipro", "LED Bulbs", 300, 150);
this.products[13] = new Product("w112", "Wipro", "Smart Plug", 100, 1200);
this.products[14] = new Product("w113", "Wipro", "Air Purifier", 50, 8000);
this.products[15] = new Product("t114", "TVS", "Scooter", 20, 60000);
this.products[16] = new Product("t115", "TVS", "Motorcycle", 15, 90000);
this.products[17] = new Product("t116", "TVS", "Electric Bike", 10, 120000);

this.products[18] = new Product("s117", "Tata", "Coffee", 80, 300);
this.products[19] = new Product("s118", "Tata", "Rice", 120, 60);
this.products[20] = new Product("w119", "Wipro", "Smart Bulb", 200, 500);
this.products[21] = new Product("w120", "Wipro", "Security Camera", 50, 4500);
this.products[22] = new Product("t121", "TVS", "Helmet", 100, 1500);
this.products[23] = new Product("t122", "TVS", "Bike Cover", 150, 800);
this.products[24] = new Product("t123", "TVS", "Engine Oil", 200, 400);



  }
}
