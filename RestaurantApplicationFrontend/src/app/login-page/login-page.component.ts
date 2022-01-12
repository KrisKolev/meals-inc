import { Component, OnInit } from '@angular/core';
import {LoginPageService} from "./login-page.service";
import axios from "axios";
import {FormControl, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  returnUrl: string;
  hidePassword = true;
  employeeUsername = new FormControl('', [Validators.required]);
  employeePassword = new FormControl('', [Validators.required]);

  constructor(private loginPageService: LoginPageService,
              private route: ActivatedRoute,
              private router: Router,
              private authService: AuthenticationService) {

    if (localStorage.getItem('currentEmployee'))
    {
      this.router.navigateByUrl('/landing');
    }
  }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  loginCheck() {
    let employeeUsername: string = this.employeeUsername.value;
    let employeePassword: string = this.employeePassword.value;
    var accountID = -1;

    this.authService.login(employeeUsername,employeePassword);
  }

  // getLogin(employeeUsername: string, employeePassword: string) {
  //   axios.post(
  //     'http://localhost:8080/employees',
  //     {
  //       employeeUsername: employeeUsername,
  //       employeePassword: employeePassword,
  //     },
  //     { headers: { 'Access-Control-Allow-Origin': '*' } }
  //   ).then((res) => {
  //     alert(res.data);
  //   })
  // }
}
