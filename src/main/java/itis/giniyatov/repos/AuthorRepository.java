package itis.giniyatov.repos;

import itis.giniyatov.Model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Buyer, Long> {
    Buyer findByName(String name);
}
