package com.example.tabelafipe.service.impl;

import com.example.tabelafipe.client.FipeClient;
import com.example.tabelafipe.dto.VehicleDto;
import com.example.tabelafipe.model.SetValueVehicleAnnual;
import com.example.tabelafipe.model.Vehicle;
import com.example.tabelafipe.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private FipeClient fipeClient;

    @Override
    public List<VehicleDto> listByBrand(Long idBrand) {
        List<Vehicle> vehicles = fipeClient.listAllVehicles(idBrand);
        return toDtoList(vehicles);
    }

    @Override
    public List<String> ListDepretiations(Long idBrand, Long idModel) {
        List<Vehicle> vehicles;
        vehicles = fipeClient.listAllVehiclesByModel(idBrand, idModel);
        SetValueVehicleAnnual valueVehicleAnnual = new SetValueVehicleAnnual();
        for (Vehicle detail : vehicles) {
            detail = fipeClient.getDetailVehicle(idBrand, idModel, detail.getKey());
            valueVehicleAnnual.add(detail);
        }
        return valueVehicleAnnual.getValueVehicleAnnualDtos();
    }

    private List<VehicleDto> toDtoList(List<Vehicle> vehicles){
        ModelMapper modelMapper = new ModelMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        vehicles.forEach(vehicle -> vehicleDtos.add(modelMapper.map(vehicle, VehicleDto.class)));
        return vehicleDtos;
    }

}