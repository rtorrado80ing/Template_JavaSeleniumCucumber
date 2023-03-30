package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;


public class GoogleSteps {

    GooglePage googlePage = new GooglePage();

    @Given("que estoy en la pagina principal de Google")
    public void que_estoy_en_la_pagina_principal_de_google() {
        googlePage.navegateToGoogle("https://www.google.com/");
    }

    @When("escribo la palabra en el cuadro de busqueda")
    public void escribo_la_palabra_en_el_cuadro_de_busqueda() {
        googlePage.inputSearch("Naruto");
    }

    @And("presiono la tecla Enter")
    public void presiono_la_tecla_enter() {
        googlePage.enter();
    }

    @Then("deberia ver los resultados de la busqueda")
    public void deberia_ver_los_resultados_de_la_busqueda() {
        Assert.assertEquals("Naruto - Wikipedia, la enciclopedia libre", googlePage.primerResultado());
    }
}