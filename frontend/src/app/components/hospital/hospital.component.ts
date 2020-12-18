import { Component, OnInit } from '@angular/core';
import { Hospital } from './hospital';
import { HospitalService } from 'src/app/services/hospital.service';

@Component({
  selector: 'app-hospital',
  templateUrl: './hospital.component.html',
  styleUrls: ['./hospital.component.css']
})
export class HospitalComponent implements OnInit {

  hosp = new Hospital(null,null,null);

  constructor(private hospitalService: HospitalService) { }

  ngOnInit(): void {
  }

  onSubmitHospital(){ 
    console.log(this.hosp)
    this.hospitalService.addHospital(this.hosp).subscribe(data => {
      console.log('Success!', JSON.stringify(data))
    }, error => {
      console.log('Error');
    });
  }

}