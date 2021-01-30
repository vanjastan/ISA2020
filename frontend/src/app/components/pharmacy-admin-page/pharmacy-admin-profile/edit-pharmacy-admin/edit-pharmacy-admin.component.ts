import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/components/models/user';

@Component({
  selector: 'app-edit-pharmacy-admin',
  templateUrl: './edit-pharmacy-admin.component.html',
  styleUrls: ['./edit-pharmacy-admin.component.css']
})
export class EditPharmacyAdminComponent implements OnInit {

  categories = [];
  user: User = new User("","","","","","","","","");

  constructor(public dialogRef: MatDialogRef<EditPharmacyAdminComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService, private userService: UserService) { }

  ngOnInit(): void {
  }


}
