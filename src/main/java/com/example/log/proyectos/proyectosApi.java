package com.example.log.proyectos;

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
@RequestMapping("/proyectos")
public class proyectosApi {

    @Autowired
    private proyectosRepository repo;

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PostMapping
    public ResponseEntity<proyectos> create(@RequestBody @Valid proyectos Proyectos) {
        proyectos savedProyectos = repo.save(Proyectos);
        URI proyectosURI = URI.create("/proyectos/" + savedProyectos.getId());
        return ResponseEntity.created(proyectosURI).body(savedProyectos);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping
    public List<proyectos> list() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Optional<proyectos> verProyectos(@PathVariable int id) {
        return repo.findById(id);
        //return listaPersonas;
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @PutMapping("/edit/")
    //@ResponseBody
    public void editarProyectos (@RequestBody proyectos prod) {
        repo.save(prod);
        //listaPersonas.add(pers);
    }

    @CrossOrigin(origins = "https://argentinaprograma-fe026.web.app")
    @DeleteMapping("/delete/{id}")
    //@ResponseBody
    public void borrarProyectos (@PathVariable int id) {
        repo.deleteById(id); 
    }
}
