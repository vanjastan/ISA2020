import { Component, OnInit } from '@angular/core';
import { PharmaciesFreeDermComponent } from './pharmacies-free-derm/pharmacies-free-derm.component';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-schedule-consultations',
  templateUrl: './schedule-consultations.component.html',
  styleUrls: ['./schedule-consultations.component.css']
})

export class ScheduleConsultationsComponent implements OnInit {

  date: string;
  time: string;

  constructor(private toastr: ToastrService, public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  submit(){
    let dialogRef = this.dialog.open(PharmaciesFreeDermComponent, {
      width: '1080px',
      data: { }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

}
