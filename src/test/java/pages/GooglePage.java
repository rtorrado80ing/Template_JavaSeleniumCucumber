package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.BasePage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GooglePage extends BasePage {

    Logger logger = Logger.getLogger("GooglePage");

    //Se crean elementos
    private final By TXT_SEARCH = By.name("q");
    private final By PRIMER_RESULTADO = By.xpath("//*[contains(text(),'Naruto - Wikipedia')]");

    //Se crea constructor
    public GooglePage() {
        super(driver);
    }

    //Busqueda en el navegador
    public void navegateToGoogle(String url) {
        BasePage.navegateTo(url);
    }

    //Se ingresa criterio de busqueda
    public void inputSearch(String texto) {
        try {
            escribir(TXT_SEARCH, texto);
        } catch (Exception e) {
            logger.log(Level.INFO, "El WebElement TXT_SEARCH No se encontro", e);
        }
    }

    //Se da ENTER
    public void enter() {
        try {
            enter(TXT_SEARCH);
        } catch (Exception e) {
            logger.log(Level.INFO, "El WebElement TXT_SEARCH No se encontro", e);
        }
    }

    public String primerResultado() {
        return obtenerTexto(PRIMER_RESULTADO);
    }
}
