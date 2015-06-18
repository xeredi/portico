package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroGridPage.
 */
public final class TipoParametroGridPage extends FluentPage {

    /**
     * Instantiates a new tipo parametro grid page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public TipoParametroGridPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the tipo parametro grid page
     */
    public TipoParametroGridPage gotoPage() {
        linkHref("#/metamodelo/tppr/grid").click();

        return this;
    }

}
