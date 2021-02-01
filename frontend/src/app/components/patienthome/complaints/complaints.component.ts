import { Component, OnInit } from '@angular/core';
import { ShowcomplaintsComponent } from './showcomplaints/showcomplaints.component';
import { MatDialog } from '@angular/material/dialog';
import { AddcomplaintComponent } from './addcomplaint/addcomplaint.component';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {
  
  constructor(public dialog: MatDialog,) { }

  ngOnInit(): void {
  }

  showAll(): void{
    let dialogRef = this.dialog.open(ShowcomplaintsComponent, {
      width: '1050px'
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  writeCompl(): void{
    let dialogRef = this.dialog.open(AddcomplaintComponent, {
      width: '1050px'
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }
}
