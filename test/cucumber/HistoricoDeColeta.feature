Feature: Gerar historico de coleta
  As a membro da empresa de coleta
  I want to gerar um historico de coletas
  So that eu posso saber o desempenho da minha empresa
  
  Scenario: Criar coleta com nome vazio (controller)
  	Given nao foi criado um relatorio de coleta do dia "05/06/2017" do restaurante ""
  	When crio um novo relatorio no dia "05/06/2017" do restaurante "" com volume "22"
  	Then nao foi criado um relatorio de coleta do dia "05/06/2017" do restaurante ""
  
  Scenario: Acessar o historico de coletas
    Given eu crio uma coleta com nome "RU", data "08/04/2015" e volume "101"
    And estou na pagina Home
    When eu listo as coletas existentes
    Then eu visualizo a coleta com nome "RU", data "08/04/2015" e volume "101"
    
  Scenario: Criar coleta com nome vazio
  	Given estou na pagina de adicionar coleta
  	When eu preencho o campo data com "05/06/2017" e o campo volume com "22"
  	And clico em adicionar coleta do dia
  	Then eu visualizo uma mensagem de erro pedindo que eu preencha o nome da coleta

@ignore
  Scenario: adicionar coleta ja existente
    Given ja existe uma coleta com nome "RU" e data "08/05/2015"
    When tento criar uma nova coleta com nome "RU" e data "08/05/2015"
    Then nao eh criada a nova coleta

@ignore
  Scenario: editar data de restaurante da coleta com nome e data ja existente
    Given ja existe uma coleta com nome "RU" e data "08/05/2015"
    And  existe outra coleta com nome "RU" e data "07/11/2015"
    When tento editar a data "07/11/2015" para "08/05/2015"
    Then a edicao nao sera realizada

@ignore
  Scenario: Adicionar coleta do dia no sistema
    Given estou na pagina de adicionar coleta
    When preencho os campos necessarios com informacoes validas
    And clico em adicionar coleta do dia
    Then eh adicionada com sucesso

  @ignore
  Scenario: Adicionar a pagina de historico de coletas como um cliente
    Given eu estou logado no sistema como um cliente "RU"
    And estou na pagina Home
    When clico no botao "historico de coleta"
    Then apenas coletas do "RU" estara na lista

  @ignore
  Scenario: Acessar o historico de coletas do dia como administrador
    Given eu estou logado no sistema como administrador
    And estou na pagina de historico de coletas
    When clico no botao "filtrar" e escolho a opcao "dia"
    And escolho o dia "08/04/2015"
    Then apenas coletas do dia "08/04/2015" estara na lista

  @ignore
  Scenario: Acessar o historico de coletas geral como administrador
    Given eu estou logado no sistema como administrador
    And estou na pagina Home
    When clico no botao "historico de coleta"
    Then aparecera todas as coletas ja realizadas no sistema

@ignore
  Scenario: Documentar coleta
    Given nao foi criada um relatorio de coleta do dia "08/04/2015" do restaurante "RU"
    When crio um novo relatorio o dia "08/04/2015" do restaurante "RU"
    Then o relatorio eh adicionado ao historico de coletas
@ignore
  Scenario: Editar de coleta do dia
    Given ja foi criado o relatorio de coleta do dia "08/04/2015" do restaurante "RU"
    When altero o valor do volume da coleta para "10"
    Then o valor do volume eh atualizado
@ignore
  Scenario: Apagar coleta
    Given existe uma coleta do dia "08/04/2015" do restaurante "RU"
    When seleciono remover esta coleta
    Then nao existem mais coleta dia "08/04/2015" do restaurante "RU"

@ignore
  Scenario: Editar Coleta GUI
    Given estou na pagina de editar coleta
    When coloco o novo volume "10" a ser adicionado
    And coloco os outros dados corretamente
    And e envio as mudancas
    Then o volume eh alterado com sucesso

@ignore
  Scenario: editar nome de restaurante da coleta com nome e data ja existente
    Given ja existe uma coleta com nome "RU" e data "08/05/2015"
    And  existe outra coleta com nome "cantina" e data "08/05/2015"
    When tento editar o nome "cantina" para "RU"
    Then a edicao nao sera realizada

@ignore
  Scenario: apagar coleta GUI
    Given estou na pagina de listagem de coletas
    And existe uma coleta na listagem
    And seleciono esta coleta
    When aperto o botao Delete
    Then estou na pagina de listagem e esta coleta nao consta mais