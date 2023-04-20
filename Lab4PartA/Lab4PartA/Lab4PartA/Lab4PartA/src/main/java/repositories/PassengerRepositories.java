package repositories;

import domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepositories extends JpaRepository<Passenger, Long> {
}
