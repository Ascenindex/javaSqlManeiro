# javaSqlManeiro

# Gerenciador de Usuários em Java com MySQL

## Descrição

Este projeto é uma aplicação Java que permite gerenciar usuários em um banco de dados MySQL. Através dessa aplicação, é possível realizar operações como criação, leitura, atualização e exclusão (CRUD) de registros de usuários.

## Funcionalidades

- **Criar Usuário**: Adiciona um novo usuário ao banco de dados.
- **Mostrar Usuários**: Exibe todos os usuários cadastrados.
- **Editar Usuário**: Atualiza os dados de um usuário existente.
- **Excluir Todos os Usuários**: Remove todos os registros de usuários do banco de dados.
- **Resetar IDs de Usuário**: Reinicia a contagem de IDs para o campo `AUTO_INCREMENT`.

## Pré-requisitos

Antes de executar o projeto, você precisará ter:

- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado em sua máquina.
- Um banco de dados MySQL em execução.
- A tabela `usuarios` criada no banco de dados `UsuariosBD`.

### Configuração do Banco de Dados

Execute o seguinte SQL para criar a tabela `usuarios`:

```sql
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

