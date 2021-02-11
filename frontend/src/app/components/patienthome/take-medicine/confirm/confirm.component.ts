import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Medicine } from 'src/app/components/models/medicine';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { MedsService } from 'src/app/services/meds.service';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { ToastrService } from 'ngx-toastr';
import { MedicineReservation } from 'src/app/components/models/medicineReservation';

@Component({
  selector: 'app-confirm',
  templateUrl: './confirm.component.html',
  styleUrls: ['./confirm.component.css']
})
export class ConfirmComponent implements OnInit {

  selectedPharmacy: Pharmacies = new Pharmacies("", "", "", "", "");
  //medicine: Medicine = new Medicine();
  medicine = new Medicine();
  reservation = new MedicineReservation();
  pharmacy:Pharmacies[];
  date: string;
  id:number;

  constructor(public dialogRef: MatDialogRef<ConfirmComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private service: MedsService, 
    private servicePh: PharmaciesService, private toastr: ToastrService) {
      this.medicine = data.Medicine;
      this.id = data.id;

      servicePh.getPharmaciesByMedicineId(this.id).subscribe(data =>{
        this.pharmacy = data;
         console.log(this.pharmacy);
      })
     }

  ngOnInit(): void {
  }

  submit(){
    console.log(this.id);
    this.service.reserveMed(this.reservation, this.id).subscribe(data =>{
      console.log(data);
      console.log(this.reservation);
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
