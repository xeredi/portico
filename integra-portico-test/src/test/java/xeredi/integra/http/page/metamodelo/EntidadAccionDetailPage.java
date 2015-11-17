package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionDetailPage.
 */
public final class EntidadAccionDetailPage extends FluentPage {

    /**
     * Instantiates a new entidad accion detail page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadAccionDetailPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the entidad accion detail page
     */
    public EntidadAccionDetailPage gotoPage() {
        linkHref("#/metamodelo/enac/detail").click();

        return this;
    }
}
