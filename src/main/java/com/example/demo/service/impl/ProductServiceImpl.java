@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    @Override public Product createProduct(Product p) { return p; }
    @Override public Product getProduct(Long id) { return new Product(); }
    @Override public List<Product> getAllProducts() { return List.of(); }
}
