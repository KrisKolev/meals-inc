import { Component, OnInit } from '@angular/core';
import {LoginPageService} from "./login-page.service";
import axios from "axios";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor() {
    employeeUsername: "";
    employeePassword: "";
  }

  ngOnInit(): void {
  }



  getLogin(employeeUsername: string, employeePassword: string) {
    axios.post(
      'http://localhost:8080/employees',
      {
        employeeUsername: employeeUsername,
        employeePassword: employeePassword,
      },
      { headers: { 'Access-Control-Allow-Origin': '*' } }
    ).then((res) => {
      alert(res.data);
    })
  }



}
