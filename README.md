# Sistema de controle de estações de trabalho (CESAR)

## Totem 

Tecnologia de desenvolvimento: JAVA (JDK 18.0.1.1)

## Arquivos e programas necessários:

0 - Java JDK: No desenvolvimento do presente projeto utilizou-se a JDK na versão 18.0.1.1 (Instalada juntamente com as versões mais recentes do Eclipse)

1 - IDE: Durante o desenvolvimento do projeto foi utilizada a IDE Eclipse (2022-03), disponível em [https://www.eclipse.org/downloads/]

2 - Banco de dados: MariaDB ou MySQL. Durante o desenvolvimento foi utilizado o MariaDB [https://mariadb.org/download/?t=mariadb&p=mariadb&r=10.6.8&os=windows&cpu=x86_64&pkg=msi&m=fder]

3 - JDBC para conexão entre aplicação Java e o Banco de Dados: JDBC (8.0.28) para o sistema Microsoft Windows (Platform Independent) [https://downloads.mysql.com/archives/c-j/]

## Configurações necessárias

0 - Executar a IDE Eclipse

1 - Carregar o projeto para uma workspace com o JDK 18.0.1.1

2 - Atualizar o caminho do JDBC: 

​	2.0 - Após importação do projeto no eclipse, clicar com o botão direito do mouse sobre o `projeto > Build Path > Configure Build Path...`;

​	2.1 - Selecionar a aba `Libraries`, selecionar `Edit...` e procurar o JDBC baixado nos diretórios do computador;

3 - Configurar o Banco de Dados:

​	3.0 - Acessar o projeto no Eclipse: `Totem/src/model/DBConnection` e verificar as Strings `URL`, `USER` e `PWD`;

​		3.0.0 - Em `URL` apenas verificar a porta do banco de dados `...localhost:3306...`;

​		3.0.1 - Em `USER`, verificar o usuário definido no BD;

​		3.0.2 - Em `PWD`, verificar a senha;

4 - Existe a possibilidade de falha na classe "DBConnection", sendo necessário renomea-la para o correto funcionamento da aplicação. Para renomear: Clique com o botão direito sobre a classe "dbConnection" > Refactor > Rename..., e renomear para "DBConnection";

5 - Executar a aplicação a partir da tela inicial (`Totem/src/view/Inicio.java`);

6 - Após a primeira execução, recomenda-se teclar "Enter" para geração do banco de dados com valores previamente preenchidos com os participantes do desenvolvimento do projeto, caso contrário, o sistema não identificará nenhum "funcionário", permanecendo na tela inicial;

7 - Os "IDs" registrados estarão nas teclas [Q, W, E, R, T, Y, U, I, O];

