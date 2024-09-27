package com.prova.blog.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.blog.model.Postagem;
import com.prova.blog.service.PostagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    


  

}
