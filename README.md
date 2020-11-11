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
    
    
