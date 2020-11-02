# Controle de Estoque - Projeto de treinamento

* Backend - Spring Boot
* Frontend - React

## Tecnologias

* Java 11
* Node 12

## Dependencias do backend

* Lombok
* Spring Data JPA
* Spring Web
* H2 Database

## Dependencias do frontend

* Axios
* Material UI
* React

## Instruções para execução

* Backend

- Para executar a aplicação, primeiramente é necessário baixar suas dependencias
- Com as dependencias baixadas basta executar o Run da aplicação em sua IDE ou pelo terminal executar:

cd ~/DIRETORIO_DO_USUARIO/controle_estoque/backend/ && mvn spring-boot:run

- O banco de dados ser criado em memória e para acessá-lo basta acessar http://localhost:9090/h2-console

* Frontend

- Para executar o frontend também é necessário fazer o download de suas dependencias

cd ~/DIRETORIO_DO_USUARIO/controle_estoque/frontend/ 

&& 

yarn install OU npm install

Em seguida:

yarn start

- A aplicação será executada na porta 3000 e para acessa-la http://localhost:3000

## Considerações

- O sistema de login não foi concluido.
- Devido ao curto espaço de tempo alguns requisitos não funcionais não foram implementados como responsividade.
- Para criar o banco no disco é necessário inserir uma pequena configuração do h2, então será gerado o arquivo com o script de criação do banco.

## Justificativa da escolha das tecnologias

- Spring Boot - Familiaridade com a tecnologia e requisito
- React - Familiaridade
- Banco H2 - Praticidade, essa tecnologia agiliza muito no desenvolvimento de sistemas, como este projeto é pequeno, o banco h2 atendeu perfeitamente aos propósitos
- Material UI - Praticidade, qualidade do framework
