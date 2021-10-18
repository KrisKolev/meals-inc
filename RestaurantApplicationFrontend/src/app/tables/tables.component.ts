import { Component, OnInit } from '@angular/core';
import { TablesService } from './tables.service';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {

  title = "Tables";

  tables: any;

  constructor(service: TablesService) {
    this.tables = service.getTables().subscribe((res) => {
      this.tables = res;
    })
   }

  ngOnInit(): void {
  }

}
