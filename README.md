# Biblioteca

Este projeto é uma aplicação de gerenciamento de biblioteca, desenvolvida em Java, que permite a interação com livros e usuários, além de gerenciar empréstimos de livros.

## Estrutura do Projeto

O projeto é organizado da seguinte forma:

- **src/main/java/biblioteca**: Contém as classes principais da aplicação.
  - `Biblioteca.java`: Classe principal que gerencia a aplicação.
  - `Livro.java`: Representa um livro na biblioteca.
  - `Usuario.java`: Representa um usuário da biblioteca.
  - `Emprestimo.java`: Gerencia o empréstimo de livros.

- **src/test/java/biblioteca**: Contém os testes unitários da aplicação.
  - `BibliotecaTest.java`: Implementa testes para as funcionalidades da classe `Biblioteca`.

- **pom.xml**: Arquivo de configuração do Maven, que gerencia as dependências e configurações do projeto.

## Instruções de Instalação

1. Clone o repositório:
   ```
   git clone <URL_DO_REPOSITORIO>
   ```

2. Navegue até o diretório do projeto:
   ```
   cd Biblioteca
   ```

3. Compile o projeto usando Maven:
   ```
   mvn clean install
   ```

## Uso

Para executar a aplicação, utilize o seguinte comando:
```
mvn exec:java -Dexec.mainClass="biblioteca.Biblioteca"
```

## Contribuição

Sinta-se à vontade para contribuir com melhorias e correções. Para isso, crie um fork do repositório, faça suas alterações e envie um pull request.