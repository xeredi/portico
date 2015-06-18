package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroEditPage.
 */
public final class TipoParametroEditPage extends FluentPage {

    /**
     * Instantiates a new tipo parametro edit page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public TipoParametroEditPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage gotoCreatePage() {
        linkHref("#/metamodelo/tppr/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage gotoEditPage() {
        linkHref("#/metamodelo/tppr/edit/edit").click();

        return this;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo
     *            the codigo
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setCodigo(final String codigo) {
        setInput("vm.enti.codigo", codigo);

        return this;
    }

    /**
     * Sets the max grid.
     *
     * @param maxGrid
     *            the max grid
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setMaxGrid(final String maxGrid) {
        setInput("vm.enti.maxGrid", maxGrid);

        return this;
    }

}
