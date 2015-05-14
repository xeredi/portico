package xeredi.integra.http.controller.action.seguridad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioTest.
 */
public final class UsuarioTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(UsuarioTest.class);

    /** The driver. */
    private final WebDriver driver;

    /**
     * Instantiates a new usuario test.
     */
    public UsuarioTest() {
        super();

        driver = new FirefoxDriver();
    }

    /**
     * Acceso test.
     */
    @Test
    public void accesoTest() {
        driver.get("http://127.0.0.1:8080/web");

        LOG.info("Acceso a la aplicacion");

        driver.findElement(By.cssSelector("input[ng-model='vm.usro.login']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[ng-model='vm.usro.contrasenia']")).sendKeys("admin");

        driver.findElement(By.cssSelector("button[data-ng-click='vm.acceso()']")).click();

        LOG.info("Acceso a maestros");

        driver.findElement(By.cssSelector("a[translate='menu']")).click();
        driver.findElement(By.xpath(".//*[@ng-href='#/maestro']")).click();

        LOG.info("Buques - Grid");

        driver.findElement(By.cssSelector("a[ng-href*='#/maestro/prmt/grid/20005']")).click();

        LOG.info("Buques - Filtro");

        driver.findElement(By.cssSelector("button[data-ng-click*='vm.filter']")).click();
        driver.findElement(By.cssSelector("button[ng-click='$hide()']")).click();

        LOG.info("Buques - Alta");

        driver.findElement(By.cssSelector("a[ng-href*='#/maestro/prmt/edit/create/20005']")).click();
        driver.findElement(By.cssSelector("button[data-ng-click*='vm.save()']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("span[translate='errorList']")).isDisplayed());

        driver.findElement(By.cssSelector("button[data-ng-click*='vm.cancel()']")).click();
        // driver.quit();
    }
}
