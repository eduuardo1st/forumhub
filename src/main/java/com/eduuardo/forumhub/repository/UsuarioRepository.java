package com.eduuardo.forumhub.repository;

import com.eduuardo.forumhub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}