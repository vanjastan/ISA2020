import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';


@Component({
  selector: 'app-graphics-m',
  templateUrl: './graphics-m.component.html',
  styleUrls: ['./graphics-m.component.css']
})
export class GraphicsMComponent implements OnInit {

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
        labels: ['1', '2', '3', '4', '5', '6', '7', '8','9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'],
        datasets: [
          {
            type: 'bar',
            label: 'Examinations held',
            data: [5,8,9,4,7,14,12,9,9,12,11,10,14,15,6,10,8,9,7,6,14,12,10,10,11,14,9,9,9,2,7,8],
            backgroundColor: 'rgba(255,0,255,0.4)',
            borderColor: 'rgba(255,0,255,0.4)',
            fill: false,
          },
          {
            type: 'bar',
            label: 'Medicament consumption',
            data: [5,12,14,15,14,13,10,12,14,15,14,1,5,7,19,15,14,16,14,20,14,21,14,14,15,17,18,19,17,9,10].reverse(),
            backgroundColor: 'rgba(0,0,255,0.4)',
            borderColor: 'rgba(0,0,255,0.4)',
            fill: false,
          },
          {
            type: 'bar',
            label: 'Pharmacy revenue',
            data: [20,14,25,32,35,31,51,45,40,56,14,15,14,14,15,14,19,17,15,20,28,29,26,32,38,36,24,21,26,27,30].reverse(),
            backgroundColor: 'rgba(0,255,0,0.4)',
            borderColor: 'rgba(0,255,0,0.4)',
            fill: false,
          }
        ]
      }
    });
  }

}

