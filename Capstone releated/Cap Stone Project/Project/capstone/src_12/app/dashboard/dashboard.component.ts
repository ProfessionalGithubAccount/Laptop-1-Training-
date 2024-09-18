import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
 
import { CanvasJSAngularChartsModule } from '@canvasjs/angular-charts';
 
@Component({
  selector: 'app-dashboard',
  standalone: true,
    imports: [
      CommonModule,
      RouterOutlet,
      CanvasJSAngularChartsModule
    ],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent { 
 
  constructor() { }
  ngOnInit(): void {
    setTimeout(() => {
      const creditLink = document.querySelector('a[href="https://canvasjs.com/"]') as HTMLElement;
      if (creditLink) {
        creditLink.style.display = 'none';
      }
    }, 0.1); // Delay to ensure the chart is fully loaded
  }

  chartOptions = {
    title: {
      text: "Course-1 Report"
    },
    data: [{
      type: "column",
      dataPoints: [
        { label: "Assignment-1",  y: 10  },
        { label: "Assignment-2", y: 15  },
        { label: "Assignment-3", y: 25  },
        { label: "Assignment-4",  y: 30  },
        { label: "Assignment-5",  y: 28  }
      ]
    }]                
  };

  
}// import { Component } from '@angular/core';
// import { CommonModule } from '@angular/common';
// import { RouterOutlet } from '@angular/router';
 
// import { CanvasJSAngularChartsModule } from '@canvasjs/angular-charts';
 
// @Component({
//   selector: 'app-root',
//   standalone: true,
//   imports: [CommonModule, RouterOutlet, CanvasJSAngularChartsModule],
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   chartOptions = {
//     title:{
//       text: "Angular Column Chart"  
//     },
//     animationEnabled: true,
//     data: [{        
//       type: "column",
//       dataPoints: [
//         { x: 10, y: 71 },
//         { x: 20, y: 55 },
//         { x: 30, y: 50 },
//         { x: 40, y: 65 },
//         { x: 50, y: 95 },
//         { x: 60, y: 68 },
//         { x: 70, y: 28 },
//         { x: 80, y: 34 },
//         { x: 90, y: 14 }
//       ]
//     }]
//   }	
// }   