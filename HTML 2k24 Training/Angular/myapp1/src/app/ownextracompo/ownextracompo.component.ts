import { Component } from '@angular/core';
// OwnextracompoComponent
@Component({
  selector: 'app-ownextracompo',
  standalone: true,
  imports: [OwnextracompoComponent],
  templateUrl: './ownextracompo.component.html',
  styleUrl: './ownextracompo.component.css'
})
export class OwnextracompoComponent {
  temp="background-color:aqua"
blue():void{
  // alert("Blue");
  this.temp="background-color:blue";
}
white():void{
  // alert("White");
  this.temp="background-color:white";
}
}
