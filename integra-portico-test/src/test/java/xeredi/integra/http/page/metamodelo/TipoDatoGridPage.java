package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoGridPage.
 */
public final class TipoDatoGridPage extends FluentPage {

    /**
     * Instantiates a new tipo dato grid page.
     *
     * @param webDriver
     *            the web driver
     * @param fluentWebDriver
     *            the fluent web driver
     */
    public TipoDatoGridPage(final WebDriver webDriver, final FluentWebDriver fluentWebDriver) {
        super(webDriver, fluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the tipo dato grid page
     */
    public TipoDatoGridPage gotoPage() {
        linkHref("#/metamodelo/tpdt/grid").click();

        return this;
    }

    /**
     * Sets the criterio codigo.
     *
     * @param codigo
     *            the codigo
     * @return the tipo dato grid page
     */
    public TipoDatoGridPage setCriterioCodigo(final String codigo) {
        setInput("vm.tpdtCriterio.codigo", codigo);

        return this;
    }

    /**
     * Sets the criterio nombre.
     *
     * @param nombre
     *            the nombre
     * @return the tipo dato grid page
     */
    public TipoDatoGridPage setCriterioNombre(final String nombre) {
        setInput("vm.tpdtCriterio.nombre", nombre);

        return this;
    }

    /**
     * Sets the criterio tpel.
     *
     * @param tpel
     *            the tpel
     * @return the tipo dato grid page
     */
    public TipoDatoGridPage setCriterioTpel(final TipoElemento tpel) {
        selectValue("vm.tpdtCriterio.tpel", "string:" + tpel.name());

        return this;
    }

    /**
     * Sets the criterio tpht.
     *
     * @param tpht
     *            the tpht
     * @return the tipo dato grid page
     */
    public TipoDatoGridPage setCriterioTpht(final TipoHtml tpht) {
        selectValue("vm.tpdtCriterio.tpht", "string:" + tpht.name());

        return this;
    }

}
