package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridDetailPage.
 */
public final class EntidadAccionGridDetailPage extends FluentPage {
    /**
     * Instantiates a new entidad accion grid detail page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadAccionGridDetailPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the entidad accion grid detail page
     */
    public EntidadAccionGridDetailPage gotoPage() {
        linkHref("#/metamodelo/enag/detail").click();

        return this;
    }
}
