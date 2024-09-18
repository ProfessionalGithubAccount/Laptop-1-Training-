import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OwnextracompoComponent } from './ownextracompo/ownextracompo.component';
import { FormControl, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root-kausthub-tryown',
  standalone: true,
  imports: [RouterOutlet,OwnextracompoComponent,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'myapp1';
}
