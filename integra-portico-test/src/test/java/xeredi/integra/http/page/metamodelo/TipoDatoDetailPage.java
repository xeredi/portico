package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoDetailPage.
 */
public final class TipoDatoDetailPage extends FluentPage {

    /**
     * Instantiates a new tipo dato detail page.
     *
     * @param webDriver
     *            the web driver
     * @param fluentWebDriver
     *            the fluent web driver
     */
    public TipoDatoDetailPage(final WebDriver webDriver, final FluentWebDriver fluentWebDriver) {
        super(webDriver, fluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the tipo dato detail page
     */
    public TipoDatoDetailPage gotoPage() {
        linkHref("#/metamodelo/tpdt/detail").click();

        return this;
    }

}
