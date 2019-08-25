package com.example.tabelafipe.controller;

import com.example.tabelafipe.model.Brand;
import com.example.tabelafipe.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brand")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAll(){
        return brandService.listAll();
    }

}
