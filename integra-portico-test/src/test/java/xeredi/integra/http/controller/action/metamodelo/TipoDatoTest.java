package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoTest.
 */
public final class TipoDatoTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoDatoTest.class);

    /**
     * Instantiates a new tipo dato test.
     */
    public TipoDatoTest() {
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

        tpdtMain();
        tpdtSearch("ACUERDO", null, null, null);
        tpdtDetail();
        back();
        tpdtInsert("TPDT_BO_TEST", TipoElemento.BO, TipoHtml.CB, null, "TpdtBOTest");
        tpdtDelete();
        tpdtInsert("TPDT_PR_TEST", TipoElemento.PR, TipoHtml.S, Entidad.ACUERDO, "TpdtPRTest");
        tpdtDelete();

        LOG.info("End");
    }

    /**
     * Tpdt main.
     */
    private void tpdtMain() {
        linkHref("#/metamodelo/tpdt/grid").click();
    }

    /**
     * Tpdt search.
     *
     * @param codigo
     *            the codigo
     * @param nombre
     *            the nombre
     * @param tpel
     *            the tpel
     * @param tpht
     *            the tpht
     */
    private void tpdtSearch(final String codigo, final String nombre, final TipoElemento tpel, final TipoHtml tpht) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        if (codigo != null) {
            input("vm.tpdtCriterio.codigo").clearField().sendKeys(codigo);
        }
        if (nombre != null) {
            input("vm.tpdtCriterio.nombre").clearField().sendKeys(nombre);
        }
        if (tpel != null) {
            select("vm.tpdtCriterio.tpel").selectByValue("string:" + tpel.name());
        }
        if (tpht != null) {
            select("vm.tpdtCriterio.tpht").selectByValue("string:" + tpht.name());
        }

        button("vm.search(1);$hide()").click();
    }

    /**
     * Tpdt detail.
     */
    private void tpdtDetail() {
        linkHref("#/metamodelo/tpdt/detail").click();
    }

    /**
     * Tpdt insert.
     *
     * @param codigo
     *            the codigo
     * @param tpel
     *            the tpel
     * @param tpht
     *            the tpht
     * @param text
     *            the text
     */
    private void tpdtInsert(final String codigo, final TipoElemento tpel, final TipoHtml tpht, final Entidad enti,
            final String text) {
        linkHref("#/metamodelo/tpdt/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/tpdt/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.tpdt.codigo").clearField().sendKeys(codigo);
        select("vm.tpdt.tipoElemento").selectByValue("string:" + tpel.name());
        select("vm.tpdt.tpht").selectByValue("string:" + tpht.name());

        if (enti != null) {
            select("vm.tpdt.enti.id").selectByValue("number:" + enti.getId());
        }

        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();

        p("vm.tpdt.codigo").getText().shouldBe(codigo);
    }

    /**
     * Tpdt delete.
     */
    private void tpdtDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

}
