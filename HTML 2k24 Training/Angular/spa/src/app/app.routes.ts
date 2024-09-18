import {  Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { RegisterComponent } from './register/register.component';






export const routes: Routes = [
    {path:'home',component:HomeComponent},
    {path:'aboutus',component:AboutusComponent},
    {path:'register',component:RegisterComponent}
];
// export class AppRoutingModule{}
