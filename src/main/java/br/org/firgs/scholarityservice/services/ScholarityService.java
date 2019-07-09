package br.org.firgs.scholarityservice.services;

import br.org.firgs.scholarityservice.entities.Scholarity;
import br.org.firgs.scholarityservice.repositories.ScholarityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScholarityService {

    @Autowired
    private ScholarityRepository scholarityRepository;

    public List<Scholarity> findAll() {
        return scholarityRepository.findAll();
    }

    public List<Scholarity> findByName(String name) {
        Optional<List<Scholarity>> optScholarity = scholarityRepository.findByNameContainingIgnoreCase(name);
        return optScholarity.orElse(new ArrayList<>());
    }

    public Scholarity findByIdentifier(String identifier) {
        Optional<Scholarity> optScholarity = scholarityRepository.findByIdentifier(identifier);
        return optScholarity.orElse(null);
    }

    public Scholarity save(Scholarity scholarity) {
        Optional<Scholarity> optScholarity = scholarityRepository.findByNameOrIdentifier(scholarity.getName(), scholarity.getIdentifier());
        if (optScholarity.isEmpty()) {
            return scholarityRepository.save(scholarity);
        } else {
            throw new RuntimeException("Grau de instrução já cadastrado!");
        }
    }

    public Scholarity update(Scholarity scholarity) {
        Optional<Scholarity> optScholarity = scholarityRepository.findOneByNameContainingIgnoreCaseOrIdentifierAndIdNot(scholarity.getName(), scholarity.getIdentifier(), scholarity.getId());
        if (optScholarity.isEmpty()) {
            return scholarityRepository.save(scholarity);
        } else {
            throw new RuntimeException("Grau de instrução já cadastrado!");
        }
    }

    public void delete(Long id) {
        scholarityRepository.deleteById(id);
    }
}
