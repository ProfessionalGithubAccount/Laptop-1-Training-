import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { OTest } from './ObservableTest';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FormsModule,HomeComponent,AboutComponent],
  // teh above forms module ...helps in using the ng model isnide the forms 
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'parenttochild';

  EnterName="John Doe";
  EnterAge="22";
  EnterStatus="Single";
  parentData1="";
  parentData2="";
  parentData3="";

  transferData(){
    this.parentData1=this.EnterName;
    this.parentData2=this.EnterAge;
    this.parentData3=this.EnterStatus;

  }
  o:OTest = new OTest();
  run(){
    let a:Observable<Object> = this.o.createObservable()
    this.o.subscribeToObservable(a)
  }
  value="";
  sendData(value:any){
    this.value=value;
  }

}
