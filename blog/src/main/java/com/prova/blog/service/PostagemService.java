package com.prova.blog.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prova.blog.model.Postagem;

@Service
public class PostagemService{

    private static List<Postagem> postagens = new ArrayList<Postagem>();

    public PostagemService(){
        postagemFake();
    }

    private void postagemFake(){
        Postagem postagem1 = new Postagem();
        postagem1.setTitulo("Novidade no espaço");
        postagem1.setId(1L);
        postagem1.setConteudo("Foguete vai a lua");
        postagem1.setAutor("igao3k");
        postagem1.setDataPublicacao(LocalDate.of(2023, 9, 26));
        postagens.add(postagem1);


        Postagem postagem2 = new Postagem();
        postagem2.setTitulo("Zoio vs Bambam");
        postagem2.setId(2L);
        postagem2.setConteudo("A marreta vai cantar!!");
        postagem2.setAutor("ZoioLoko");
        postagem2.setDataPublicacao(LocalDate.of(2023, 5, 26));
        postagens.add(postagem2);
    }

 public List<Postagem> findAll(){
        return postagens;
    }

    public Postagem find(Postagem postagem){
        return postagens.stream().filter(c -> c.equals(postagem)).findFirst().orElse(null);
    }

    public Postagem find(Long id){
        return find(new Postagem(id));
    }

    public void Create (Postagem postagem){
        Long newId = (long) (postagens.size() +1);
        postagem.setId(newId);
        postagens.add(postagem);
    }

    public Postagem getById(Long id){
        Postagem _receita = new Postagem(id);
        return postagens.stream()
                       .filter(r -> r.equals(_receita))
                       .findFirst().orElse(null);
    }
   
}