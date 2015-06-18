package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoEditPage.
 */
public final class TipoDatoEditPage extends FluentPage {

    /**
     * Instantiates a new tipo dato edit page.
     *
     * @param webDriver
     *            the web driver
     * @param fluentWebDriver
     *            the fluent web driver
     */
    public TipoDatoEditPage(final WebDriver webDriver, final FluentWebDriver fluentWebDriver) {
        super(webDriver, fluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage gotoCreatePage() {
        linkHref("#/metamodelo/tpdt/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage gotoEditPage() {
        linkHref("#/metamodelo/tpdt/edit/edit").click();

        return this;
    }

    /**
     * Sets the codigo.
     *
     * @param codigo
     *            the codigo
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage setCodigo(final String codigo) {
        setInput("vm.tpdt.codigo", codigo);

        return this;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *            the nombre
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage setNombre(final String nombre) {
        setInput("vm.tpdt.nombre", nombre);

        return this;
    }

    /**
     * Sets the tpel.
     *
     * @param tpel
     *            the tpel
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage setTpel(final TipoElemento tpel) {
        selectValue("vm.tpdt.tipoElemento", "string:" + tpel.name());

        return this;
    }

    /**
     * Sets the tpht.
     *
     * @param tpht
     *            the tpht
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage setTpht(final TipoHtml tpht) {
        selectValue("vm.tpdt.tpht", "string:" + tpht.name());

        return this;
    }

    /**
     * Sets the enti.
     *
     * @param enti
     *            the enti
     * @return the tipo dato edit page
     */
    public TipoDatoEditPage setEnti(final Entidad enti) {
        selectValue("vm.tpdt.enti.id", "number:" + enti.getId());

        return this;
    }
}
