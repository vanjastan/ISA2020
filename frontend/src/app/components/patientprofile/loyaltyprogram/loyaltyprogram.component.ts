import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-loyaltyprogram',
  templateUrl: './loyaltyprogram.component.html',
  styleUrls: ['./loyaltyprogram.component.css']
})
export class LoyaltyprogramComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<LoyaltyprogramComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

}
