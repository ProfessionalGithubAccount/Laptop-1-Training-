import { Component,Input } from '@angular/core';
import { AboutComponent } from '../about/about.component';
// Must add "input" above line

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [AboutComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
@Input("someName") parentData1!:string;
@Input() parentData2!:string;
@Input() parentData3!:string;
// ! exclamation ignores null
}
