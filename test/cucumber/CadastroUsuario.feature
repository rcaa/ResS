Feature: Cadastrar usuarios no sistema
  As a usuario	 
  I want to me cadastrar no sistema
  So that eu consiga ter acesso ao sistema
  
  Scenario: Cadastrar usuario no sistema com sucesso
  	Given estou na pagina de criar novo usuario
  	When preencho o nome com "joao", endereco "Av Rui Barbosa", login "abc" e senha "xxxxxx"
  	And aperto em criar
  	Then vejo os detalhes do usuario "joao"
  	
  	