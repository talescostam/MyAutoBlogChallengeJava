# MyAutoBlogChallenge (Java)

### Requisitos de sistema
* JDK 11;
* Maven;
* IDE ou editor de texto de preferência;
* Postman ou ferramenta de preferência para interação com APIs;
* Conta Github.

### Descrição do desafio 
Neste desafio serão avaliados os conhecimentos do candidato no campo do desenvolvimento de sistemas Web, código limpo e otimização. Destacando-se o conhecimento das seguintes tecnologias:

- Java;
- Spring Boot;
- API RESTFul;
- JWT;
- Conexão e manipulação de banco de dados com Spring Data JPA.

O objetivo desta tarefa é a manutenção de um sistema que armazena usuários e suas respectivas postagens, para tal, serão requeridas tarefas em uma api RESTful em Spring Boot. A persistência dos dados é feita com uma base H2 em memória integrada na própria aplicação. 

A seguir serão descritos os requisitos do sistema proposto.

### Requisitos

Usuários:
Os requisitos desse módulo estão implementados, porém ainda é necessário corrigir um bug relacionado à validação do email durante o cadastro. Ocorre que quando um novo usuário tenta se registrar, o sistema impede o cadastro dizendo que o email já está sendo usado mesmo não sendo o caso.

- A comunicação entre as requisições da aplicação devem ser realizadas utilizando-se o formato JSON.
- Usuário deve ser capaz de cadastrar-se no sistema provendo as informações básicas de nome, email e senha. Não deve ser possível a existência de dois usuários de ids diferentes com o mesmo endereço de email.
- Usuário deve ser capaz de logar-se no sistema fornecendo email e senha.
  - Resposta da api deve conter um token JWT que será utilizado para acesso a rotas privadas.
- O usuário deverá realizar operações privadas na aplicação utilizando-se de um mecanismo de Bearer Token que deve ser enviado através de header nas requisições de listagem, criação, edição, exclusão de postagens.

Postagens:
Todos os requisitos desse módulo precisam ser implementados.

-   Usuário deve ser capaz de criar postagens contendo título, texto da postagem; além destes campos, a hora de criação da postagem também deve ser armazenada, porém, esta deve ser obtida de forma automatizada.
-   Usuário deve ser capaz de listar as postagens disponíveis criadas por ele e por outros usuários da aplicação.
-   Usuário deve ser capaz de editar atributos de uma postagem que tenha criado com exceção dos campos id e data de criação da postagem.
-   Usuário deve ser capaz de excluir uma postagem que tenha criado.

Atenção:
Rotas de criação/ listagem/ update/remoção de postagens devem ser implementadas de forma privada sendo acessíveis somente através de passagem de token de autenticação no header Authorization da requisição.

### Rotas da aplicação
Para facilitar o entendimento do desafio proposto, abaixo uma sugestão para as rotas da aplicação:

```
- [POST] {{baseURL}}/users = Rota de criação de usuários 
- [POST {{baseURL}}/users/signIn = Rota de autenticação de usuários 
- [GET {{baseURL}}/users/logged = Rota de consulta do usuário logado 
- [GET] {{baseURL}}/posts = Rota de listagem de posts do usuário 
- [POST] {{baseURL}}/posts = Rota de criação de posts do usuário 
- [PUT] {{baseURL}}/posts/:postId = Rota para atualização de posts do usuário 
- [DELETE] {{baseURL}}/posts/:postId = Rota para exclusão de posts do usuário
```

Para facilitar as consultas foi colocada uma collection do postman contendo todas essas rotas na pasta resources/postman da aplicação, basta importa-las.  

