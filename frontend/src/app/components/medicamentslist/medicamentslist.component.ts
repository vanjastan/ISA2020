import { Component, OnInit } from '@angular/core';
import { MedsService } from 'src/app/services/meds.service';
import { Meds } from './meds';

@Component({
  selector: 'app-medicamentslist',
  templateUrl: './medicamentslist.component.html',
  styleUrls: ['./medicaments.component.css']
})
export class MedicamentsListComponent implements OnInit {

  meds = new Meds(null,null,null,null,null,null,null,null,null,null,null,null,null,null);

  categories = [];

  constructor(private medsService: MedsService) { }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll(): void {
    this.medsService.getAllMeds().subscribe(data => {
      this.categories = data;
      console.log("Meds: ",this.categories)
    }, error => {
      console.log('Error');
    });
  }

  onSubmitMeds(){ 
    console.log(this.meds)
    this.medsService.addMeds(this.meds).subscribe(data => {
      console.log('Success!', JSON.stringify(data))
    }, error => {
      console.log('Error');
    });
  }
}