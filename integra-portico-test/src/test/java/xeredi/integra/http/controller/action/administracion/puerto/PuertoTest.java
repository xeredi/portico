package xeredi.integra.http.controller.action.administracion.puerto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoTest.
 */
public final class PuertoTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PuertoTest.class);

    /** The sprt. */
    private SuperpuertoVO sprt;

    /**
     * Instantiates a new puerto test.
     */
    public PuertoTest() {
        super(new FirefoxDriver());

        try {
            final SuperpuertoBO sprtBO = new SuperpuertoBO();
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setCodigo("80");

            sprt = sprtBO.selectObject(sprtCriterio);
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

        sprtMain();
        sprtInsert("00", "Sprt Test");
        sprtUpdate("Sprt Test Updated");
        back();
        sprtSearch("00");
        sprtDetail();
        sprtDelete();

        back();

        prtoMain();
        prtoInsert("88", "88c", "88e", "88adu", "ESAAA", sprt, "Sprt Test");
        prtoUpdate("88c", "88e", "88adu", "ESAAA", sprt, "Sprt Test");
        back();
        prtoSearch("88", sprt);
        prtoDetail();
        prtoDelete();

        back();
    }

    /**
     * Sprt main.
     */
    private void sprtMain() {
        linkHref("#/administracion/superpuerto-grid").click();
        back();
        linkHref("#/administracion/superpuerto-grid").click();
    }

    /**
     * Sprt search.
     *
     * @param codigo
     *            the codigo
     */
    private void sprtSearch(final String codigo) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        input("vm.sprtCriterio.codigo").clearField().sendKeys(codigo);

        button("vm.search(1);$hide()").click();
    }

    /**
     * Sprt detail.
     */
    private void sprtDetail() {
        linkHref("#/administracion/superpuerto-detail").click();
    }

    /**
     * Sprt insert.
     *
     * @param codigo
     *            the codigo
     * @param text
     *            the text
     */
    private void sprtInsert(final String codigo, final String text) {
        linkHref("#/administracion/superpuerto-edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/administracion/superpuerto-edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.sprt.codigo").clearField().sendKeys(codigo);

        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();

        p("vm.sprt.codigo").getText().shouldBe(codigo);
    }

    /**
     * Sprt update.
     *
     * @param text
     *            the text
     */
    private void sprtUpdate(final String text) {
        linkHref("#/administracion/superpuerto-edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/administracion/superpuerto-edit/edit").click();

        input("vm.i18nMap[default_language].text").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Sprt delete.
     */
    private void sprtDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Prto main.
     */
    private void prtoMain() {
        linkHref("#/administracion/puerto-grid").click();
        back();
        linkHref("#/administracion/puerto-grid").click();
    }

    /**
     * Prto search.
     *
     * @param codigo
     *            the codigo
     * @param sprt
     *            the sprt
     */
    private void prtoSearch(final String codigo, final SuperpuertoVO sprt) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        if (codigo != null) {
            input("vm.prtoCriterio.codigo").clearField().sendKeys(codigo);
        }
        if (sprt != null) {
            select("vm.prtoCriterio.sprtId").selectByValue("number:" + sprt.getId());
        }

        button("vm.search(1);$hide()").click();
    }

    /**
     * Prto detail.
     */
    private void prtoDetail() {
        linkHref("#/administracion/puerto-detail").click();
    }

    /**
     * Prto insert.
     *
     * @param codigo
     *            the codigo
     * @param codigoCorto
     *            the codigo corto
     * @param codigoEdi
     *            the codigo edi
     * @param recAduanero
     *            the rec aduanero
     * @param unlocode
     *            the unlocode
     * @param sprt
     *            the sprt
     * @param text
     *            the text
     */
    private void prtoInsert(final String codigo, final String codigoCorto, final String codigoEdi,
            final String recAduanero, final String unlocode, final SuperpuertoVO sprt, final String text) {
        linkHref("#/administracion/puerto-edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/administracion/puerto-edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.prto.codigo").clearField().sendKeys(codigo);
        input("vm.prto.codigoCorto").clearField().sendKeys(codigoCorto);
        input("vm.prto.codigoEdi").clearField().sendKeys(codigoEdi);
        input("vm.prto.recAduanero").clearField().sendKeys(recAduanero);
        input("vm.prto.unlocode").clearField().sendKeys(unlocode);
        select("vm.prto.sprt.id").selectByValue("number:" + sprt.getId());

        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();

        p("vm.prto.codigo").getText().shouldBe(codigo);
        p("vm.prto.codigoCorto").getText().shouldBe(codigoCorto);
        p("vm.prto.codigoEdi").getText().shouldBe(codigoEdi);
        p("vm.prto.recAduanero").getText().shouldBe(recAduanero);
        p("vm.prto.unlocode").getText().shouldBe(unlocode);
    }

    /**
     * Prto update.
     *
     * @param codigoCorto
     *            the codigo corto
     * @param codigoEdi
     *            the codigo edi
     * @param recAduanero
     *            the rec aduanero
     * @param unlocode
     *            the unlocode
     * @param sprt
     *            the sprt
     * @param text
     *            the text
     */
    private void prtoUpdate(final String codigoCorto, final String codigoEdi, final String recAduanero,
            final String unlocode, final SuperpuertoVO sprt, final String text) {
        linkHref("#/administracion/puerto-edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/administracion/puerto-edit/edit").click();

        input("vm.i18nMap[default_language].text").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.prto.codigoCorto").clearField().sendKeys(codigoCorto);
        input("vm.prto.codigoEdi").clearField().sendKeys(codigoEdi);
        input("vm.prto.recAduanero").clearField().sendKeys(recAduanero);
        input("vm.prto.unlocode").clearField().sendKeys(unlocode);
        select("vm.prto.sprt.id").selectByValue("number:" + sprt.getId());

        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();

        p("vm.prto.codigoCorto").getText().shouldBe(codigoCorto);
        p("vm.prto.codigoEdi").getText().shouldBe(codigoEdi);
        p("vm.prto.recAduanero").getText().shouldBe(recAduanero);
        p("vm.prto.unlocode").getText().shouldBe(unlocode);
    }

    /**
     * Prto delete.
     */
    private void prtoDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }
}
