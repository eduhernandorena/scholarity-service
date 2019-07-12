package br.org.fiergs.scholarityservice.services;

import br.org.fiergs.scholarityservice.entities.Scholarity;
import br.org.fiergs.scholarityservice.repositories.ScholarityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScholarityService {

    @Autowired
    private ScholarityRepository scholarityRepository;

    public List<Scholarity> findAll() {
        return scholarityRepository.findAll();
    }

    public Scholarity findByName(String name) {
        Optional<Scholarity> optScholarity = scholarityRepository.findByNameContainingIgnoreCase(name);
        return optScholarity.orElse(null);
    }


    public Scholarity save(Scholarity scholarity) {
        Optional<Scholarity> optScholarity = scholarityRepository.findByNameContainingIgnoreCase(scholarity.getName());
        if (optScholarity.isEmpty()) {
            return scholarityRepository.save(scholarity);
        } else {
            throw new RuntimeException("Grau de instrução já cadastrado!");
        }
    }

    public Scholarity update(Scholarity scholarity) {
        Optional<Scholarity> optScholarity = scholarityRepository.findOneByNameIgnoreCaseAndIdNot(scholarity.getName(), scholarity.getId());
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
