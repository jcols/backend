package com.example.log.skills.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
@RequestMapping("/skills")
public class skillsApi {

    @Autowired
    private skillsRepository repo;

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PostMapping
    public ResponseEntity<skills> create(@RequestBody @Valid skills Skill) {
        skills savedSkills = repo.save(Skill);
        URI skillsURI = URI.create("/skills/" + savedSkills.getId());
        return ResponseEntity.created(skillsURI).body(savedSkills);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping
    public List<skills> list() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "grado"));
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Optional<skills> verSkill(@PathVariable int id) {
        return repo.findById(id);
        //return listaPersonas;
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PutMapping("/edit/")
    //@ResponseBody
    public void editarSkill (@RequestBody skills prod) {
        repo.save(prod);
        //listaPersonas.add(pers);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public void borrarSkill (@PathVariable int id) {
        repo.deleteById(id); 
    }
}
