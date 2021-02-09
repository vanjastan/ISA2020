import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Pharmacist } from 'src/app/components/models/pharmacist';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-allpharmaciest',
  templateUrl: './allpharmaciest.component.html',
  styleUrls: ['./allpharmaciest.component.css']
})
export class AllpharmaciestComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['name', 'surname', 'rate', 'choose'];
  search: string;
  Pharmacist: Pharmacist[];
  PharmacistResult: Pharmacist[];

  dataSource = new MatTableDataSource<Pharmacist>();
  @ViewChild(MatSort) sort: MatSort;
  constructor(private service: ExaminationsService, private toastr: ToastrService, private pharmacyService: PharmaciesService) { }

  ngOnInit(): void {
    this.getFreePharmaciests();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Pharmacist;
    }else{
        this.PharmacistResult = this.Pharmacist.filter( result =>
          { 
            return result.rate.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.PharmacistResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    choose(id:number){
      this.service.scheduleConsultation(id).subscribe(data => {
        console.log(data);
        this.toastr.success('Successfully scheduled!', '');
      }, 
      error => {
        console.log(error);
      })
    }

    getFreePharmaciests(){
      this.pharmacyService.getFreePharmaciest().subscribe(data => {
        this.Pharmacist = data;
        this.dataSource.data = data;
        console.log(this.Pharmacist);
      },
      error => {
       console.log(error);
      });
    }
}
