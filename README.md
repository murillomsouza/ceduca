# C'Educa

Sistema backend REST desenvolvido com Java, Spring Boot e MongoDB para gerenciamento acadêmico de alunos e currículos.

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
- OpenPDF
- Jakarta Validation

---

# Estrutura do Projeto

```txt
src/main/java/com/ceduca

├── controller
├── dto
├── model
├── repository
├── service
│   └── pdf
└── CeducaApplication
```

---

## Funcionalidades

- Cadastro de secretarias
- Cadastro de alunos
- Busca de alunos por tags
- Cadastro de currículo
- Geração dinâmica de currículo em PDF
- Download de currículo em PDF
- Integração com MongoDB
- API REST com Spring Boot
- Geração dinâmica de PDF em tempo real

## Secretaria

### Gerenciamento de Secretaria

- Criar usuario secretaria
- Buscar todos os usuarios secretaria
- Buscar usuarios secretaria por ID
- Editar usuarios secretaria
- Deletar usuarios secretaria

### Gerenciamento de Alunos

- Criar aluno
- Buscar todos os alunos
- Buscar aluno por ID
- Editar aluno
- Buscar alunos por tags

### Currículos

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
tipoUsuario
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
# Dependências Principais

O projeto utiliza as seguintes dependências Spring Boot:

```xml
<!-- Spring Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- MongoDB -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>

<!-- Validações -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- DevTools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

<!-- Testes -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<!-- OpenPDF -->
<dependency>
<groupId>com.github.librepdf</groupId>
<artifactId>openpdf</artifactId>
<version>1.3.39</version>
</dependency>
``` 

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

## Criar secretaria

```http
POST /secretarias
```

---

## Buscar secretarias

```http
GET /secretarias
```

---

## Buscar secretaria por ID

```http
GET /secretarias/{id}
```

---

## Editar secretaria

```http
PUT /secretarias/{id}
```

---

## Deletar secretaria

```http
DELETE /secretarias/{id}
```

## Criar aluno

```http
POST /secretarias/alunos
```

---

## Buscar alunos

```http
GET /secretarias/alunos
```

---

## Buscar aluno por ID

```http
GET /secretarias/alunos/{id}
```

---

## Editar aluno

```http
PUT /secretarias/alunos/{id}
```

---

## Buscar alunos por tag

```http
GET /secretarias/alunos/tags?tag=Java
```

---

## Visualizar currículo

```http
GET /secretarias/alunos/{id}/curriculo
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
## Baixar currículo PDF

```http
GET /secretarias/alunos/{id}/curriculo/download
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
- Melhorar layout do PDF
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