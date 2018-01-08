Feature: Deletar pontos de coleta
  As a membro da empresa coletora
  I want to deletar pontos de coleta
  so that eles sejam apagados do sistema
#GUI
  Scenario: Deletar ponto de coleta interrompido
    Given Estou na pagina de visualizacao do ponto de coleta com nome "RU"
    When Eu seleciono a opcao para remocao do ponto de coleta com nome "RU" 
    Then Eu visualizo o ponto com o nome "RU" na pagina de listagem

  Scenario: Deletar ponto de coleta
    Given Estou na pagina de visualizacao do ponto de coleta com nome "RU" e data "20/09/1996"
    When Eu escolho a opcao para remover o ponto de coleta com nome "RU" e data "20/09/1996"
    Then Eu nao visualizo mais o ponto com o nome "RU" e data "20/09/1996" na pagina de listagem
#CONTROLADOR

  Scenario: Deletar pontos de coleta
	Given O sistema possui o ponto de coleta com nome "RU"
	When Eu deleto o ponto de coleta com nome "RU" 
	Then O sistema nao possui mais o ponto de coleta com nome "RU"
	
  

