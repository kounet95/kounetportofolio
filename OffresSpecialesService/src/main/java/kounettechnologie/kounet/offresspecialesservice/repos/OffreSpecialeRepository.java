package kounettechnologie.kounet.offresspecialesservice.repos;


import kounettechnologie.kounet.offresspecialesservice.entity.OffreSpeciale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OffreSpecialeRepository extends JpaRepository<OffreSpeciale, Long> {
    List<OffreSpeciale> findByStartDateBeforeAndEndDateAfter(LocalDate startDate, LocalDate endDate);
}
