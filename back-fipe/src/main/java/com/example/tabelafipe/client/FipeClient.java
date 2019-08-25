package com.example.tabelafipe.client;

import com.example.tabelafipe.model.Brand;
import com.example.tabelafipe.model.Vehicle;
import feign.Param;
import feign.RequestLine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FipeClient {

    @RequestLine("GET /marcas.json")
    List<Brand> listAllBrands();

    @RequestLine("GET /veiculos/{idBrand}.json")
    List<Vehicle> listAllVehicles(@Param("idBrand") Long idBrand);

    @RequestLine("GET /veiculo/{idBrand}/{idModel}.json")
    List<Vehicle> listAllVehiclesByModel(@Param("idBrand") Long idBrand,
                                         @Param("idModel") Long idModel);

    @RequestLine("GET /veiculo/{idBrand}/{idModel}/{key}.json")
    Vehicle getDetailVehicle(@Param("idBrand") Long idBrand,
                                   @Param("idModel") Long idModel,
                                   @Param("key") String key);

}
