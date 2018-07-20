Feature: Criar Usuario
  As a administrador do sistema ResS
  I want to criar usuario
  so that ele seja cadastrado
  
  
  Scenario: Criar Usuario(controller)
  	Given nao existe um usuario armazenado no sistema com nome "Maria" e login "mariasilva"
  	When crio um usuario no sistema com nome "Maria", login "mariasilva" e id "2"
  	Then existe apenas um usuario armazenado no sistema com o nome "Maria" e login "mariasilva"
 
  Scenario: Criar Usuario Repetido (controller)
  	Given existe um usuario armazenado no sistema com nome "Jose" e login "josevieira"
  	When crio um usuario no sistema com nome "Jose", login "josevieira" e id "3"
  	Then existe apenas um usuario armazenado no sistema com o nome "Jose" e login "josevieira"