package xeredi.integra.http.page.seguridad;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import xeredi.integra.test.comun.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAccesoPage.
 */
public final class UsuarioAccesoPage extends FluentPage {

    /**
     * Instantiates a new usuario acceso page.
     *
     * @param awebDriver
     *            the aweb driver
     * @param afluentWebDriver
     *            the afluent web driver
     */
    public UsuarioAccesoPage(final WebDriver awebDriver, final FluentWebDriver afluentWebDriver) {
        super(awebDriver, afluentWebDriver);
    }

    /**
     * Goto page.
     *
     * @return the usuario acceso page
     */
    public final UsuarioAccesoPage gotoPage() {
        webDriver.get("http://127.0.0.1:8080/web");

        return this;
    }

    /**
     * Sets the usuario.
     *
     * @param login
     *            the login
     * @return the usuario acceso page
     */
    public UsuarioAccesoPage setUsuario(final String login) {
        setInput("vm.usro.login", login);

        return this;
    }

    /**
     * Sets the contrasenia.
     *
     * @param contrasenia
     *            the contrasenia
     * @return the usuario acceso page
     */
    public UsuarioAccesoPage setContrasenia(final String contrasenia) {
        setInput("vm.usro.contrasenia", contrasenia);

        return this;
    }

    /**
     * Click acceso.
     *
     * @return the usuario acceso page
     */
    public final UsuarioAccesoPage clickAcceso() {
        button("vm.acceso()").click();

        return this;
    }
}
