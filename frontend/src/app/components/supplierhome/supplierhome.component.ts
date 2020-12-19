import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-supplierhome',
  templateUrl: './supplierhome.component.html',
  styleUrls: ['./supplierhome.component.css']
})
export class SupplierHomeComponent implements OnInit {

  categories = [];

  constructor(private usersService: UserService) { }

  ngOnInit() {

  }
}