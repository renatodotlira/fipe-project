package com.tabelafipe.service.impl;

import com.tabelafipe.client.FipeClient;
import com.tabelafipe.model.Brand;
import com.tabelafipe.service.BrandService;
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
