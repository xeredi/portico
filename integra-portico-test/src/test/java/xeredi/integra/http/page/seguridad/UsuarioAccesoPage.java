package xeredi.integra.http.page.seguridad;

import org.fluentlenium.core.FluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAccesoPage.
 */
public final class UsuarioAccesoPage extends FluentPage {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUrl() {
        return "http://127.0.0.1:8080/web";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void isAt() {
        super.isAt();
    }

    public UsuarioAccesoPage setUsuario(final String value) {
        fill("input[ng-model='vm.usro.login']").with(value);

        return this;
    }

    public UsuarioAccesoPage setContrasenia(final String value) {
        fill("input[ng-model='vm.usro.contrasenia']").with(value);

        return this;
    }

    public UsuarioAccesoPage loginSuccessful() {
        click("button[data-ng-click='vm.acceso()']");

        return this;
    }

    public UsuarioAccesoPage loginFailure() {
        click("button[data-ng-click='vm.acceso()']");

        return this;
    }

}
