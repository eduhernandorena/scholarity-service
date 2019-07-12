package br.org.fiergs.scholarityservice.repositories;

import br.org.fiergs.scholarityservice.entities.Scholarity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScholarityRepository extends JpaRepository<Scholarity, Long> {

    Optional<Scholarity> findByNameContainingIgnoreCase(String name);

    Optional<Scholarity> findOneByNameIgnoreCaseAndIdNot(String name, Long id);

    void deleteById(Long id);
}
