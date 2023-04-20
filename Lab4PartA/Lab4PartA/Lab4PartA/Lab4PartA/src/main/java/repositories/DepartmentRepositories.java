package repositories;

import domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepositories extends JpaRepository<Department, Long> {
}
