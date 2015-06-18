package xeredi.integra.http.page.metamodelo;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoEditPage.
 */
public final class EntidadGrupoDatoEditPage extends FluentPage {

    /**
     * Instantiates a new entidad grupo dato edit page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public EntidadGrupoDatoEditPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto create page.
     *
     * @return the entidad grupo dato edit page
     */
    public EntidadGrupoDatoEditPage gotoCreatePage() {
        linkHref("#/metamodelo/engd/edit/create").click();

        return this;
    }

    /**
     * Goto edit page.
     *
     * @return the entidad grupo dato edit page
     */
    public EntidadGrupoDatoEditPage gotoEditPage() {
        linkHref("#/metamodelo/engd/edit/edit").click();

        return this;
    }

    /**
     * Sets the numero.
     *
     * @param numero
     *            the numero
     * @return the entidad grupo dato edit page
     */
    public EntidadGrupoDatoEditPage setNumero(final String numero) {
        setInput("vm.engd.numero", numero);

        return this;
    }

}
