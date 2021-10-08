import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { EmployeesComponent } from './employees/employees.component';
import { ProductsComponent } from './products/products.component';

import { EmployeesService } from './employees/employees.service';
import { ProductsService } from './products/products.service';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    ProductsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    EmployeesService,
    ProductsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
