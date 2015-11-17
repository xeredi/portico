package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailPage.
 */
public final class TipoParametroDetailPage extends FluentPage {
    /**
     * Instantiates a new tipo parametro detail page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public TipoParametroDetailPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the tipo parametro detail page
     */
    public TipoParametroDetailPage gotoPage() {
        linkHref("#/metamodelo/tppr/detail").click();

        return this;
    }
}
