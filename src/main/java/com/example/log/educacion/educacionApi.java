package com.example.log.educacion;

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
@RequestMapping("/educacion")
public class educacionApi {

    @Autowired
    private educacionRepository repo;

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PostMapping
    public ResponseEntity<educacion> create(@RequestBody @Valid educacion Educacion) {
        educacion savedEducacion = repo.save(Educacion);
        URI educacionURI = URI.create("/educacion/" + savedEducacion.getId());
        return ResponseEntity.created(educacionURI).body(savedEducacion);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping
    public List<educacion> list() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "periodo"));
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Optional<educacion> verEducacion(@PathVariable int id) {
        return repo.findById(id);
        //return listaPersonas;
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PutMapping("/edit/")
    //@ResponseBody
    public void editarEducacion (@RequestBody educacion prod) {
        repo.save(prod);
        //listaPersonas.add(pers);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public void borrarEducacion (@PathVariable int id) {
        repo.deleteById(id); 
    }
}
