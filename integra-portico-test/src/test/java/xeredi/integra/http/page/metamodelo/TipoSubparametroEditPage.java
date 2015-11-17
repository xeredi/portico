package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroEditPage.
 */
public final class TipoSubparametroEditPage extends FluentPage {

    /**
     * Instantiates a new tipo subparametro edit page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public TipoSubparametroEditPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the tipo subparametro edit page
     */
    public TipoSubparametroEditPage gotoCreatePage() {
        linkHref("#/metamodelo/tpsp/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the tipo subparametro edit page
     */
    public TipoSubparametroEditPage gotoEditPage() {
        linkHref("#/metamodelo/tpsp/edit/edit").click();

        return this;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo
     *            the codigo
     * @return the tipo subparametro edit page
     */
    public TipoSubparametroEditPage setCodigo(final String codigo) {
        setInput("vm.enti.codigo", codigo);

        return this;
    }

    /**
     * Sets the max grid.
     *
     * @param maxGrid
     *            the max grid
     * @return the tipo subparametro edit page
     */
    public TipoSubparametroEditPage setMaxGrid(final String maxGrid) {
        setInput("vm.enti.maxGrid", maxGrid);

        return this;
    }

    /**
     * Sets the tppr asociado.
     *
     * @param enti
     *            the enti
     * @return the tipo subparametro edit page
     */
    public TipoSubparametroEditPage setTpprAsociado(final Entidad enti) {
        selectValue("vm.enti.tpprAsociado.id", "number:" + enti.getId());

        return this;
    }

}
