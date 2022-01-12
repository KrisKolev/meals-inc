import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {AuthenticationService} from "../service/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  constructor(public dialog: MatDialog, private router: Router, private authService: AuthenticationService) {

    if (!localStorage.getItem('currentEmployee'))
    {
      this.router.navigateByUrl('');
    }
  }

  openThisDialog() {
    this.dialog.open(InfoDialogComponent);
  }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
  }
}
