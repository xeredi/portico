package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroDetailPage.
 */
public final class TipoSubparametroDetailPage extends FluentPage {

    /**
     * Instantiates a new tipo subparametro detail page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public TipoSubparametroDetailPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the tipo subparametro detail page
     */
    public TipoSubparametroDetailPage gotoPage() {
        linkHref("#/metamodelo/tpsp/detail").click();

        return this;
    }
}
