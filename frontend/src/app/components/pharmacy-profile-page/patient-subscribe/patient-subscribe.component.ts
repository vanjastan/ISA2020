import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ActionService } from 'src/app/services/action.service';
import { ActionsAndPromotions } from '../../models/actions';
import { Subscribe } from '../../models/subscribe';

@Component({
  selector: 'app-patient-subscribe',
  templateUrl: './patient-subscribe.component.html',
  styleUrls: ['./patient-subscribe.component.css']
})
export class PatientSubscribeComponent implements OnInit {


  sub = new Subscribe(null);
  email:string;
  
  Actions: ActionsAndPromotions[];
  ActionResult: ActionsAndPromotions[];

  name: string;
  end_date: string;
  

  ac:ActionsAndPromotions;

  search:string;
  displayedColumns: string[] = ['name', 'end_date'];
  dataSource = new MatTableDataSource<ActionsAndPromotions>();
  @ViewChild(MatSort) sort: MatSort;
 

  constructor(private service: ActionService, public dialogMat: MatDialog, private http: HttpClient, private toastr: ToastrService,  private router: Router) { }

  ngOnInit(): void {
    this.getAllActions();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllActions(){
    this.service.getAllActions().subscribe(data =>{
      this.Actions = data;
      this.dataSource.data = data;
      console.log(this.Actions);
    },
    error =>{
      console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Actions;
    }else{
        this.ActionResult = this.Actions.filter( result =>
          { 
            return result.end_date.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.ActionResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  subscribe(){
    this.service.subEmail(this.sub).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully subscribed!', '');
    }, error => {
      console.log(error);
    }); 
  }

}
