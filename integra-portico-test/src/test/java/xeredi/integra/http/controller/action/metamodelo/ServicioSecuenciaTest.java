package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaTest.
 */
public final class ServicioSecuenciaTest extends AngularJsTest {
    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ServicioSecuenciaTest.class);

    /** The sprt. */
    private PuertoVO prto;

    /**
     * Instantiates a new servicio secuencia test.
     */
    public ServicioSecuenciaTest() {
        super(new FirefoxDriver());

        try {
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

        srscMain();
        srscInsert(2005, Entidad.ESCALA, prto, 0);
        srscUpdate(500);
        back();
        srscSearch(2005, Entidad.ESCALA, prto);
        srscDetail();
        srscDelete();

        back();
    }

    /**
     * Srsc main.
     */
    private void srscMain() {
        linkHref("#/servicio/srsc/grid").click();
    }

    /**
     * Srsc search.
     *
     * @param anno
     *            the anno
     * @param enti
     *            the enti
     * @param prto
     *            the prto
     */
    private void srscSearch(final Integer anno, final Entidad enti, final PuertoVO prto) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        if (anno != null) {
            input("vm.srscCriterio.anno").clearField().sendKeys(anno.toString());
        }
        if (enti != null) {
            select("vm.srscCriterio.tpsrId").selectByValue("number:" + enti.getId());
        }
        if (prto != null) {
            select("vm.srscCriterio.prtoId").selectByValue("number:" + prto.getId());
        }

        button("vm.search(1);$hide()").click();
    }

    /**
     * Srsc detail.
     */
    private void srscDetail() {
        linkHref("#/servicio/srsc/detail").click();
    }

    /**
     * Srsc insert.
     *
     * @param anno
     *            the anno
     * @param enti
     *            the enti
     * @param prto
     *            the prto
     * @param ultimoNumero
     *            the ultimo numero
     */
    private void srscInsert(final Integer anno, final Entidad enti, final PuertoVO prto, final Integer ultimoNumero) {
        linkHref("#/servicio/srsc/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/servicio/srsc/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.srsc.anno").clearField().sendKeys(anno.toString());
        select("vm.srsc.tpsr.id").selectByValue("number:" + enti.getId());
        select("vm.srsc.prto.id").selectByValue("number:" + prto.getId());
        input("vm.srsc.ultimoNumero").clearField().sendKeys(ultimoNumero.toString());

        button("vm.save()").click();

        // p("vm.srsc.anno").getText().shouldBe(anno.toString());
        // p("vm.srsc.ultimoNumero").getText().shouldBe(ultimoNumero.toString());
    }

    /**
     * Srsc update.
     *
     * @param ultimoNumero
     *            the ultimo numero
     */
    private void srscUpdate(final Integer ultimoNumero) {
        linkHref("#/servicio/srsc/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/servicio/srsc/edit/edit").click();

        input("vm.srsc.ultimoNumero").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.srsc.ultimoNumero").clearField().sendKeys(ultimoNumero.toString());

        button("vm.save()").click();

        // p("vm.srsc.ultimoNumero").getText().shouldBe(ultimoNumero.toString());
    }

    /**
     * Srsc delete.
     */
    private void srscDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }
}
