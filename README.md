# API de Gerenciamento de Tarefas (Task Manager)

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x.x-green?style=for-the-badge&logo=spring)
![Maven](https://img.shields.io/badge/Maven-4.0.0-blue?style=for-the-badge&logo=apache-maven)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

## 📖 Sobre o Projeto

Esta é uma API RESTful completa para um sistema de gerenciamento de tarefas (To-Do List), desenvolvida como parte do meu portfólio de projetos para demonstrar minhas habilidades em desenvolvimento back-end com **Java e Spring Boot**.

A aplicação segue as melhores práticas de desenvolvimento, incluindo uma arquitetura em camadas (Controller, Service, Repository), validação de dados de entrada e tratamento de exceções, garantindo um código limpo, robusto e escalável.

## ✨ Funcionalidades

-   ✅ **CRUD Completo de Tarefas:**
    -   **C**reate: Adicionar novas tarefas.
    -   **R**ead: Listar todas as tarefas ou buscar uma tarefa específica por ID.
    -   **U**pdate: Modificar o título, descrição e status de uma tarefa existente.
    -   **D**elete: Remover uma tarefa.
-   ✅ **Validação de Dados:** Garante que dados essenciais (como o título da tarefa) não sejam nulos ou vazios.
-   ✅ **Tratamento de Exceções:** Retorna respostas de erro claras e com os status HTTP corretos (ex: 404 Not Found se a tarefa não existe).
-   ✅ **Banco de Dados em Memória:** Utiliza o H2 Database para facilitar a execução e os testes sem a necessidade de configurar um banco de dados externo.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias e ferramentas:

| Tecnologia        | Descrição                                         |
| ----------------- | ------------------------------------------------- |
| **Java 17** | Linguagem de programação principal.               |
| **Spring Boot 3** | Framework para criação de aplicações stand-alone. |
| **Spring Web** | Módulo para construir APIs RESTful.               |
| **Spring Data JPA** | Para persistência de dados de forma simplificada. |
| **Hibernate** | Implementação do JPA para mapeamento objeto-relacional. |
| **H2 Database** | Banco de dados relacional em memória.             |
| **Maven** | Ferramenta de gerenciamento de dependências e build. |
| **Postman** | Ferramenta para testar os endpoints da API.         |

## 🏛️ Arquitetura

A aplicação foi estruturada seguindo o padrão de arquitetura em 3 camadas para garantir a separação de responsabilidades e a manutenibilidade do código:

-   **Controller Layer (`TaskController.java`):** Responsável por receber as requisições HTTP, validar os dados de entrada e retornar as respostas ao cliente.
-   **Service Layer (`TaskService.java`):** Contém toda a lógica de negócio da aplicação.
-   **Repository Layer (`TaskRepository.java`):** Responsável pela comunicação com o banco de dados, abstraindo as operações de persistência.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a aplicação localmente.

### Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:
-   [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) - Versão 17 ou superior.
-   [Apache Maven](https://maven.apache.org/download.cgi) - Gerenciador de dependências.
-   [Git](https://git-scm.com/downloads) - Para clonar o repositório.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)[SEU-USUARIO-GITHUB]/taskmanager.git
    ```

2.  **Acesse o diretório do projeto:**
    ```bash
    cd taskmanager
    ```

3.  **Execute a aplicação com o Maven Wrapper:**
    *No Windows:*
    ```bash
    ./mvnw spring-boot:run
    ```
    *No Linux ou macOS:*
    ```bash
    ./mvnw spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.

## 🗄️ Acesso ao Banco de Dados (H2 Console)

Você pode acessar o console do banco de dados em memória para visualizar as tabelas e os dados diretamente no seu navegador:

1.  Acesse a URL: `http://localhost:8080/h2-console`
2.  Use as seguintes credenciais para fazer login:
    -   **Driver Class:** `org.h2.Driver`
    -   **JDBC URL:** `jdbc:h2:mem:taskdb`
    -   **User Name:** `sa`
    -   **Password:** `password`

## Endpoints da API

Aqui estão todos os endpoints disponíveis na API.

---

#### `GET /api/tasks`
-   **Descrição:** Retorna uma lista de todas as tarefas.
-   **Resposta de Sucesso (200 OK):**
    ```json
    [
        {
            "id": 1,
            "title": "Configurar ambiente",
            "description": "Instalar Java, Maven e IntelliJ.",
            "completed": false,
            "createdAt": "2025-09-25T17:45:00.123456"
        }
    ]
    ```

---

#### `GET /api/tasks/{id}`
-   **Descrição:** Busca uma tarefa específica pelo seu ID.
-   **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": 1,
        "title": "Configurar ambiente",
        "description": "Instalar Java, Maven e IntelliJ.",
        "completed": false,
        "createdAt": "2025-09-25T17:45:00.123456"
    }
    ```
-   **Resposta de Erro (404 Not Found):** Se a tarefa com o ID especificado não for encontrada.

---

#### `POST /api/tasks`
-   **Descrição:** Cria uma nova tarefa.
-   **Corpo da Requisição (Request Body):**
    ```json
    {
        "title": "Criar README do projeto",
        "description": "Detalhar todas as funcionalidades e como executar a API."
    }
    ```
-   **Resposta de Sucesso (200 OK):** Retorna a tarefa recém-criada com o ID gerado.

---

#### `PUT /api/tasks/{id}`
-   **Descrição:** Atualiza uma tarefa existente.
-   **Corpo da Requisição (Request Body):**
    ```json
    {
        "title": "Criar README do projeto (Atualizado)",
        "description": "Detalhar todas as funcionalidades e como executar a API.",
        "completed": true
    }
    ```
-   **Resposta de Sucesso (200 OK):** Retorna a tarefa com os dados atualizados.

---

#### `DELETE /api/tasks/{id}`
-   **Descrição:** Deleta uma tarefa pelo seu ID.
-   **Resposta de Sucesso (204 No Content):** Retorna uma resposta vazia indicando sucesso.

## 👨‍💻 Autor

Desenvolvido por **Thiago André Neves Miranda**.

-   [![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/tanm-dev/)
-   [![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ThiagoMiranda-m)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
