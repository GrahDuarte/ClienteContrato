
# Atividade de Mapeamento Objeto-Relacional

## Descrição da Tarefa

A presente tarefa tem como objetivo fixar o conteúdo abordado sobre Mapeamento Objeto-Relacional envolvendo relacionamentos. O objetivo é produzir um programa Java sem interface gráfica com o usuário que permita operações elementares (CRUD) em um banco de dados, considerando as entidades Cliente e Contrato.

## Estrutura

O projeto deve contemplar as seguintes operações em banco de dados:

1.  Inclusão de entidades Cliente
2.  Atualização de entidades Cliente
3.  Consulta por entidade Cliente específica
4.  Consulta por todas as entidades Cliente persistidas
5.  Remoção de entidade Cliente específica
6.  Inclusão de entidades Contrato
7.  Atualização de entidades Contrato
8.  Consulta por entidade Contrato específica
9.  Consulta por todas as entidades Contrato persistidas
10.  Remoção de entidade Contrato específica



## Banco de Dados

O banco de dados utilizado possui a seguinte estrutura:

Tabela Cliente:

-   id: bigint (chave primária)
-   cpf: bigint (único)
-   nome: varchar(45)

Tabela Contrato:

-   id: bigint (chave primária)
-   cliente_id: bigint (chave estrangeira referenciando a tabela Cliente)
-   redacao: text (<= 100000)
-   ultima_atualizacao: date

## Execução dos Testes

Para executar os testes de persistência, siga as instruções abaixo:

1.  Clone o repositório do projeto a partir do seguinte link: [link do repositório](https://github.com/GrahDuarte/ClienteContrato.git).
2.  Certifique-se de ter um banco de dados configurado e atualize as informações de conexão no código, se necessário.
3.  Execute a classe Main.java para realizar os testes de persistência.

## Resultados

Ao executar os testes, você verá os resultados das operações de CRUD em banco de dados para as entidades Cliente e Contrato. Certifique-se de que todas as operações estejam funcionando corretamente e que os resultados sejam consistentes.

## Contato

Se você tiver alguma dúvida ou precisar de mais informações, entre em contato pelo e-mail: [gdd@aluno.ifnmg.edu.br](mailto:gdd@aluno.ifnmg.edu.br).

## Observações

-   Certifique-se de fornecer informações de conexão válidas para o banco de dados no código.
-   Os exemplos de dados utilizados nos testes são apenas ilustrativos. Você pode adaptá-los conforme necessário.
