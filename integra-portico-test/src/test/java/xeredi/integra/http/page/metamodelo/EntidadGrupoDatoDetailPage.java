package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoDetailPage.
 */
public final class EntidadGrupoDatoDetailPage extends FluentPage {

    /**
     * Instantiates a new entidad grupo dato detail page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadGrupoDatoDetailPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the entidad grupo dato detail page
     */
    public EntidadGrupoDatoDetailPage gotoPage() {
        linkHref("#/metamodelo/engd/detail").click();

        return this;
    }
}
