import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Medicine } from '../../models/medicine';

@Component({
  selector: 'app-alergies',
  templateUrl: './alergies.component.html',
  styleUrls: ['./alergies.component.css']
})
export class AlergiesComponent implements OnInit {

  Medicine: Medicine[];
  MedicineResults: Medicine[];
  search: string;
  name: string;
  displayedColumns: string[] = ['name', 'choose'];
  dataSource = new MatTableDataSource<Medicine>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(public dialogRef: MatDialogRef<AlergiesComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  closeD(): void{
    this.dialogRef.close();
    this.toastr.success("Successfully closed!", '');
  }

  save(){

  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Medicine;
    }else{
        this.MedicineResults = this.Medicine.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.MedicineResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    chooseMed(){
      
    }
}
