package com.eduuardo.forumhub.service;

import com.eduuardo.forumhub.domain.topico.*;
import com.eduuardo.forumhub.repository.*;
import com.eduuardo.forumhub.repository.UsuarioRepository;
import com.eduuardo.forumhub.repository.CursoRepository;
import com.eduuardo.forumhub.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DadosDetalhamentoTopico criar(DadosCadastroTopico dados) {
        var autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado no banco de dados."));

        var curso = cursoRepository.findById(dados.idCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado no banco de dados."));

        var topico = new Topico(
                null,
                dados.titulo(),
                dados.mensagem(),
                LocalDateTime.now(),
                "ATIVO",
                autor,
                curso
        );

        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public Page<DadosListagemTopico> listar(Pageable paginacao) {
        return topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    public DadosDetalhamentoTopico detalhar(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return new DadosDetalhamentoTopico(topico);
    }

    public DadosDetalhamentoTopico atualizar(Long id, DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        topico.atualizarInformacoes(dados);

        return new DadosDetalhamentoTopico(topico);
    }

    public void excluir(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        topicoRepository.delete(topico);
    }
}