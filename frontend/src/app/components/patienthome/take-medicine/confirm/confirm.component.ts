import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Medicine } from 'src/app/components/models/medicine';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { MedsService } from 'src/app/services/meds.service';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  selectedPharmacy: Pharmacies = new Pharmacies("", "", "", "", "");
  medicine: Medicine = new Medicine();
  pharmacy:Pharmacies[];
  date: string;

  constructor(public dialogRef: MatDialogRef<ConfirmComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private service: MedsService, 
    private servicePh: PharmaciesService, private toastr: ToastrService) {

    this.pharmacy = data.pharmacy;

      servicePh.getPharmaciesByMedicineId(this.medicine.id).subscribe(data =>{
        this.pharmacy = data;
         console.log(this.pharmacy);
      })
     }

  ngOnInit(): void {
  }

  submit(){
    this.service.reserveMed(this.medicine.id).subscribe(data =>{
      this.medicine = data;
      this.toastr.success('Successfully reserved medicine!', '');
      this.dialogRef.close();
    }, 
     error => {
        console.log(error);
    });
  }

  cancel(){
    this.dialogRef.close();
  }

}
