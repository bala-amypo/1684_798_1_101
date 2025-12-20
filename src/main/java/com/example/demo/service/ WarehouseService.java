package com.example.demo.service;

import com.example.demo.model.Warehouse;
import java.util.List;

public interface WarehouseService {

    Warehouse saveWarehouse(Warehouse warehouse);

    List<Warehouse> getAllWarehouses();

    Warehouse getWarehouseById(Long id);

    void deleteWarehouse(Long id);
}
