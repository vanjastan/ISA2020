import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-suppliertender',
  templateUrl: './suppliertender.component.html',
  styleUrls: ['./suppliertender.component.css']
})
export class SupplierTenderComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name'];

  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder, private authService: AuthService) { }

  ngOnInit() {
  }
}