Feature: Deletar Geradores de Residuos
  As a administrador do sistema ResS
  I want to deletar geradores de residuos
  so that eles sejam apagados do sistema
  
  Scenario: Deletar gerador de residuos (controller)
  	Given existe um gerador de residuos armazenado no sistema com nome "Restaurante do Zeze" e cnpj "13243546"
  	When deleto o gerador com nome "Restaurante do Zeze" e cnpj "13243546"
  	Then nao existe um gerador de residuos armazenado no sistema com nome "Restaurante do Zeze" e cnpj "13243546"