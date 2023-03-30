package utils;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

    protected static WebDriver driver; //Creacion del driver
    private static WebDriverWait wait; //Espera general
    private static Actions action; //Acciones

    static {

        //encontrar archivo exe de chromedriver
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

        //creamos opciones sobre nuestro driver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);//Crear objeto driver
        wait = new WebDriverWait(driver, 60);
    }


    //Se crea constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60); //Espera hasta que se muestre el objeto
    }

    //Abrir navegador
    public static void navegateTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    //Cerrar Navegador
    public static void closeNavegate() {
        driver.quit();
    }

    //Busqueda y espera explicita general
    private WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Resaltar elemento
    public boolean highlight(By locator) {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        WebElement elem = driver.findElement(locator);

        for (int iCnt = 0; iCnt < 3; iCnt++) {
            try {
                js.executeScript("arguments[0].setAttribute('style', 'background:yellow')", elem);
                Thread.sleep(500);
                js.executeScript("arguments[0].setAttribute('style', 'background')", elem);
            } catch (Exception e) {
                System.err.println("JavaScript | Method: highlight | Exception desc: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    //Dar Click en elemento
    public void click(By locator) {
        find(locator).click();
    }

    //Dar doble Click en elemento
    public void dobleClick(By locator) {
        action.doubleClick(find(locator));
    }

    //Dar Click derecho
    public void clickDerecho(By locator) {
        action.contextClick(find(locator));
    }

    //Escribir
    public void escribir(By locator, String texto) {
        find(locator).clear();
        find(locator).sendKeys(texto);
    }

    //Dar ENTER
    public void enter(By locator) {
        find(locator).sendKeys(Keys.ENTER);
    }

    //Seleccionar de la lista por value
    public void seleccionarLista(By locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    //Seleccionar de la lista por index
    public void seleccionarIndex(By locator, int indexToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(indexToSelect);
    }

    //Seleccionar de la lista por texto visible
    public void seleccionarTexto(By locator, String textoToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(textoToSelect);
    }

    //HoverOver Mouse
    public void hoverOverMouse(By locator) {
        action.moveToElement(find(locator));
    }

    //Espera explicita
    public void esperaExplicita(By locator, int tiempo) {
        WebDriverWait wait = new WebDriverWait(driver, tiempo);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Espera implicita
    public void esperaImplicita(int tiempo) {
        // Configurar espera implícita de 10 segundos
        driver.manage().timeouts().implicitlyWait(tiempo, TimeUnit.SECONDS);
    }

    // Esperar hasta que el elemento se desaparezca
    public void esperarDesaparezcaElemento(By locator, int tiempo) {
        WebDriverWait wait = new WebDriverWait(driver, tiempo);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Esperar hasta que el botón sea clickeable
    public void esperarElementoClickeable(By locator, int tiempo) {
        WebElement boton = (new WebDriverWait(driver, tiempo).until(ExpectedConditions.elementToBeClickable(locator)));
        boton.click();
    }

    //Cambiar de frame por index
    public void swithToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    //Cambiar al switch principal
    public void switchToParentsFrame() {
        driver.switchTo().parentFrame();
    }

    //Detecta alerta y la quita
    public void dismissAlerts() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    //Validar texto
    public void validarTexto(By locator, String texto) {
        Assert.assertEquals(texto, find(locator).getText());
    }

    //Obtener texto
    public String obtenerTexto(By locator) {
        return find(locator).getText();
    }

    //Elemento desplegado
    public boolean elementIsDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    //Elemento esta seleccionado
    public boolean elementIsSelected(By locator) {
        return find(locator).isSelected();
    }

    //Elemento esta activo
    public boolean elementIsEnabled(By locator) {
        return find(locator).isEnabled();
    }

    //Encuentra todos los elementos de una lista
    public List<WebElement> todosLosElementos(By locator) {
        return driver.findElements((locator));
    }

   /* @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }*/
}
