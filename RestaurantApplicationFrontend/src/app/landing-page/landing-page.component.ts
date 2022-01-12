import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private router: Router,
              private authService: AuthenticationService) {

    // if (localStorage.getItem('currentAccount'))
    // {
    //   this.router.navigateByUrl('/');
    // }
  }

  ngOnInit(): void {
  }

  get isManager() {
    if (this.authService.isManager)
    {
      return true;
    }
    return false;
  }

  get isEmployee() {
    if (this.authService.isEmployee)
    {
      return true;
    }
    return false;
  }
}
