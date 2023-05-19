package itis.giniyatov.repos;

import itis.giniyatov.Model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Cars, Long> {
    Cars findByName(String name);
}
