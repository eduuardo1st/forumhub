package com.eduuardo.forumhub.controller;

import com.eduuardo.forumhub.domain.resposta.DadosCadastroResposta;
import com.eduuardo.forumhub.domain.resposta.DadosDetalhamentoResposta;
import com.eduuardo.forumhub.service.RespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoResposta> cadastrar(@RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuilder) {
        var resposta = service.registrar(dados);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.id()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }
}