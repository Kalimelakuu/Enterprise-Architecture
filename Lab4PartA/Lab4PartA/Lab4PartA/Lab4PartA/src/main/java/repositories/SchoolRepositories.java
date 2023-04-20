package repositories;

import domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepositories extends JpaRepository<School, Long> {
}
