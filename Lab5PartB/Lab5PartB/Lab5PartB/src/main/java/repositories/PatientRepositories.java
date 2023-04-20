package repositories;

import domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepositories extends JpaRepository<Patient, Long> {
}
