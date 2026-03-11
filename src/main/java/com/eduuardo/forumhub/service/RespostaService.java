package com.eduuardo.forumhub.service;

import com.eduuardo.forumhub.domain.resposta.DadosCadastroResposta;
import com.eduuardo.forumhub.domain.resposta.DadosDetalhamentoResposta;
import com.eduuardo.forumhub.domain.resposta.Resposta;
import com.eduuardo.forumhub.repository.RespostaRepository;
import com.eduuardo.forumhub.repository.TopicoRepository;
import com.eduuardo.forumhub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosDetalhamentoResposta registrar(DadosCadastroResposta dados) {
        var topico = topicoRepository.findById(dados.idTopico())
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        var autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

        var resposta = new Resposta(null, dados.mensagem(), LocalDateTime.now(), false, autor, topico);

        respostaRepository.save(resposta);

        return new DadosDetalhamentoResposta(resposta);
    }
}