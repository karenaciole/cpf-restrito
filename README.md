## Desafio Técnico Backend

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
