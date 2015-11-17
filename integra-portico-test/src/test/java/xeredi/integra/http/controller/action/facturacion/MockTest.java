package xeredi.integra.http.controller.action.facturacion;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import xeredi.argo.test.comun.FluentBaseTest;
import xeredi.integra.http.page.seguridad.UsuarioAccesoPage;

public final class MockTest extends FluentBaseTest {

    @Page
    private UsuarioAccesoPage usuarioAccesoPage;

    @Test
    public void test() {
        maximizeWindow();
        goTo(usuarioAccesoPage).setUsuario("admin").setContrasenia("admin").loginSuccessful();

        click("a[translate='menu']");
        click("a[ng-href*='#/administracion']");
    }
}
