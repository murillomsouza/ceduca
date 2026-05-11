# C'Educa

Sistema backend desenvolvido com Java + Spring Boot + MongoDB para gerenciamento de alunos e currículos acadêmicos.

O projeto permite que a secretaria cadastre alunos e que os próprios alunos preencham seus currículos através de formulários, armazenando todas as informações de forma estruturada no MongoDB.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data MongoDB
- Lombok
- Maven
- MongoDB

---

# Estrutura do Projeto

```txt
src/main/java/com/ceduca

├── controller
├── dto
├── model
├── repository
├── service
└── CeducaApplication
```

---

# Funcionalidades

## Secretaria

- Criar aluno
- Buscar todos os alunos
- Buscar aluno por ID
- Editar aluno
- Buscar alunos por tags
- Visualizar currículo
- Baixar currículo (estrutura preparada)

---

## Aluno

- Adicionar currículo
- Atualizar currículo
- Visualizar currículo

---

# Modelagem

## Secretaria

```txt
id
nome
email
senha
```

---

## Aluno

```txt
id
nome
email
telefone
tags
curriculo
```

---

## Currículo

```txt
resumo
linkedin
github
formacoes
qualificacoes
experiencias
```

---

# Banco de Dados

O projeto utiliza MongoDB.

## Configuração

No arquivo:

```txt
src/main/resources/application.properties
```

Configure:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/ceduca
spring.data.mongodb.auto-index-creation=true
```

---

# Como Executar

## Clonar repositório

```bash
git clone https://github.com/SEU-USUARIO/ceduca.git
```

---

## Entrar na pasta

```bash
cd ceduca
```

---

## Executar projeto

Linux:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw spring-boot:run
```

---

# Endpoints

# Secretaria

## Criar aluno

```http
POST /secretaria/alunos
```

---

## Buscar alunos

```http
GET /secretaria/alunos
```

---

## Buscar aluno por ID

```http
GET /secretaria/alunos/{id}
```

---

## Editar aluno

```http
PUT /secretaria/alunos/{id}
```

---

## Buscar alunos por tag

```http
GET /secretaria/alunos/tags?tag=Java
```

---

## Visualizar currículo

```http
GET /secretaria/alunos/{id}/curriculo
```

---

# Aluno

## Salvar currículo

```http
POST /aluno/{id}/curriculo
```

---

## Atualizar currículo

```http
PUT /aluno/{id}/curriculo
```

---

## Visualizar currículo

```http
GET /aluno/{id}/curriculo
```

---

# Exemplo JSON Currículo

```json
{
  "resumo": "Desenvolvedor Java em formação",
  "linkedin": "linkedin.com/in/murillo",
  "github": "github.com/murillo",
  "formacoes": [
    {
      "instituicao": "FATEC",
      "curso": "ADS",
      "inicio": "2025",
      "fim": "2027"
    }
  ],
  "qualificacoes": [
    {
      "nome": "Java"
    },
    {
      "nome": "Spring Boot"
    }
  ],
  "experiencias": [
    {
      "empresa": "Projeto Hackathon",
      "cargo": "Backend Developer",
      "descricao": "API REST com Spring Boot",
      "inicio": "2025",
      "fim": "2025"
    }
  ]
}
```

---

# Próximas Melhorias

- JWT Authentication
- Spring Security
- Geração de PDF
- Upload de foto
- Upload de currículo PDF
- Frontend Web
- Docker
- Deploy em nuvem

---

# Autores

- Cauã Santos
- Julia Rocha
- Matheus Vieira
- Marina Paiva
- Murillo de Souza
- Raul Corrêa