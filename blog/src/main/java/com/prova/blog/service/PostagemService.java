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
        Postagem postagem = new Postagem();
        postagem.setTitulo("Novidade no espaço");
        postagem.setId(1L);
        postagem.setConteudo("Foguete vai a lua");
        postagem.setAutor("igao3k");
        postagem.setDataPublicacao(LocalDate.of(2023, 9, 26));
        postagens.add(postagem);


        Postagem postagem2 = new Postagem();
        postagem.setTitulo("Zoio vs Bambam");
        postagem.setId(2L);
        postagem.setConteudo("A marreta vai cantar!!");
        postagem.setAutor("ZoioLoko");
        postagem.setDataPublicacao(LocalDate.of(2023, 5, 26));
        postagens.add(postagem2);
    }

 public List<Postagem> findAll(){
        return postagens;
    }

    public Postagem find(Postagem conta){
        return postagens.stream().filter(c -> c.equals(conta)).findFirst().orElse(null);
    }

    public Postagem find(Long id){
        return find(new Postagem(id));
    }

   
}