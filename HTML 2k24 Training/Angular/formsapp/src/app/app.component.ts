import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Login } from '../../login';
import { CommonModule } from '@angular/common';
import { Signup } from '../../Signup';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FormsModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
login:Login =new Login("","");
signup:Signup=new Signup("","","")

  title = 'formsapp';
}
