@Data
@Entity
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Warehouse warehouse;

    private int currentQuantity;
    private int reorderThreshold;
    private LocalDateTime lastUpdated;
}
