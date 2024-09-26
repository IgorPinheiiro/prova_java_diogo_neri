package com.prova.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.blog.model.Postagem;
import com.prova.blog.service.PostagemService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

  @Autowired
  private PostagemService postagemService;

  @GetMapping("/postagens")
  public ResponseEntity<List<Postagem>> getAll() {
    return ResponseEntity.ok(postagemService.findAll());
  }

}
