package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoEditPage.
 */
public final class EntidadTipoDatoEditPage extends FluentPage {

    /**
     * Instantiates a new entidad tipo dato edit page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadTipoDatoEditPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage gotoCreatePage() {
        linkHref("#/metamodelo/entd/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage gotoEditPage() {
        linkHref("#/metamodelo/entd/edit/edit").click();

        return this;
    }

    /**
     * Sets the tpdt.
     *
     * @param tpdt
     *            the tpdt
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setTpdt(final TipoDato tpdt) {
        selectValue("vm.entd.tpdt.id", "number:" + tpdt.getId());

        return this;
    }

    /**
     * Sets the valor defecto.
     *
     * @param valorDefecto
     *            the valor defecto
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setValorDefecto(final String valorDefecto) {
        setInput("vm.entd.valorDefecto", valorDefecto);

        return this;
    }

    /**
     * Sets the grupo.
     *
     * @param grupo
     *            the grupo
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setGrupo(final String grupo) {
        setInput("vm.entd.grupo", grupo);

        return this;
    }

    /**
     * Sets the fila.
     *
     * @param fila
     *            the fila
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setFila(final String fila) {
        setInput("vm.entd.fila", fila);

        return this;
    }

    /**
     * Sets the orden.
     *
     * @param orden
     *            the orden
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setOrden(final String orden) {
        setInput("vm.entd.orden", orden);

        return this;
    }

    /**
     * Sets the span.
     *
     * @param span
     *            the span
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setSpan(final String span) {
        setInput("vm.entd.span", span);

        return this;
    }

    /**
     * Sets the obligatorio.
     *
     * @param obligatorio
     *            the obligatorio
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setObligatorio(final Boolean value) {
        selectValue("vm.entd.obligatorio", value);

        return this;
    }

    /**
     * Sets the gridable.
     *
     * @param gridable
     *            the gridable
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setGridable(final Boolean value) {
        selectValue("vm.entd.gridable", value);

        return this;
    }

    /**
     * Sets the filtrable.
     *
     * @param filtrable
     *            the filtrable
     * @return the entidad tipo dato edit page
     */
    public EntidadTipoDatoEditPage setFiltrable(final Boolean value) {
        selectValue("vm.entd.filtrable", value);

        return this;
    }
}
