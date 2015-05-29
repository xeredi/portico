package xeredi.integra.http.controller.action.seguridad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.integra.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class SeguridadTest.
 */
public final class SeguridadTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SeguridadTest.class);

    /**
     * Instantiates a new seguridad test.
     */
    public SeguridadTest() {
        super(new FirefoxDriver());
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        LOG.info("Start");

        login("admin", "admin");

        mainMenu();

        linkHref("#/administracion").click();

        accnMain();
        accnInsert("ACCNTEST1", "Accion Test 1");
        back();
        accnInsert("ACCNTEST2", "Accion Test 2");
        back();
        back();

        grpoMain();
        grpoInsert("Grupo Test 1");
        back();
        grpoInsert("Grupo Test 2");
        back();
        back();

        usroMain();
        usroInsert("test1", "test1", "Test 1", null, null);
        back();
        usroInsert("test2", "test2", "Test 2", "80", null);
        back();
        usroInsert("test3", "test3", "Test 3", "80", "81");
        back();
        usroSearch("test1", null, null);
        usroDetail();
        usroDelete();
        usroSearch("test2", null, null);
        usroDetail();
        usroDelete();
        usroSearch("test3", null, null);
        usroDetail();
        usroDelete();
        back();

        grpoMain();
        grpoSearch("Grupo Test 1");
        grpoDetail();
        grpoDelete();
        grpoSearch("Grupo Test 2");
        grpoDetail();
        grpoDelete();
        back();

        LOG.info("End");
    }

    /**
     * Accn main.
     */
    private void accnMain() {
        linkHref("#/seguridad/accn/grid").click();
        back();
        linkHref("#/seguridad/accn/grid").click();
    }

    /**
     * Grpo main.
     */
    private void grpoMain() {
        linkHref("#/seguridad/grpo/grid").click();
        back();
        linkHref("#/seguridad/grpo/grid").click();
    }

    /**
     * Usro main.
     */
    private void usroMain() {
        linkHref("#/seguridad/usro/grid").click();
        back();
        linkHref("#/seguridad/usro/grid").click();
    }

    /**
     * Accn insert.
     *
     * @param codigo
     *            the codigo
     * @param nombre
     *            the nombre
     */
    private void accnInsert(final String codigo, final String nombre) {
        linkHref("#/seguridad/accn/edit/create").click();
    }

    private void grpoSearch(final String nombre) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        input("vm.grpoCriterio.nombre").clearField().sendKeys(nombre);

        button("vm.search(1);$hide()").click();
    }

    private void grpoDetail() {
        linkHref("#/seguridad/grpo/detail").click();
    }

    /**
     * Grpo insert.
     *
     * @param nombre
     *            the nombre
     */
    private void grpoInsert(final String nombre) {
        linkHref("#/seguridad/grpo/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/seguridad/grpo/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.grpo.nombre").clearField().sendKeys(nombre);

        button("vm.save()").click();
    }

    private void grpoDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Usro search.
     *
     * @param login
     *            the login
     * @param sprtId
     *            the sprt id
     * @param prtoId
     *            the prto id
     */
    private void usroSearch(final String login, final String sprtId, final String prtoId) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        input("vm.usroCriterio.login").clearField().sendKeys(login);

        if (sprtId != null) {
            select("vm.usroCriterio.sprtId").selectByIndex(1);
        }

        if (prtoId != null) {
            select("vm.usroCriterio.prtoId").selectByIndex(1);
        }

        button("vm.search(1);$hide()").click();
    }

    /**
     * Usro detail.
     */
    private void usroDetail() {
        linkHref("#/seguridad/usro/detail").click();
    }

    /**
     * Usro insert.
     *
     * @param login
     *            the login
     * @param contrasenia
     *            the contrasenia
     * @param nombre
     *            the nombre
     * @param sprtId
     *            the sprt id
     * @param prtoId
     *            the prto id
     */
    private void usroInsert(final String login, final String contrasenia, final String nombre, final String sprtId,
            final String prtoId) {
        linkHref("#/seguridad/usro/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/seguridad/usro/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.usro.login").clearField().sendKeys(login);
        input("vm.usro.contrasenia").clearField().sendKeys(contrasenia);
        input("vm.usro.nombre").clearField().sendKeys(nombre);

        if (sprtId != null) {
            select("vm.usro.sprt.id").selectByIndex(1);
        }

        if (prtoId != null) {
            select("vm.usro.prto.id").selectByIndex(1);
        }

        button("vm.save()").click();
    }

    /**
     * Usro delete.
     */
    private void usroDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }
}
