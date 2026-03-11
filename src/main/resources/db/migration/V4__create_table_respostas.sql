CREATE TABLE respostas (
    id BIGSERIAL PRIMARY KEY,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    solucao BOOLEAN NOT NULL DEFAULT FALSE,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,

    CONSTRAINT fk_respostas_autor_id FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    CONSTRAINT fk_respostas_topico_id FOREIGN KEY (topico_id) REFERENCES topicos(id)
);