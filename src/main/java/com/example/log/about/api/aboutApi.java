package com.example.log.about.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/about")
public class aboutApi {

    @Autowired
    private aboutRepository repo;

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app/")
    @PostMapping
    public ResponseEntity<about> createAbout(@RequestBody @Valid about About) {
        about savedAbout = repo.save(About);
        URI aboutURI = URI.create("/about/" + savedAbout.getId());
        return ResponseEntity.created(aboutURI).body(savedAbout);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app/")
    @GetMapping
    public List<about> listar() {
        return repo.findAll();
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Optional<about> verPersona(@PathVariable int id) {
        return repo.findById(id);
        //return listaPersonas;
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PutMapping("/edit/")
    //@ResponseBody
    public void editarPersona(@RequestBody about prod) {
        repo.save(prod);
        //listaPersonas.add(pers);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public void borrarPersona(@PathVariable int id) {
        repo.deleteById(id); 
    }
}
