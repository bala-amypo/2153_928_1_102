public interface AlertLogRepository {
    AlertLog save(AlertLog log);
    List<AlertLog> findByWarrantyId(Long id);
}
