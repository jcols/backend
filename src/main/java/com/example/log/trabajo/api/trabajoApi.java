package com.example.log.trabajo.api;

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
@RequestMapping("/trabajo")
public class trabajoApi {

    @Autowired
    private trabajoRepository repo;

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PostMapping
    public ResponseEntity<trabajo> create(@RequestBody @Valid trabajo Trabajo) {
        trabajo savedTrabajo = repo.save(Trabajo);
        URI trabajoURI = URI.create("/trabajo/" + savedTrabajo.getId());
        return ResponseEntity.created(trabajoURI).body(savedTrabajo);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping
    public List<trabajo> list() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "inicio"));
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Optional<trabajo> verTrabajo(@PathVariable int id) {
        return repo.findById(id);
        //return listaPersonas;
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PutMapping("/edit/")
    //@ResponseBody
    public void editarTrabajo (@RequestBody trabajo prod) {
        repo.save(prod);
        //listaPersonas.add(pers);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public void borrarTrabajo (@PathVariable int id) {
        repo.deleteById(id); 
    }
}
