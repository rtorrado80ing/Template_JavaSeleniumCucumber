package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.BasePage;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //Donde están los features
        glue = "steps", //Donde están las definiciones de los steps
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-reports.json"},//Genera el reporte
        monochrome = true,
        tags = ""

)
public class BusquedaGoogleRunner {
    @AfterClass
    public static void cerrarNavegador() {
        BasePage.closeNavegate();
    }
}
