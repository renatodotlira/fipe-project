import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vehicle } from './models/vehicle.model';
import { Brand } from './models/brand.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class VehicleService {

  constructor(private http:HttpClient) {}

  //private brandUrl = '/api';
  private brandUrl = 'http://localhost:8282/'

  public getVehicles(brand : Brand) {
    return this.http.get<Vehicle[]>(this.brandUrl + "vehicle/brands/"+brand.id);
  }

  public getSentences(brand : Brand, vehicle : Vehicle) {
    return this.http.get<string[]>(
      this.brandUrl + "vehicle/depreciations/brands/"+brand.id+"/models/"+vehicle.id);
  }


}
