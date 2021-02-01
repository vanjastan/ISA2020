import { Component, OnInit, Inject } from '@angular/core';
import { ActionsAndPromotions } from 'src/app/components/models/actions';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { ActionService } from 'src/app/services/action.service';


@Component({
  selector: 'app-add-actions-and-promotions',
  templateUrl: './add-actions-and-promotions.component.html',
  styleUrls: ['./add-actions-and-promotions.component.css']
})
export class AddActionsAndPromotionsComponent implements OnInit {

  actions= new ActionsAndPromotions(null, null);
  date_of_complaint:string;
  content:string;

  constructor(public dialogRef: MatDialogRef<AddActionsAndPromotionsComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private service: ActionService,
      private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  cancelAP(){
    this.dialogRef.close();
  }

  saveAP(){
   this.service.saveActions(this.actions).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully added!', '');
    }, error => {
      console.log(error);
    });
  }
}
