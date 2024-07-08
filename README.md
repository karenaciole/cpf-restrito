[English](https://github.com/karenaciole/cpf-restrito/blob/master/README.md#about-the-application)

[PT-BR](https://github.com/karenaciole/cpf-restrito/blob/master/README.md#sobre-a-aplica%C3%A7%C3%A3o)

# About the application

A RESTful API that allows you to validate Brazilian CPF (Cadastro de Pessoa Física) numbers.

**How to build**

```bash
docker build ./ -t cpf-restrito
```

**How to run**

```bash
docker-compose up
```

**How to access**

The application will be available at http://localhost:8080/cpf/

**Tests**

Unit tests were made with the JUnit and Mockito frameworks. To run the tests, just execute the command:

```bash
mvn test
```

**Technologies used**

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker
* Docker Compose
* Maven
* JUnit
* Mockito
* Postman (for request testing)

**Project organization**

The project was organized in layers, being: Controller, Service, Repository and Model. Based on Clean Architecture, it was possible to separate the responsibilities of each layer, making the code cleaner and easier to maintain.

**Choice of technologies**

I chose these technologies because they are the ones I have the most experience with and the ones I use most in my day-to-day work. With the exception of the Mockito test framework and Docker, which I took as a challenge to learn how to use them in this project.

 
## Sobre a aplicação

### Como fazer o build? 
<code>docker build ./ -t cpf-restrito</code>

### Como rodar? 
<code>docker-compose up</code>

### Como acessar?
A aplicação estará disponível em http://localhost:8080/cpf/

### Testes:
Os testes unitários foram feitos com os frameworks JUnit e Mockito. 
Para rodar os testes, basta executar o comando:
<code>mvn test</code>

### Tecnologias utilizadas:
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Docker Compose
- Maven
- JUnit
- Mockito
- Postman (para testes de requisições)

### Organização do projeto:
O projeto foi organizado em camadas, sendo elas: Controller, Service, Repository e Model. Tomando como base a Clean Architecture, foi possível separar as responsabilidades de cada camada, deixando o código mais limpo e de fácil manutenção.

### Escolha das tecnologias:
Escolhi essas tecnologias por serem as que tenho mais experiência e por serem as que mais utilizo no meu dia a dia.
Com exceção do framework de testes Mockito e do Docker, que tomei como desafio para aprender a utilizá-las nesse projeto.
