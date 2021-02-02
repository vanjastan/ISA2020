import { Component, OnInit, Inject } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { EditPharmacyAdminComponent } from 'src/app/components/pharmacy-admin-page/pharmacy-admin-profile/edit-pharmacy-admin/edit-pharmacy-admin.component';
import { AdminPH } from 'src/app/components/models/adminPH';
import { ChangeAdminphPasswordComponent } from 'src/app/components/pharmacy-admin-page/pharmacy-admin-profile/change-adminph-password/change-adminph-password.component';

@Component({
  selector: 'app-pharmacy-admin-profile',
  templateUrl: './pharmacy-admin-profile.component.html',
  styleUrls: ['./pharmacy-admin-profile.component.css']
})
export class PharmacyAdminProfileComponent implements OnInit {

  categories = [];
  user: AdminPH;
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

  editAdminPH(id: number, name: string, surname: string, username: string,
    address: string, city: string, country: string, number: string) : void{
   let dialogRef = this.dialog.open(EditPharmacyAdminComponent, {
     width: '650px',
     data: { id: id, name: name, surname: surname, 
       username: username, address: address, city: city, country: country,
       number: number }
   });
   dialogRef.afterClosed().subscribe(result => {
     console.log('Dialog result: ${result}');
   });
 }

 changePassword(id: number, name: string, surname: string, username: string,
  email: string, password: string, address: string, city: string, country: string, number: string) : void{
  let dialogRef = this.dialog.open(ChangeAdminphPasswordComponent, {
    width: '650px',
    data: { id: id, password: password, name: name, surname: surname, 
      username: username, address: address, city: city, country: country,
      number: number, email: email }
  });
  dialogRef.afterClosed().subscribe(result => {
    console.log('Dialog result: ${result}');
  });
 }
}
