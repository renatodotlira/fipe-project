package com.example.tabelafipe.service.impl;

import com.example.tabelafipe.client.FipeClient;
import com.example.tabelafipe.model.Brand;
import com.example.tabelafipe.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private FipeClient fipeClient;

    @Override
    public List<Brand> listAll() {
        return fipeClient.listAllBrands();
    }
}
