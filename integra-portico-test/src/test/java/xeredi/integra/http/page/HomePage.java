package xeredi.integra.http.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import xeredi.argo.test.comun.BasePage;
import xeredi.integra.http.page.facturacion.FacturacionPage;

public final class HomePage extends BasePage {

    @FindBy(css = "a[ng-href*='#/servicio']")
    private WebElement linkServicios;

    @FindBy(css = "a[ng-href*='#/estadistica/pepr/grid']")
    private WebElement linkEstadisticas;

    @FindBy(css = "a[ng-href*='#/maestro']")
    private WebElement linkMaestros;

    @FindBy(css = "a[ng-href*='#/facturacion']")
    private WebElement linkFacturacion;

    public HomePage(final WebDriver awebDriver) {
        super(awebDriver);
    }

    public FacturacionPage gotoFacturacion() {
        linkFacturacion.click();

        return new FacturacionPage(webDriver);
    }

}
