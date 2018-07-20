Feature: Fazer login no sistema
  As a usuario	 
  I want to me logar no sistema
  So that eu consiga ter acesso ao sistema
  
  Scenario: Fazer login no sistema com sucesso
  	Given estou na pagina de login
  	When eu aperto em entrar
  	Then vejo a pagina "home"
  	
  	