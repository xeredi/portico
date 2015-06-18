package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGrupoEditPage.
 */
public final class EntidadAccionGrupoEditPage extends FluentPage {

    /**
     * Instantiates a new entidad accion grupo edit page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadAccionGrupoEditPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the entidad accion edit page
     */
    public EntidadAccionGrupoEditPage gotoCreatePage() {
        linkHref("#/metamodelo/enag/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the entidad accion edit page
     */
    public EntidadAccionGrupoEditPage gotoEditPage() {
        linkHref("#/metamodelo/enag/edit/edit").click();

        return this;
    }

    /**
     * Sets the path.
     *
     * @param path
     *            the path
     * @return the entidad accion edit page
     */
    public EntidadAccionGrupoEditPage setPath(final String path) {
        setInput("vm.enag.path", path);

        return this;
    }

    /**
     * Sets the orden.
     *
     * @param orden
     *            the orden
     * @return the entidad accion edit page
     */
    public EntidadAccionGrupoEditPage setOrden(final String orden) {
        setInput("vm.enag.orden", orden);

        return this;
    }

}
