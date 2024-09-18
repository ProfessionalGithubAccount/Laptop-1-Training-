import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { ColourmineComponent } from './app/colourmine/colourmine.component';


bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

// bootstrapApplication(ColourmineComponent, appConfig)
//   .catch((err) => console.error(err));
//the above code is to show the colourmine component as the main component ...we even need to import the colourmine component here also 

