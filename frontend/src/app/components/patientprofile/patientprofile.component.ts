import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { EditpassComponent } from './editpass/editpass.component';
import { Patient } from '../models/patient';

@Component({
  selector: 'app-patientprofile',
  templateUrl: './patientprofile.component.html',
  styleUrls: ['./patientprofile.component.css']
})
export class PatientprofileComponent implements OnInit {

  categories = [];
  user: Patient;
  constructor(private userService: UserService, private router: Router, public dialog: MatDialog,
    public dialogPass: MatDialog) { }

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

  edit() : void{
    let dialogRef = this.dialog.open(EditprofileComponent, {
      width: '650px',
      data: { name: 'JEKA' }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  changePass(id: number, name: string, surname: string, username: string,
    email: string, password: string, address: string, city: string, country: string, number: string) : void{
    let dialogRef = this.dialog.open(EditpassComponent, {
      width: '650px',
      data: { id: id, password: password, name: name, surname: surname, 
        username: username, address: address, city: city, country: country,
        number: number, email: email }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  allergies(){
      
  }

  points(){

  }

  category(){

  }

  loyalty(){
    
  }
}
