package repositories;

import domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DoctorRepositories extends JpaRepository<Doctor, Long> {
}
