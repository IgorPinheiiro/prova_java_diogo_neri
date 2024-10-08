package com.prova.blog.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.blog.model.Postagem;
import com.prova.blog.service.PostagemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/")
public class PostagemController {

  @Autowired
  private PostagemService postagemService;

  @GetMapping("/postagens")
  public ResponseEntity<List<Postagem>> getAll() {
    return ResponseEntity.ok(postagemService.findAll());
  }

   @PostMapping("/postagens")
    public ResponseEntity<Postagem> create(@RequestBody Postagem postagem){
        postagemService.Create(postagem);
        URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(postagem.getId())
                                .toUri();
        return ResponseEntity.created(location).body(postagem);
    }

    @GetMapping("/postagens/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable("id") Long id){
        Postagem postagem = postagemService.getById(id);
        if (postagem != null){
            return ResponseEntity.ok(postagem);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(params = "autor")
    public ResponseEntity<List<Postagem>> getByAutor(@RequestParam String autor) {
        List<Postagem> postagens = postagemService.getByAutor(autor);
        return ResponseEntity.ok(postagens);
    }
    

     @PutMapping("/postagens")
    public ResponseEntity<Postagem> update(@RequestBody Postagem postagem){
        if (postagemService.update(postagem)){
            return ResponseEntity.ok(postagem);
        }
        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Postagem> delete(@PathVariable("id") Long id){
        if (postagemService.delete(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }    

  

}
