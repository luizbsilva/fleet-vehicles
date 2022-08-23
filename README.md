# Desafio Desenvolvedor JAVA
API do Desafio Desenvolvedor JAVA.

### Detalhes da API RESTful
[![Java Version][java-image]][java-url]

A API REST - ful do Desafio Técnico contém as seguintes características:
* Projeto criado com Spring Boot e Java 11
* Banco de dados Postgres com JPA e Spring Data JPA
* Autenticação e autorização com Spring Security e tokens JWT (JSON Web Token)
* Testes unitários e de integração com JUnit e Mockito
* A arquitetura do projeto segue o padrão Hexagonal architecture

### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git e o Docker.


se não tiver o docker instalado siga as intruções da documentação oficial do Docker
https://docs.docker.com/get-docker/


- Clonando o projeto
```
    # git clone https://github.com/luizbsilva/fleet-vehicles.git
    # cd fleet-vehicles
```
Criando Docker do banco de dados via docker compose
```
 #  cd docker
 # docker-compose up --build -d
```

Usuário BD: agence
Senha: agence
Ao executar o comando do docker compose ja sera criado um usuario admim para gerar o token da aplicação
Ao executar o projeto e acesso-lo via url o primeiro passo e autenticar via usuario e senha no end-point authentication-controller no Post /auth
utilizando  login: admin, senha: fleetmg@! adicionar o token  no Autorize botão clicavel no top da pagina.
Apos isso poderar usar todos os end-points sem necessitar de passar to token todas as vezes

URLS:

|Serviço|Url|Swagger/BD|
|-------|---|-------|
|API|http://localhost:8080/|http://localhost:8080/swagger-ui.html|
|DOC|http://localhost:8080/|http://localhost:8080/v2/api-docs|


[java-image]: https://img.shields.io/badge/Java-11-blue?style=flat-square
[java-url]: https://openjdk.java.net/