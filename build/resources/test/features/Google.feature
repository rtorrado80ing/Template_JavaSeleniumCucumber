@Grid
Feature: Navegacion en Google
  Como usuario de internet
  Quiero poder navegar en Google
  Para encontrar información relevante

  @Test
  Scenario: Busqueda en Google
    Given que estoy en la pagina principal de Google
    When escribo la palabra en el cuadro de busqueda
    And presiono la tecla Enter
    Then deberia ver los resultados de la busqueda