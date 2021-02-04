import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Medicine } from '../../models/medicine';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { MedsService } from 'src/app/services/meds.service';

@Component({
  selector: 'app-reserved-meds',
  templateUrl: './reserved-meds.component.html',
  styleUrls: ['./reserved-meds.component.css']
})
export class ReservedMedsComponent implements OnInit, AfterViewInit {

  Medicine: Medicine[];
  MedicineResult: Medicine[];
  name:string;
  shape:string;
  type:string;
  ingredients:string;
  search: string;
  cancel:string;
  displayedColumns: string[] = ['name', 'ingredients', 'shape', 'type', 'cancel'];

  dataSource = new MatTableDataSource<Medicine>();
  @ViewChild(MatSort) sort: MatSort
  constructor(private service: MedsService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getReservedMedicine();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getReservedMedicine(){
    this.service.getResMedicines().subscribe(data => {
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

    cancelMed(id:number){
      console.log(id);
      this.service.cancelMed(id).subscribe(data => {
        console.log(data);
        this.toastr.success('Successfully canceled!', '');
      }, 
      error => {
        console.log(error);
      })
    }
}
