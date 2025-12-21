@Override
public Warehouse getWarehouse(Long id) {
    return repository.findById(id).orElseThrow();
}
