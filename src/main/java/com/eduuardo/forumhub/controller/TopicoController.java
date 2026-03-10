package com.eduuardo.forumhub.controller;

import com.eduuardo.forumhub.domain.topico.DadosAtualizacaoTopico;
import com.eduuardo.forumhub.domain.topico.DadosCadastroTopico;
import com.eduuardo.forumhub.domain.topico.DadosDetalhamentoTopico;
import com.eduuardo.forumhub.domain.topico.DadosListagemTopico;
import com.eduuardo.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {

        DadosDetalhamentoTopico topicoDetalhado = topicoService.criar(dados);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoDetalhado.id()).toUri();

        return ResponseEntity.created(uri).body(topicoDetalhado);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = topicoService.listar(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        var topicoDetalhado = topicoService.detalhar(id);

        return ResponseEntity.ok(topicoDetalhado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@PathVariable Long id, @RequestBody DadosAtualizacaoTopico dados) {
        var topicoAtualizado = topicoService.atualizar(id, dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        topicoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}