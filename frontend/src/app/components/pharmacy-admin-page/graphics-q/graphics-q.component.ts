import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';


@Component({
  selector: 'app-graphics-q',
  templateUrl: './graphics-q.component.html',
  styleUrls: ['./graphics-q.component.css']
})
export class GraphicsQComponent implements OnInit {

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
        labels: ['1', '2', '3', '4'],
        datasets: [
          {
            type: 'bar',
            label: 'Examinations held',
            data: [92, 54, 68, 102],
            backgroundColor: 'rgba(255,0,255,0.4)',
            borderColor: 'rgba(255,0,255,0.4)',
            fill: false,
          },
          {
            type: 'bar',
            label: 'Medicament consumption',
            data: [43, 66, 75, 30].reverse(),
            backgroundColor: 'rgba(0,0,255,0.4)',
            borderColor: 'rgba(0,0,255,0.4)',
            fill: false,
          },
          {
            type: 'bar',
            label: 'Pharmacy revenue',
            data: [203, 198, 215, 180].reverse(),
            backgroundColor: 'rgba(0,255,0,0.4)',
            borderColor: 'rgba(0,255,0,0.4)',
            fill: false,
          }
        ]
      }
    });
  }

}
