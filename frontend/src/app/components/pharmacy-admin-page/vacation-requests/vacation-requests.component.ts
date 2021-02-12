import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Vacation } from '../../models/vacation';

@Component({
  selector: 'app-vacation-requests',
  templateUrl: './vacation-requests.component.html',
  styleUrls: ['./vacation-requests.component.css']
})
export class VacationRequestsComponent implements OnInit, AfterViewInit {


  Vacations: Vacation[];
  VacationsResults: Vacation[];

  v = new Vacation( null, null, false);

  id:number;
  from_date: string;
  to_date: string;
  confirmation: boolean;

  search: string;

  displayedColumns: string[] = [ 'from_date', 'to_date','confirm', 'refuse'];
  dataSource = new MatTableDataSource<Vacation>();
  @ViewChild(MatSort) sort:MatSort;


  constructor(private service: PharmaciesService, private http: HttpClient, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getVacations();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getVacations(){
    this.service.getVacations().subscribe(data => {
      this.Vacations = data;
      this.dataSource.data = data;
    }, 
    error =>{
      console.log("ERROR");
    });
  }

  refuse(id:number){
    this.service.refuseVacation(id).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully refused!', '');
    }, error => {
      console.log(error);
    });
  }

  confirm(id:number){
    this.service.confirmVacation(id).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully confirmed!', '');
    }, error => {
      console.log(error);
    });
  }
  
  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Vacations;
    }else{
        this.VacationsResults = this.Vacations.filter( result =>
          { 
            return result.from_date.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.to_date.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.VacationsResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

}
