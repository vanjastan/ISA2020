import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Medicine } from '../../models/medicine';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { MedsService } from 'src/app/services/meds.service';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmComponent } from './confirm/confirm.component';

@Component({
  selector: 'app-take-medicine',
  templateUrl: './take-medicine.component.html',
  styleUrls: ['./take-medicine.component.css']
})
export class TakeMedicineComponent implements OnInit, AfterViewInit {

  search:string;
  Medicine:Medicine[];
  MedicineResult:Medicine[];
  name:string;
  ingredients:string;
  shape:string;
  type:string;
  displayedColumns: string[] = ['name', 'ingredients', 'shape', 'type', 'reserve'];
  dataSource = new MatTableDataSource<Medicine>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private toastr: ToastrService, private service: MedsService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllMeds();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllMeds(){
    this.service.getAllMeds().subscribe(data => {
      this.Medicine = data;
      this.dataSource.data = data;
      console.log(this.Medicine);
    },
    error => {
     console.log(error);
    });
  }
  
  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Medicine;
    }else{
        this.MedicineResult = this.Medicine.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.MedicineResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

  reserve(){
    let dialogRef = this.dialog.open(ConfirmComponent, {
      width: '1060px',
      data: { }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }
}
