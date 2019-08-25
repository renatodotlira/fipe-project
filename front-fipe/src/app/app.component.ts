import { Component, OnInit } from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormControl, FormGroup, ReactiveFormsModule, FormsModule} from '@angular/forms';
import {NgSelectModule, NgOption} from '@ng-select/ng-select';
import { BrandService } from './brand.service';
import { VehicleService } from './vehicle.service';
import { Brand } from './models/brand.model';

@Component({
  selector: 'fp-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  title = 'Fipe';

  selecao = "Selecione uma marca";

  selectedBrand: any;

  selectedVehicle: any;

  brands : any[];

  vehicles : any[];

  sentences : string[];

  constructor(private brandService: BrandService, private vehicleService: VehicleService) {

  }

  ngOnInit() {
    this.brandService.getBrands()
      .subscribe( data => {
        this.brands = data;
      });
  };  

  filterModels(brand: Brand): void {
    this.selectedVehicle = null;
    this.sentences = null;
    this.selecao = "Agora selecione um modelo";
    this.vehicleService.getVehicles(brand)
      .subscribe( data => {
        this.vehicles = data;
      })
  };

  getSentences(): void {    
    this.vehicleService.getSentences(this.selectedBrand, this.selectedVehicle)
      .subscribe( data => {
        this.sentences = data;
      })
  };

}
