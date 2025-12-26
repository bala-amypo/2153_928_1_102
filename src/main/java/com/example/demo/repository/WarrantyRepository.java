public interface WarrantyRepository {
    boolean existsBySerialNumber(String serial);
    Warranty save(Warranty warranty);
    Optional<Warranty> findById(Long id);
    List<Warranty> findByUserId(Long userId);
    List<Warranty> findWarrantiesExpiringBetween(LocalDate f, LocalDate t);
}
