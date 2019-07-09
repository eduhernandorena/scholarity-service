package br.org.fiergs.scholarityservice.controllers;

import br.org.fiergs.scholarityservice.entities.Scholarity;
import br.org.fiergs.scholarityservice.services.ScholarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/scholarity", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScholarityController {

    @Autowired
    private ScholarityService scholarityService;


    @GetMapping
    public List<Scholarity> list() {
        return scholarityService.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Scholarity> listByDescription(@PathVariable("name") String name) {
        return scholarityService.findByName(name);
    }

    @GetMapping("/identifier/{identifier}")
    public Scholarity findByIdentifier(@PathVariable("identifier") String identifier) {
        return scholarityService.findByIdentifier(identifier);
    }

    @PostMapping
    public Scholarity save(@RequestBody @Valid Scholarity scholarity) {
        return scholarityService.save(scholarity);
    }

    @PutMapping
    public Scholarity update(@RequestBody @Valid Scholarity scholarity) {
        return scholarityService.update(scholarity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scholarityService.delete(id);
    }
}
