# ForumHub - Challenge Alura

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.0-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=for-the-badge&logo=postgresql)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=for-the-badge&logo=jsonwebtokens)

O **ForumHub** é uma API REST desenvolvida como parte de um desafio da Alura. O objetivo principal é simular o funcionamento de um fórum, onde usuários podem criar tópicos, responder a dúvidas, listar e gerenciar discussões sobre diversos cursos.

A aplicação foca em boas práticas de desenvolvimento, incluindo autenticação via tokens JWT, persistência de dados com Spring Data JPA, migrações de banco de dados com Flyway e validações de dados.

---

## 🚀 Funcionalidades

A API oferece um conjunto completo de operações CRUD para o gerenciamento do fórum:

- **Autenticação de Usuários**: Login seguro utilizando Spring Security e JWT.
- **Gerenciamento de Tópicos**:
  - Cadastro de novos tópicos (com validação de duplicidade).
  - Listagem paginada e ordenada por data de criação.
  - Detalhamento de tópicos específicos.
  - Atualização de informações.
  - Exclusão lógica/física de tópicos.
- **Respostas**: Sistema de interação entre usuários nos tópicos.
- **Tratamento de Erros**: Respostas padronizadas para exceções e erros de validação.

---

## 🛠️ Tecnologias Utilizadas

A stack tecnológica foi escolhida para garantir robustez e escalabilidade:

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 21** | Versão mais recente com suporte a longo prazo (LTS). |
| **Spring Boot 3** | Framework principal para agilizar o desenvolvimento. |
| **Spring Data JPA** | Abstração de persistência de dados. |
| **Spring Security** | Camada de segurança e controle de acesso. |
| **Flyway** | Controle de versão e migração do banco de dados. |
| **PostgreSQL** | Banco de dados relacional para produção. |
| **Lombok** | Redução de código boilerplate (getters, setters, etc). |
| **Auth0 JWT** | Biblioteca para geração e validação de tokens. |

---

## 📋 Endpoints Principais

Abaixo estão os principais recursos expostos pela API:

### Autenticação
- `POST /login`: Recebe e-mail e senha, retorna um token JWT.

### Tópicos
- `GET /topicos`: Lista todos os tópicos (paginado).
- `POST /topicos`: Cria um novo tópico (Requer Autenticação).
- `GET /topicos/{id}`: Exibe detalhes de um tópico.
- `PUT /topicos/{id}`: Atualiza um tópico existente.
- `DELETE /topicos/{id}`: Remove um tópico.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- JDK 21 ou superior.
- Maven 3.9+.
- PostgreSQL rodando localmente.

### Configuração
1. Clone o repositório:
   ```bash
   git clone https://github.com/eduuardo1st/forumhub.git
   ```
2. Configure o banco de dados no arquivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/forumhub
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   api.security.token.secret=${JWT_SECRET:seu_segredo_aqui}
   ```
3. Execute a aplicação via Maven:
   ```bash
   mvn spring-boot:run
   ```

---

## 🧪 Testes e Demonstração

A API foi validada através de testes rigorosos utilizando ferramentas como Postman e Insomnia.

### Exemplo de Cadastro de Tópico (JSON)
```json
{
    "titulo": "Dúvida sobre Spring Security",
    "mensagem": "Como configurar o filtro de autenticação corretamente?",
    "idAutor": 1,
    "idCurso": 1
}
```

### Resposta de Sucesso (201 Created)
```json
{
    "id": 1,
    "titulo": "Dúvida sobre Spring Security",
    "mensagem": "Como configurar o filtro de autenticação corretamente?",
    "dataCriacao": "2024-06-20T10:00:00",
    "status": "NAO_RESPONDIDO",
    "autor": "Eduardo",
    "curso": "Spring Boot"
}
```

---

## ✒️ Autor

Desenvolvido por **Eduardo** - [Seu GitHub](https://github.com/eduuardo1st)

---
*Este projeto faz parte do Challenge ForumHub da Alura.*
