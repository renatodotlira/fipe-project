package com.tabelafipe.client;

import com.tabelafipe.model.Vehicle;
import com.tabelafipe.model.Brand;
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
