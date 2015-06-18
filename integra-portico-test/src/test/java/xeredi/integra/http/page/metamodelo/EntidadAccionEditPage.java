package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionEditPage.
 */
public final class EntidadAccionEditPage extends FluentPage {

    /**
     * Instantiates a new entidad accion edit page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadAccionEditPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the entidad accion edit page
     */
    public EntidadAccionEditPage gotoCreatePage() {
        linkHref("#/metamodelo/enac/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the entidad accion edit page
     */
    public EntidadAccionEditPage gotoEditPage() {
        linkHref("#/metamodelo/enac/edit/edit").click();

        return this;
    }

    /**
     * Sets the path.
     *
     * @param path
     *            the path
     * @return the entidad accion edit page
     */
    public EntidadAccionEditPage setPath(final String path) {
        setInput("vm.enac.path", path);

        return this;
    }

    /**
     * Sets the orden.
     *
     * @param orden
     *            the orden
     * @return the entidad accion edit page
     */
    public EntidadAccionEditPage setOrden(final String orden) {
        setInput("vm.enac.orden", orden);

        return this;
    }

}
