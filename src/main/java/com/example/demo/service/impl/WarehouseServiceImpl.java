package com.example.demo.service.impl;

import com.example.demo.model.Warehouse;
import com.example.demo.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouse;
    }

    @Override
    public List<Warehouse> findAll() {
        return new ArrayList<>();
    }
}
