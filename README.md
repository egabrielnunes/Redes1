# Projeto de Redes1 - Sistema de Localização de pontos de interesse
### Eduardo Gabriel Nunes de Farias

Esse projeto é um sistema de localização e cadastro de pontos de interesse. Existem inicialmente dois módulos, o de usuário comum onde existe apenas as funcionalidades de listagem e o módulo de administrador, onde se pode além das funcionalidades do usuário comum é possivel adicionar e remover os pontos.

## Funcionalidades

1. Cadastro de ponto de interesse 
2. Cadastrar novos usuários 
3. Listar todos os usuários do sistema
4. Deleção de ponto de interesse
5. Listagem de todos os pontos de interesse
6. Listagem de pontos de interesse por tipo (Supermercados, Hospitais, Restaurantes e Escolas)
7. Listagem de pontos de interesse por coordenadas
8. Alterar o raio de busca de pontos de interesse

O Projeto é escrito em Java e utilizada Banco de Dados Mysql, no repositório existe um passo a passo para configuração do banco. É utilizado também um servidor local, rodando com threads para que mais de um cliente possa acessar e manipular as informações. O servidor está fazendo a ligação do cliente com o padrão de projeto Facede. 

## Passo a passo

1. Configurar o banco mysql conforme descrito no arquivo: Configuração Mysql.txt
2. Executar a classe chamada Server 
3. Executar a classe chamada Cliente 

## Dificuldades

A principal dificuldade foi a pouca prática em trabalhar com sockets, já fazia algum tempo em que eu não implementava nada relaciondo. Gostaria de deixar o banco um pouco mais otimizado, de uma fosse necessário uma passo a passo para a configuração. Caso tivesse um pouco mais de tempo, eu gostaria de tratar todas as exceções que uma interface em comand line trás e até mesmo fazer um interface web ou desktop. Outra dificuldade foi encontrar uma dupla para fazer o projeto, visto que não encontrei, fiz o projeto sozinho. 
