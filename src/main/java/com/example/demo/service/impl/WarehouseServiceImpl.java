@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Override public Warehouse createWarehouse(Warehouse w) { return w; }
    @Override public Warehouse getWarehouse(Long id) { return new Warehouse(); }
    @Override public List<Warehouse> getAllWarehouses() { return List.of(); }
}
