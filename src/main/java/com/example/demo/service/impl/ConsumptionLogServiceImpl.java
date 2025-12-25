@Service
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    @Override
    public ConsumptionLog logConsumption(Long stockRecordId, ConsumptionLog log) {
        if (log.getConsumedDate() != null &&
            log.getConsumedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("consumedDate cannot be future");
        }
        return log;
    }

    @Override public List<ConsumptionLog> getLogsByStockRecord(Long id) { return List.of(); }
    @Override public ConsumptionLog getLog(Long id) { return new ConsumptionLog(); }
}
