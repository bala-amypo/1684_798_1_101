@RestController
@RequestMapping("/api/products")
@Tag(name = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product p) {
        return productService.createProduct(p);
    }

    @GetMapping
    public List<Product> all() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
