import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-graphics',
  templateUrl: './graphics.component.html',
  styleUrls: ['./graphics.component.css']
})
export class GraphicsComponent implements OnInit {

  title = 'dashboard';
  chart;
  chart2 = [];
  pie: any;
  doughnut: any;

  data1 = [];
  constructor() { }

  ngOnInit(): void {

    this.chart = new Chart('bar', {
      type: 'bar',
      options: {
        responsive: true,
        title: {
          display: true,
          text: 'Combo Bar and line Chart'
        },
      },
      data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [
          {
            type: 'bar',
            label: 'Examinations held',
            data: [243, 156, 365, 30, 156, 265, 356, 543, 255, 144, 165, 123],
            backgroundColor: 'rgba(255,0,255,0.4)',
            borderColor: 'rgba(255,0,255,0.4)',
            fill: false,
          },
          {
            type: 'bar',
            label: 'Medicament consumption',
            data: [243, 156, 365, 30, 156, 265, 356, 543, 244, 314, 144, 157].reverse(),
            backgroundColor: 'rgba(0,0,255,0.4)',
            borderColor: 'rgba(0,0,255,0.4)',
            fill: false,
          },
          {
            type: 'bar',
            label: 'Pharmacy revenue',
            data: [853, 556, 665, 350, 756, 565, 856, 443, 778, 458, 715, 851].reverse(),
            backgroundColor: 'rgba(0,255,0,0.4)',
            borderColor: 'rgba(0,255,0,0.4)',
            fill: false,
          }
        ]
      }
    });
  }

}
