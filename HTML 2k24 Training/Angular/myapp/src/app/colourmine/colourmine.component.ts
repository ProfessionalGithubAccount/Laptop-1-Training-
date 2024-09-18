import { AfterContentInit, Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-colourmine',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet],
  templateUrl: './colourmine.component.html',
  styleUrl: './colourmine.component.css'
})
export class ColourmineComponent implements OnChanges,OnInit,DoCheck,AfterContentInit{
  @Input()
  title: string="Hello";
 
  constructor(){
    console.log("constructor() is called.......From Child");
  }
  ngAfterContentChecked(): void {
    console.log("ngAfterContentChecked() is called....... From Child");
}
  ngAfterContentInit():void{
    console.log("ngAfterContentInit() is called.........From Child");
  }
  ngDoCheck():void{
    console.log("ngDoCheck() is called.........From Child");
  }
  ngOnChanges(changes: SimpleChanges): void{
    console.log("ngOnChanges() is called........From Child");
  }
  ngOnInit(): void{
    console.log("ngOnInit() is called........From Child");
  }
  keyCapture(event: string){
    this.title=event
  }
  sendMessage(): void{
    console.log("Click event fired........From Child")
  }

  // title:string="hello";
  // constructor(){
  //   console.log('Constructor() is called...')
  // }
  // ngAfterContentInit(): void {
  //   console.log("ngAfterContent form ....child component")
  // }
  // ngDoCheck():void{
  //   console.log("ngDoCheck() is called from ..child component");
  // }
  // ngOnChanges(changes: SimpleChanges): void {
  //   throw new Error('ngOnChanges is called.....child component');
  // }
  // ngOnInit(): void {
  //   console.log('ngInit() is called....child component')
  // }

  // ----------------------------------------------above was written o 21/08/24 to explain life cycle hooks
  bgcolormine="background-color:black"
  colurchange():void{
    alert("helllo");
    this.bgcolormine="background-color:red";

    
  }

}

