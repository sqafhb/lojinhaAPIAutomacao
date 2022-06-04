# Lojinha API Automação

Esse é um reporiório que contem a automação de alguns testes de API Rest de um software denominado Lojinha, criado em acompanhamento com as aulas do Módulo 9 do Programa de Testes e Qualidade de Software (PTQS), curso criado e ministrado por [Julio de Lima](https://github.com/juliointest). 
Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java
https://www.oracle.com/br/java/technologies/javase/javase8u211-later-archive-downloads.html

- Jackson
https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.13.2.2

- JUnit
https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.7.1

- RestAssured
https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.1.0

- Maven
https://maven.apache.org/

## Testes Automatizados

Testes para validar as partições de equivalencia relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$0,01 e R$7.000,00.

## Notas Gerais

 - Sempre utilizamos a anotação Before Each para capturar o token que será utilizado posteriormente nos métodos de test
 - Armazenamos os dados que são enviados para a API através do uso de classes POJO
 - Criamos dados iniciais através do uso de classes Data Factory, para facilitar a criação e controle dos mesmos
 - Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em portugues para nossos testes
