@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @GetMapping
    public String test() {
        return "Warehouse API working";
    }
}
