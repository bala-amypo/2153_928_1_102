public interface AlertScheduleRepository {
    AlertSchedule save(AlertSchedule s);
    List<AlertSchedule> findByWarrantyId(Long id);
}
