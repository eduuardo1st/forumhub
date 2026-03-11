package com.eduuardo.forumhub.repository;

import com.eduuardo.forumhub.domain.resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}