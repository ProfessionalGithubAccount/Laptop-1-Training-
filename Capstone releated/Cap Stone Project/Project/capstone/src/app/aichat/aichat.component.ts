import { Component } from '@angular/core';
import { OpenaiService } from '../openai.service';

@Component({
  selector: 'app-aichat',
  templateUrl: './aichat.component.html',
  styleUrls: ['./aichat.component.css']
})
export class AichatComponent {
  prompt: string = '';
  response: string = '';

  constructor(private openaiService: OpenaiService) { }
  
  sendPrompt() {
    this.openaiService.getOpenAIResponse(this.prompt).subscribe({
      next: (data) => {
        this.response = data;
      },
      error: (error) => {
        console.error('Error fetching OpenAI response', error);
      }
    });
  }
}
