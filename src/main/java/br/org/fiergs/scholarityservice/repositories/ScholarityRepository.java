package br.org.fiergs.scholarityservice.repositories;

import br.org.fiergs.scholarityservice.entities.Scholarity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScholarityRepository extends JpaRepository<Scholarity, Long> {

    Optional<List<Scholarity>> findByNameContainingIgnoreCase(String name);

    Optional<Scholarity> findByIdentifier(String identifier);

    Optional<Scholarity> findByNameOrIdentifier(String name, String identifier);

    @Query("select o from Scholarity o where (upper(name) = upper(?1) or identifier = ?2) and id <> ?3")
    Optional<Scholarity> findOneByNameIgnoreCaseOrIdentifierAndIdNot(String name, String identifier, Long id);

    void deleteById(Long id);
}
