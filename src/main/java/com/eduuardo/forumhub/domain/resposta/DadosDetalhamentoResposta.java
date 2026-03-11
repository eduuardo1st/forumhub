package com.eduuardo.forumhub.domain.resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        String mensagem,
        LocalDateTime dataCriacao,
        String nomeAutor,
        Boolean solucao
) {
    public DadosDetalhamentoResposta(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getAutor().getNome(),
                resposta.getSolucao()
        );
    }
}