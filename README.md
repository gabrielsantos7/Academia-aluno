
# Projeto SpringBoot da Unidade 2 🚀

Projeto proposto como conteúdo avaliativo da Unidade II na disciplina de linguagem de programação, ministrada pelo professor Marcos Prado. Nesta etapa do projeto, foram incorporadas novas funcionalidades e melhorias, trazendo maior flexibilidade e escalabilidade ao sistema.

## Novas Funcionalidades Incorporadas 🆕

Nesta segunda Unidade, foram implementadas as seguintes funcionalidades:

1. **Conexão com Banco de Dados MySQL:** O sistema migrou do armazenamento em um ArrayList para a conexão com um banco de dados MySQL. Isso permite uma maior persistência dos dados e facilita a manipulação das informações dos alunos.
2. **Classes de Domínio Avaliacao e Endereço:** Foram criadas duas novas classes de domínio, Avaliacao e Endereço, que são atributos dos objetos Aluno. Agora é possível armazenar informações sobre as avaliações dos alunos e seus respectivos endereços de forma estruturada.
3. **Relacionamento entre Tabelas:** Para refletir o relacionamento entre as tabelas no banco de dados, foram utilizadas anotações específicas nas classes. Isso permite estabelecer o relacionamento entre as tabelas e realizar consultas complexas envolvendo as informações dos alunos, avaliações e endereços.
4. **Pacotes adicionais: exception, handler e requests:** Foram criados três novos pacotes:
   * **exception:** Contém classes personalizadas de exceções, proporcionando um tratamento mais adequado de erros e exceções específicas do sistema.
   * **handler:** Responsável por tratar as exceções específicas que podem ocorrer durante a execução do projeto, oferecendo uma melhor gerência de erros e tratamentos específicos em casos de falhas.
   * **requests:** Contém classes relacionadas à manipulação das requisições recebidas do front-end, que realizam o mapeamento para os objetos de domínio.

## Como Utilizar o Projeto 🛠

1. Clone o repositório do projeto em sua máquina local.
2. Importe o projeto em sua IDE preferida.
3. Certifique-se de ter o Java Development Kit (JDK) instalado.
4. Execute a aplicação SpringBoot, através da classe principal AcademiaAlunosApplication.
5. Acesse os endpoints disponíveis para interagir com as funcionalidades do projeto.
6. Utilize ferramentas como Postman ou Thunder-Client (extensão do Visual Studio Code) para simular as requisições e interagir com o sistema.
7. Explore as funcionalidades disponíveis para listar, buscar, salvar, atualizar e apagar objetos Aluno, aproveitando as melhorias proporcionadas pela conexão com o banco de dados e as classes de domínio adicionadas.
