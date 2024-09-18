import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  standalone: true,
  imports: [],
  templateUrl: './child.component.html',
  styleUrl: './child.component.css'
})
export class ChildComponent {
  childItem:string | undefined;
  @Output() childEvent = new EventEmitter<string>();

  addChildEvent(){
    this.childEvent.emit(this.childItem);
    this.childItem="";
  }

}
