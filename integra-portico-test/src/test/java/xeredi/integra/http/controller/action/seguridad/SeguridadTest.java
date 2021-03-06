package xeredi.integra.http.controller.action.seguridad;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class SeguridadTest.
 */
public final class SeguridadTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SeguridadTest.class);

    /** The sprt. */
    private SuperpuertoVO sprt;

    /** The prto. */
    private PuertoVO prto;

    /**
     * Instantiates a new seguridad test.
     */
    public SeguridadTest() {
        super(new FirefoxDriver());

        try {
            final SuperpuertoBO sprtBO = new SuperpuertoBO();
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setCodigo("80");

            sprt = sprtBO.selectObject(sprtCriterio);

            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setCodigo("81");

            prto = prtoBO.selectObject(prtoCriterio);
        } catch (final InstanceNotFoundException ex) {
            throw new Error(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doTest() {
        login("admin", "admin");

        mainMenu();

        linkHref("#/administracion").click();

        accnMain();
        accnInsert("ACCNTEST1", "Accion Test 1");
        accnUpdate("ACCNTEST1_BIS", "Accion Test 1 Bis");
        accnUpdate("ACCNTEST1", "Accion Test 1");
        back();
        accnInsert("ACCNTEST2", "Accion Test 2");
        back();
        back();

        grpoMain();
        grpoInsert("Grupo Test 1");
        grpoUpdate("Grupo Test 1 Bis");
        grpoUpdate("Grupo Test 1");
        back();
        grpoInsert("Grupo Test 2");
        back();
        back();

        usroMain();
        usroInsert("test1", "test1", "Test 1", null, null);
        usroUpdate("test1Bis", "test1Bis", "Test 1 Bis", sprt, prto);
        usroUpdate("test1", "test1", "Test 1", sprt, prto);
        back();
        usroInsert("test2", "test2", "Test 2", sprt, null);
        back();
        usroInsert("test3", "test3", "Test 3", sprt, prto);
        back();
        usroSearch("test1", null, null);
        usroDetail();
        usroDelete();
        usroSearch("test2", sprt, null);
        usroDetail();
        usroDelete();
        usroSearch("test3", sprt, prto);
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

        accnMain();
        accnSearch("ACCNTEST1");
        accnDetail();
        accnDelete();
        accnSearch("ACCNTEST2");
        accnDetail();
        accnDelete();
        back();
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
     * Accn search.
     *
     * @param codigo
     *            the codigo
     */
    private void accnSearch(final String codigo) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        input("vm.accnCriterio.codigo").clearField().sendKeys(codigo);

        button("vm.search(1);$hide()").click();
    }

    /**
     * Accn detail.
     */
    private void accnDetail() {
        linkHref("#/seguridad/accn/detail").click();
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
        button("vm.cancel()").click();
        linkHref("#/seguridad/accn/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.accn.codigo").clearField().sendKeys(codigo);
        input("vm.accn.nombre").clearField().sendKeys(nombre);

        button("vm.save()").click();

        p("vm.accn.codigo").getText().shouldBe(codigo);
        p("vm.accn.nombre").getText().shouldBe(nombre);
    }

    private void accnUpdate(final String codigo, final String nombre) {
        linkHref("#/seguridad/accn/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/seguridad/accn/edit/edit").click();

        input("vm.accn.nombre").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.accn.codigo").clearField().sendKeys(codigo);
        input("vm.accn.nombre").clearField().sendKeys(nombre);

        button("vm.save()").click();

        p("vm.accn.codigo").getText().shouldBe(codigo);
        p("vm.accn.nombre").getText().shouldBe(nombre);
    }

    /**
     * Accn delete.
     */
    private void accnDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Grpo search.
     *
     * @param nombre
     *            the nombre
     */
    private void grpoSearch(final String nombre) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        input("vm.grpoCriterio.nombre").clearField().sendKeys(nombre);

        button("vm.search(1);$hide()").click();
    }

    /**
     * Grpo detail.
     */
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

        p("vm.grpo.nombre").getText().shouldBe(nombre);
    }

    private void grpoUpdate(final String nombre) {
        linkHref("#/seguridad/grpo/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/seguridad/grpo/edit/edit").click();

        input("vm.grpo.nombre").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.grpo.nombre").clearField().sendKeys(nombre);

        button("vm.save()").click();

        p("vm.grpo.nombre").getText().shouldBe(nombre);
    }

    /**
     * Grpo delete.
     */
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
     * @param sprt
     *            the sprt
     * @param prto
     *            the prto
     */
    private void usroSearch(final String login, final SuperpuertoVO sprt, final PuertoVO prto) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        input("vm.usroCriterio.login").clearField().sendKeys(login);

        if (sprt != null) {
            select("vm.usroCriterio.sprtId").selectByValue("number:" + sprt.getId());
        }

        if (prto != null) {
            select("vm.usroCriterio.prtoId").selectByValue("number:" + prto.getId());
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
     * @param sprt
     *            the sprt
     * @param prto
     *            the prto
     */
    private void usroInsert(final String login, final String contrasenia, final String nombre, final SuperpuertoVO sprt,
            final PuertoVO prto) {
        linkHref("#/seguridad/usro/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/seguridad/usro/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.usro.login").clearField().sendKeys(login);
        input("vm.usro.contrasenia").clearField().sendKeys(contrasenia);
        input("vm.usro.nombre").clearField().sendKeys(nombre);

        if (sprt != null) {
            select("vm.usro.sprt.id").selectByValue("number:" + sprt.getId());
        }

        if (prto != null) {
            select("vm.usro.prto.id").selectByValue("number:" + prto.getId());
        }

        button("vm.save()").click();

        p("vm.usro.login").getText().shouldBe(login);
        p("vm.usro.nombre").getText().shouldBe(nombre);
    }

    /**
     * Usro update.
     *
     * @param login
     *            the login
     * @param contrasenia
     *            the contrasenia
     * @param nombre
     *            the nombre
     * @param sprt
     *            the sprt
     * @param prto
     *            the prto
     */
    private void usroUpdate(final String login, final String contrasenia, final String nombre, final SuperpuertoVO sprt,
            final PuertoVO prto) {
        linkHref("#/seguridad/usro/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/seguridad/usro/edit/edit").click();

        input("vm.usro.login").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.usro.login").clearField().sendKeys(login);
        input("vm.usro.contrasenia").clearField().sendKeys(contrasenia);
        input("vm.usro.nombre").clearField().sendKeys(nombre);

        if (sprt != null) {
            select("vm.usro.sprt.id").selectByValue("number:" + sprt.getId());
        }

        if (prto != null) {
            select("vm.usro.prto.id").selectByValue("number:" + prto.getId());
        }

        button("vm.save()").click();

        p("vm.usro.login").getText().shouldBe(login);
        p("vm.usro.nombre").getText().shouldBe(nombre);
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
