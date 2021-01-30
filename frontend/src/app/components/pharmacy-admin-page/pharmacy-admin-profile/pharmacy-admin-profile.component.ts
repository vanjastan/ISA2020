import { Component, OnInit, Inject } from '@angular/core';
import { User } from 'src/app/components/models/user';
import { UserService } from 'src/app/services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { EditPharmacyAdminComponent } from 'src/app/components/pharmacy-admin-page/pharmacy-admin-profile/edit-pharmacy-admin/edit-pharmacy-admin.component';

@Component({
  selector: 'app-pharmacy-admin-profile',
  templateUrl: './pharmacy-admin-profile.component.html',
  styleUrls: ['./pharmacy-admin-profile.component.css']
})
export class PharmacyAdminProfileComponent implements OnInit {

  categories = [];
  user: User = new User("","","","","","","","","");
  constructor(private userService: UserService, private router: Router, public dialog: MatDialog,
    public dialogPass: MatDialog) { }

  ngOnInit(): void {
    this.getAdminPHInfo();
  }

  getAdminPHInfo(){
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error in getting pharmacy admin data!")
    });
  }

  editAdminPH() : void{
    let dialogRef = this.dialog.open(EditPharmacyAdminComponent, {
      width: '650px',
      data: { name: '' }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }
}
