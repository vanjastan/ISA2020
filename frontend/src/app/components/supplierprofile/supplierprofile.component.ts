import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-supplierprofile',
  templateUrl: './supplierprofile.component.html',
  styleUrls: ['./supplierprofile.component.css']
})
export class SupplierProfileComponent implements OnInit {

  categories = [];

  constructor(private usersService: UserService) { }

  ngOnInit() {

  }
}