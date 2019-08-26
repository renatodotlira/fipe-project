package com.tabelafipe.service.impl;

import com.tabelafipe.model.Vehicle;
import com.tabelafipe.client.FipeClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceImplTest {

    @Mock
    private FipeClient client;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void listByBrand_NullObjects(){
        assertEquals(Collections.EMPTY_LIST ,vehicleService.listByBrand(anyLong()));
    }

    @Test
    public void listByBrand_OK(){
        List<Vehicle> vehicles = vehiclesList_dummy();
        Vehicle vehicle = Vehicle.builder()
                            .id("000")
                            .key("2019")
                            .anoModelo("2019")
                            .preco("R$ 100,00")
                            .build();

        Vehicle vehicle2 = Vehicle.builder()
                            .id("000")
                            .key("2018")
                            .anoModelo("2018")
                            .preco("R$ 75,00")
                            .build();

        Vehicle vehicle3 = Vehicle.builder()
                            .id("000")
                            .key("2017")
                            .anoModelo("2017")
                            .preco("R$ 70,00")
                            .build();

        when(client.listAllVehiclesByModel(any(), any())).thenReturn(vehicles);

        when(client.getDetailVehicle(0L, 0L, "2019")).thenReturn(vehicle);
        when(client.getDetailVehicle(0L, 0L, "2018")).thenReturn(vehicle2);
        when(client.getDetailVehicle(0L, 0L, "2017")).thenReturn(vehicle3);

        List<String> sentences = new ArrayList<>();
        sentences.add("Valor em 2019 -> R$ 100,00,");
        sentences.add("Valor em 2018 -> R$ 75,00 alteração de R$ 25,00 (25%) em relação a 2019,");
        sentences.add("Valor em 2017 -> R$ 70,00 alteração de R$ 5,00 (6,6%) em relação a 2018");

        assertEquals(sentences ,vehicleService.ListDepretiations(0L, 0L));
    }


    private List<Vehicle> vehiclesList_dummy(){
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = Vehicle.builder()
                .id("000")
                .key("2019")
                .anoModelo("2019")
                .preco("R$ 100,00")
                .build();

        Vehicle vehicle2 = Vehicle.builder()
                .id("000")
                .key("2018")
                .anoModelo("2018")
                .preco("R$ 75,00")
                .build();
        Vehicle vehicle3 = Vehicle.builder()
                .id("000")
                .key("2017")
                .anoModelo("2017")
                .preco("R$ 70,00")
                .build();
        vehicles.add(vehicle);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        return vehicles;
    }
}