package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.test.comun.FluentPage;

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

    /**
     * Sets the cmd alta.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setCmdAlta(final Boolean value) {
        selectValue("vm.enti.cmdAlta", value);

        return this;
    }

    /**
     * Sets the cmd baja.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setCmdBaja(final Boolean value) {
        selectValue("vm.enti.cmdBaja", value);

        return this;
    }

    /**
     * Sets the cmd edicion.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setCmdEdicion(final Boolean value) {
        selectValue("vm.enti.cmdEdicion", value);

        return this;
    }

    /**
     * Sets the cmd duplicado.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setCmdDuplicado(final Boolean value) {
        selectValue("vm.enti.cmdDuplicado", value);

        return this;
    }

    /**
     * Sets the gis.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setGis(final Boolean value) {
        selectValue("vm.enti.gis", value);

        return this;
    }

    /**
     * Sets the puerto.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setPuerto(final Boolean value) {
        selectValue("vm.enti.puerto", value);

        return this;
    }

    /**
     * Sets the i18n.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setI18n(final Boolean value) {
        selectValue("vm.enti.i18n", value);

        return this;
    }

    /**
     * Sets the temp exp.
     *
     * @param value
     *            the value
     * @return the tipo parametro edit page
     */
    public TipoParametroEditPage setTempExp(final Boolean value) {
        selectValue("vm.enti.tempExp", value);

        return this;
    }
}
