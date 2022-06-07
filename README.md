# Sistema de controle de estações de trabalho (CESAR)

## Totem 

Tecnologia de desenvolvimento: JAVA (JDK 18.0.1.1)

### Arquivos e programas necessários:

0 - Java JDK: No desenvolvimento do presente projeto utilizou-se a JDK na versão 18.0.1.1 (Instalada juntamente com as versões mais recentes do Eclipse)

1 - IDE: Durante o desenvolvimento do projeto foi utilizada a IDE Eclipse (2022-03), disponível em [https://www.eclipse.org/downloads/]

2 - Banco de dados: MariaDB ou MySQL. Durante o desenvolvimento foi utilizado o MariaDB [https://mariadb.org/download/?t=mariadb&p=mariadb&r=10.6.8&os=windows&cpu=x86_64&pkg=msi&m=fder]

3 - JDBC para conexão entre aplicação Java e o Banco de Dados: JDBC (8.0.28) para o sistema Microsoft Windows (Platform Independent) [https://downloads.mysql.com/archives/c-j/]

### Configurações necessárias

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



## Site para realização de reserva

Tecnologias de desenvolvimento: Python 3.10.4, Django 4.0.5, HTML 5, CSS3, Javascript e Bootstrap

### Arquivos e programas necessários

0 - Python: O desenvolvimento do projeto utlizou a versão 3.10.4 da linguagem de programação Python, disponível em [https://www.python.org/downloads/release/python-3104/]

1 - IDE: Durante o desenvolvimento do projeto foi utilizada a IDE Visual Studio Code, disponível em [https://code.visualstudio.com/]

2 - Banco de dados: MariaDB ou MySQL. Durante o desenvolvimento foi utilizado o MariaDB [https://mariadb.org/download/?t=mariadb&p=mariadb&r=10.6.8&os=windows&cpu=x86_64&pkg=msi&m=fder]

### Configurações necessárias

0 - Ter o Python 3.10.4 instalado e adicionado ao Path da máquina em uso

1 - Criar um ambiente virtual e instalar bibliotecas necessárias: 

​	1.0 - Acessar o diretório do projeto do site `Totem/` 

​	1.1 - Executar o comando `py -m venv venv` para criar um ambiente virtual

​	1.2 - Ativar o ambiente virtual por meio do comando `venv/Scripts/activate` (Windows) ou `Source venv/bin/activate` (Linux e MacOS)

​	1.3 - Instalar as bibliotecas necessárias: `pip install -r requirements.txt`

2 - Realizar a migração das tabelas para o Banco de Dados:

​	2.0 - Acessar o diretório do projeto do site `Totem/siteCesar/`

​	2.1 - Com o ambiente virtual ativado (Etapa 1.2), executar os comandos de forma sequencial na pasta do projeto do site: `py manage.py makemigrations` e `py manage.py migrate`

3 - Iniciar o servidor local do Django com o comando `py manage.py runserver`

​	3.0 - O servidor será inicializado na porta 8000, sendo então acessado com `localhost:8000` ou `127.0.0.1:8000` no navegador 

Obs: O comando para uso da linguagem Python poderá não funcionar corretamente dependendo das configurações da máquina utlizada, podendo ser corrigido subistituindo o termo "py" por "python" ou "python3".
