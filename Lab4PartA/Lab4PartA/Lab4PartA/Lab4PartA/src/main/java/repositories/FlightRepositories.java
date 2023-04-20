package repositories;

import domain.Flights;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepositories extends JpaRepository<Flights, Long> {
}