@Service
public class StockRecordServiceImpl implements StockRecordService {

    @Override
    public StockRecord createStockRecord(Long productId, Long warehouseId, StockRecord record) {
        if (record.getCurrentQuantity() < 0)
            throw new IllegalArgumentException("Invalid quantity");
        return record;
    }

    @Override public StockRecord getStockRecord(Long id) { return new StockRecord(); }

    @Override
    public List<StockRecord> getRecordsBy_product(Long productId) {
        return List.of();
    }

    @Override
    public List<StockRecord> getRecordsByWarehouse(Long warehouseId) {
        return List.of();
    }
}
