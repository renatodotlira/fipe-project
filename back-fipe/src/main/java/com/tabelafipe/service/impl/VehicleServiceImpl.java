package com.tabelafipe.service.impl;

import com.tabelafipe.dto.VehicleDto;
import com.tabelafipe.model.SetValueVehicleAnnual;
import com.tabelafipe.model.Vehicle;
import com.tabelafipe.client.FipeClient;
import com.tabelafipe.service.VehicleService;
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
    public List<String> listDepretiations(Long idBrand, Long idModel) {
        List<Vehicle> vehicles;
        vehicles = fipeClient.listAllVehiclesByModel(idBrand, idModel);
        SetValueVehicleAnnual valueVehicleAnnual = new SetValueVehicleAnnual();
        for (Vehicle detail : vehicles) {
            detail = fipeClient.getDetailVehicle(idBrand, idModel, detail.getKey());
            valueVehicleAnnual.add(detail);
        }
        return valueVehicleAnnual.getValueVehicleAnnuals();
    }

    private List<VehicleDto> toDtoList(List<Vehicle> vehicles){
        ModelMapper modelMapper = new ModelMapper();
        List<VehicleDto> vehicleDtos = new ArrayList<>();
        vehicles.forEach(vehicle -> vehicleDtos.add(modelMapper.map(vehicle, VehicleDto.class)));
        return vehicleDtos;
    }

}