package com.tabelafipe.controller;

import com.tabelafipe.dto.VehicleDto;
import com.tabelafipe.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/brands/{idBrand}")
    public List<VehicleDto> getAllByBrand(@PathVariable("idBrand") Long idBrand){
        return vehicleService.listByBrand(idBrand);
    }

    @GetMapping("/depreciations/brands/{idBrand}/models/{idModel}")
    public List<String> listDepreciations(@PathVariable("idBrand") Long idBrand,
                                          @PathVariable("idModel") Long idModel){
        return vehicleService.ListDepretiations(idBrand, idModel);
    }

}
