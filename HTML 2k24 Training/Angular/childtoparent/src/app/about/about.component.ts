import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent {
@Output()
public setItem=new EventEmitter<string>();
  item="";

  pushItem(){
    this.setItem.emit(this.item);
    this.item="";
  }
}
