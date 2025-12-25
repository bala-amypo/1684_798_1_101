@Service
public class PredictionServiceImpl implements PredictionService {

    @Override
    public LocalDate predictRestockDate(Long stockRecordId) {
        return LocalDate.now().plusDays(5);
    }

    @Override
    public List<PredictionRule> getAllRules() {
        return List.of();
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {
        return rule;
    }
}
