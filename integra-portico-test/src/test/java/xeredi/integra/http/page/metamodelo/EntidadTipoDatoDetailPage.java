package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoDetailPage.
 */
public final class EntidadTipoDatoDetailPage extends FluentPage {

    /**
     * Instantiates a new entidad tipo dato detail page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadTipoDatoDetailPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the entidad tipo dato detail page
     */
    public EntidadTipoDatoDetailPage gotoPage() {
        linkHref("#/metamodelo/entd/detail").click();

        return this;
    }
}
