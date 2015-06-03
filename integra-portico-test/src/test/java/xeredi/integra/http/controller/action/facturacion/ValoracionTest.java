package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionTest.
 */
public final class ValoracionTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoracionTest.class);

    private ParametroVO pagador;

    /**
     * Instantiates a new valoracion test.
     */
    public ValoracionTest() {
        super(new FirefoxDriver());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doPrepare() throws ApplicationException {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
        final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

        prmtCriterio.setParametro("GTRD");

        pagador = prmtBO.selectObject(prmtCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doTest() throws ApplicationException {
        login("admin", "admin");

        mainMenu();

        linkHref("#/facturacion").click();

        vlrcMain();

        vlrcSearch("1922056", Entidad.MANIFIESTO, "P/2014/00914", "B2", "B2", "0", "GTRD");
        vlrcDetail();

        back();

        vlrcInsert(Entidad.MANIFIESTO, "P/2013/00001", Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(), "B2", "0", "GTRD", true, null, null, "info1", "info2", "info3", null,
                null, null);

        vlrlInsert();
    }

    /**
     * Vlrc main.
     */
    private void vlrcMain() {
        linkHref("#/facturacion/vlrc/grid").click();
    }

    /**
     * Vlrc search.
     *
     * @param id
     *            the id
     * @param tpsr
     *            the tpsr
     * @param srvc
     *            the srvc
     * @param aspc
     *            the aspc
     * @param crgo
     *            the crgo
     * @param codExencion
     *            the cod exencion
     * @param pagador
     *            the pagador
     */
    private void vlrcSearch(final String id, final Entidad tpsr, final String srvc, final String aspc,
            final String crgo, final String codExencion, final String pagador) {
        button("vm.filter('lg')").click();
        button("$hide()").click();
        button("vm.filter('lg')").click();

        if (id != null) {
            input("vm.vlrcCriterio.id").clearField().sendKeys(id.toString());
        }
        if (tpsr != null) {
            select("vm.vlrcCriterio.tpsrId").selectByValue("number:" + tpsr.getId());

            if (srvc != null) {
                input("vm.vlrcCriterio.srvc").clearField().sendKeys(srvc);
                input("vm.vlrcCriterio.srvc").sendKeys(Keys.ENTER);
            }
            if (aspc != null) {
                input("vm.vlrcCriterio.aspc").clearField().sendKeys(aspc);
                input("vm.vlrcCriterio.aspc").sendKeys(Keys.ENTER);
            }
            if (crgo != null) {
                input("vm.vlrcCriterio.crgo").clearField().sendKeys(crgo);
                input("vm.vlrcCriterio.crgo").sendKeys(Keys.ENTER);
            }
        }
        if (pagador != null) {
            input("vm.vlrcCriterio.pagador").clearField().sendKeys(pagador);
            input("vm.vlrcCriterio.pagador").sendKeys(Keys.ENTER);
        }
        if (codExencion != null) {
            select("vm.vlrcCriterio.codExencion").selectByValue("string:" + codExencion);
        }
        button("vm.search(1);$hide()").click();
    }

    /**
     * Vlrc detail.
     */
    private void vlrcDetail() {
        linkHref("#/facturacion/vlrc/detail").click();
    }

    /**
     * Vlrc insert.
     *
     * @param tpsr
     *            the tpsr
     * @param srvc
     *            the srvc
     * @param fliq
     *            the fliq
     * @param fref
     *            the fref
     * @param aspc
     *            the aspc
     * @param codExencion
     *            the cod exencion
     * @param pagador
     *            the pagador
     * @param sujPasivo
     *            the suj pasivo
     * @param fini
     *            the fini
     * @param ffin
     *            the ffin
     * @param info1
     *            the info1
     * @param info2
     *            the info2
     * @param info3
     *            the info3
     * @param info4
     *            the info4
     * @param info5
     *            the info5
     * @param info6
     *            the info6
     */
    private void vlrcInsert(final Entidad tpsr, final String srvc, final Date fliq, final Date fref, final String aspc,
            final String codExencion, final String pagador, final Boolean sujPasivo, final Date fini, final Date ffin,
            final String info1, final String info2, final String info3, final String info4, final String info5,
            final String info6) {
        linkHref("#/facturacion/vlrc/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrc/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        if (tpsr != null) {
            select("vm.tpsrId").selectByValue("number:" + tpsr.getId());
        }
        if (srvc != null) {
            input("vm.vlrc.srvc").clearField().sendKeys(srvc);
            input("vm.vlrc.srvc").sendKeys(Keys.ENTER);
        }
        if (fliq != null) {
            input("vm.vlrc.fliq").clearField().sendKeys(dateFormat.format(fliq));
        }
        if (fref != null) {
            input("vm.vlrc.fref").clearField().sendKeys(dateFormat.format(fref));
        }
        if (aspc != null) {
            input("vm.vlrc.aspc").clearField().sendKeys(aspc);
            input("vm.vlrc.aspc").sendKeys(Keys.ENTER);
        }
        if (codExencion != null) {
            select("vm.vlrc.codExencion").selectByValue("string:" + codExencion);
        }
        if (pagador != null) {
            input("vm.vlrc.pagador").clearField().sendKeys(pagador);
            input("vm.vlrc.pagador").sendKeys(Keys.ENTER);
        }
        if (sujPasivo != null) {
            select("vm.vlrc.sujPasivo").selectByValue("boolean:" + sujPasivo);
        }
        if (fini != null) {
            input("vm.vlrc.fini").clearField().sendKeys(dateFormat.format(fini));
        }
        if (ffin != null) {
            input("vm.vlrc.ffin").clearField().sendKeys(dateFormat.format(ffin));
        }
        if (info1 != null) {
            input("vm.vlrc.info1").clearField().sendKeys(info1);
        }
        if (info2 != null) {
            input("vm.vlrc.info2").clearField().sendKeys(info2);
        }
        if (info3 != null) {
            input("vm.vlrc.info3").clearField().sendKeys(info3);
        }
        if (info4 != null) {
            input("vm.vlrc.info4").clearField().sendKeys(info4);
        }
        if (info5 != null) {
            input("vm.vlrc.info5").clearField().sendKeys(info5);
        }
        if (info6 != null) {
            input("vm.vlrc.info6").clearField().sendKeys(info6);
        }

        button("vm.save()").click();

        // p("vm.srsc.anno").getText().shouldBe(anno.toString());
        // p("vm.srsc.ultimoNumero").getText().shouldBe(ultimoNumero.toString());
    }

    /**
     * Vlrc update.
     *
     * @param fliq
     *            the fliq
     * @param codExencion
     *            the cod exencion
     * @param pagador
     *            the pagador
     * @param sujPasivo
     *            the suj pasivo
     * @param info1
     *            the info1
     * @param info2
     *            the info2
     * @param info3
     *            the info3
     * @param info4
     *            the info4
     * @param info5
     *            the info5
     * @param info6
     *            the info6
     */
    private void vlrcUpdate(final Date fliq, final String codExencion, final ParametroVO pagador,
            final Boolean sujPasivo, final String info1, final String info2, final String info3, final String info4,
            final String info5, final String info6) {
    }

    /**
     * Vlrc delete.
     */
    private void vlrcDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    private void vlrlInsert() {
        linkTab("1").click();

        linkHref("#/facturacion/vlrl/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrl/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());
    }

}
