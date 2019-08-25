import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrandService} from './brand.service';
import {VehicleService} from './vehicle.service';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import { NgSelectModule } from '@ng-select/ng-select';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgSelectModule,
    AppRoutingModule
  ],
  providers: [BrandService, VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
