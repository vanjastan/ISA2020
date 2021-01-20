import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { EditprofileComponent } from './editprofile/editprofile.component';

@Component({
  selector: 'app-patientprofile',
  templateUrl: './patientprofile.component.html',
  styleUrls: ['./patientprofile.component.css']
})
export class PatientprofileComponent implements OnInit {

  categories = [];
  user: User = new User("","","","","","","","","");
  constructor(private userService: UserService, private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getPatientInfo();
  }

  getPatientInfo(){
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error in getting user data!")
    });
  }

  edit() {
    const dialogRef = this.dialog.open(EditprofileComponent, {
      data: {  }
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }
}
