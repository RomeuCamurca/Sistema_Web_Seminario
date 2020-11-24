# Sistema_Web_Seminario

Sistema de Gerenciamento de Fichas para a Associação Amigos do Seminário - Produzido na Disciplina de Serviços de Redes no Curso Redes de Computadores

Projeto elaborado em 2020.1 - UFC Campus Quixadá

#### Demonstração Funcional:

  * http://50.19.52.15:8080/

  * Login: admin

  * Senha: seminario

#### Tecnologias Utilizadas:

  * Ferramentas de Desenvolvimento
    > Git
  
    > Github
  
    > Eclipse IDE for Enterprise Java Developers
    
  * Front-End
   
    > HTML5
    
    > CSS3
    
    > Bootstrap 4
    
    > Thymeleaf
    
    > Javascript
    
    > Jquery
    
    > Datatables
    
    > Jquery Validation
    
    > Jquery Mask
    
  * back-End
  
    > Java 1.8
    
    > Spring Boot v2.2.7.RELEASE
    
    > Spring Security 4 
    
    > Mysql Server v5.7.31
    
    > JPA
    
    > Hibernate
    
    > Spring MVC
    
  #### As dependência podem ser vistas no arquivo pom.xml
  
  Após o sistema executar a primeira vez, serão criados o banco de dados e as tabelas automaticamente pelo Hibernate. 
  
  Contudo, será criado um usuário padrão com permissão de administrador, pois todas as páginas do Servidor necessitam
  de autenticação para serem acessadas como pode ser visto no SecurityConfig.
  
  Ao acessar o sistema, é necessário se autenticar, portanto logo abaixo está descrito as credenciais do usuário padrão.
  
  #### Execução em Ambiente Linux
  
  Primeiro é necessário que a máquina que rodará o sistema tenha as dependências e softwares necessários:
  
  `$ sudo apt update`
  
  `$ sudo apt upgrade`
  
  `$ sudo apt install mysql-server`
  
  `$ sudo apt install default-jdk`
  
  `$ sudo apt install git`
  
  `$ sudo apt install maven`
  
  Com o mysql instalado na máquina, é necessário portanto configurar o mysql, apesar de o banco e tabelas e o primeiro usuário serem criados
  de forma automática pelo sistema, é pertinente, mas porém opcional fazer a configuração manual para evitar possíveis erros:
  
  `sudo mysql`
  
  `CREATE DATABASE seminario;`
  
  `CREATE USER 'admin'@'localhost' IDENTIFIED BY 'root';`
  
  `SET PASSWORD FOR 'admin'@'localhost' = PASSWORD('429461');`
  
  `GRANT ALL ON seminario.* TO 'admin'@'localhost';`
  
  `FLUSH PRIVILEGES;`
  
  Caso queira realizar a configuração com parametros diferentes, é possível modificar os parametros do banco de dados, que se encontra em:
  
  src/main/resources/application.properties
  
  Neste arquivo de configuração é possível modificar parametros como:
  
  ##### url da conexão com o banco de dados mysql
  spring.datasource.url = jdbc:mysql://localhost:3306/seminario?createDatabaseIfNotExist=true
 
  ##### nome de usuário que realizará a conexão
  spring.datasource.username=admin
  
  ##### senha do usuário que realizará a conexão
  spring.datasource.password=429461
  
  Com o banco de dados já configurado, é necessário portanto clonar o repositório do github:
  
  `$ git clone https://github.com/RomeuCamurca/Sistema_Web_Seminario.git`
  
  Com o repositório clonado, é necessário portanto criar o executável .jar para executa-lo:
  
  `$ cd Sistema_Web_Seminario`
  
  `$ mvn clean package`
  
  O executável .jar estará em: /Sistema_Web_Seminario/target/cadastro-0.0.1-SNAPSHOT.jar
  
  Para executar:
  
  `$ cd target`
  
  `$ java -jar cadastro-0.0.1-SNAPSHOT.jar`
  
  O serviço web se executado localmente estará disponível em: 
  
  * localhost:8080
  
  O serviço web pode estar também com acesso via ip público, um exemplo seria atráves de instâncias Amazon EC2, neste caso:
  
  * ip-público:8080
  
  
  #### CREDENCIAIS DO USUÁRIO PADRÃO:
  LOGIN: admin
  
  SENHA: seminario
  
#### Requisitos do Sistema

Requisito | Descrição 
:----------: | :---------:
Efetuar Login | Autenticação de usuários, conforme regras de permissão de acesso as páginas.
Persistência de dados | Armazenamento dos dados da aplicação em banco de dados. 
Criar fichas | Inserção de fichas via interface web.
Atualizar fichas | Atualização de fichas via interface web.
Deletar fichas | Deletar fichas via interface web.
Visualizar fichas | Visualizar fichas via interface web.
Regra de usuário USER | Permissão de USER, onde usuários com permissão de USER, só podem visualizar as fichas.
Regra de usuário ADMIN | Permissão de ADMIN, onde usuários com permissão de ADMIN, tem acesso para gerenciar fichas e usuários.
Criar Usuários | Inserção de usuários via interface web.
Atualizar Usuários | Atualização de usuários via interface web.
Deletar usuários | Deletar usuários via interface web.
Visualizar usuários | Visualizar usuários via interface web.
Filtragem por paróquia | Busca personalizada por cada paróquia.
Exportar fichas | Exportação de fichas para formatos, PDF, Planilha, CSV. E também impressão das fichas.  
  
  

    
######QUARENTENA#######    
    
    
