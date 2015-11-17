package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.test.comun.AngularJsTest;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionTest.
 */
public final class ValoracionTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ValoracionTest.class);

    /** The pagador. */
    private ParametroVO pagador;

    /** The impuesto. */
    private ParametroVO impuestoG;

    /** The impuesto r. */
    private ParametroVO impuestoR;

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
        final ParametroBO pagadorPrmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
        final ParametroCriterioVO pagadorPrmtCriterio = new ParametroCriterioVO();

        pagadorPrmtCriterio.setEntiId(Entidad.ORGANIZACION.getId());
        pagadorPrmtCriterio.setParametro("GTRD");

        pagador = pagadorPrmtBO.selectObject(pagadorPrmtCriterio);

        final ParametroBO impuestoPrmtBO = ParametroBOFactory.newInstance(Entidad.TIPO_IVA.getId());
        final ParametroCriterioVO impuestoPrmtCriterio = new ParametroCriterioVO();

        impuestoPrmtCriterio.setEntiId(Entidad.TIPO_IVA.getId());
        impuestoPrmtCriterio.setParametro("G");
        impuestoPrmtCriterio.setFechaVigencia(Calendar.getInstance().getTime());

        impuestoG = impuestoPrmtBO.selectObject(impuestoPrmtCriterio);

        impuestoPrmtCriterio.setParametro("R");

        impuestoR = impuestoPrmtBO.selectObject(impuestoPrmtCriterio);
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

        // vlrcSearch("1922056", Entidad.MANIFIESTO, "P/2014/00914", "B2", "B2", "0", "GTRD");
        // vlrcDetail();
        //
        // back();

        vlrcInsert(Entidad.MANIFIESTO, "P/2013/00013", Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime(), "B2", "0", "GTRD", true, null, null, "info1", "info2", "info3", null,
                null, null);
        vlrcUpdate(Calendar.getInstance().getTime(), "1", "00001", false, "info1 bis", "info2 bis", "info3 bis", null,
                null, null);

        linkTab("1").click();
        vlrlInsert("B2", "B2-10-0000", impuestoG, "linea info 1", null, null, null, null, null);
        vlrlUpdate(impuestoR, "linea info 1 bis", null, null, null, null, null);

        linkTab("1").click();
        vlrdInsert(50.0, 3000.0, "272", null, "150", null, null, null, null, null, null, null, null, null, null);
        vlrdUpdate(200.0, 6000.0, "272", null, "250", null, null, null, null, null, null, null, null, null, null);

        linkTab("0").click();
        /*
         * vlrlDelete();
         *
         * linkTab("0").click(); vlrcDelete();
         */
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
    private void vlrcUpdate(final Date fliq, final String codExencion, final String pagador, final Boolean sujPasivo,
            final String info1, final String info2, final String info3, final String info4, final String info5,
            final String info6) {
        linkHref("#/facturacion/vlrc/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrc/edit/edit").click();

        input("vm.vlrc.fliq").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        if (fliq != null) {
            input("vm.vlrc.fliq").clearField().sendKeys(dateFormat.format(fliq));
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

    /**
     * Vlrl insert.
     *
     * @param crgo
     *            the crgo
     * @param rgla
     *            the rgla
     * @param impuesto
     *            the impuesto
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
    private void vlrlInsert(final String crgo, final String rgla, final ParametroVO impuesto, final String info1,
            final String info2, final String info3, final String info4, final String info5, final String info6) {
        linkHref("#/facturacion/vlrl/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrl/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        if (crgo != null) {
            input("vm.crgo").clearField().sendKeys(crgo);
            input("vm.crgo").sendKeys(Keys.ENTER);
        }
        if (rgla != null) {
            input("vm.vlrl.rgla").clearField().sendKeys(rgla);
            input("vm.vlrl.rgla").sendKeys(Keys.ENTER);
        }
        if (impuesto != null) {
            select("vm.vlrl.impuesto.id").selectByValue("number:" + impuesto.getId());
        }

        if (info1 != null) {
            input("vm.vlrl.info1").clearField().sendKeys(info1);
        }
        if (info2 != null) {
            input("vm.vlrl.info2").clearField().sendKeys(info2);
        }
        if (info3 != null) {
            input("vm.vlrl.info3").clearField().sendKeys(info3);
        }
        if (info4 != null) {
            input("vm.vlrl.info4").clearField().sendKeys(info4);
        }
        if (info5 != null) {
            input("vm.vlrl.info5").clearField().sendKeys(info5);
        }
        if (info6 != null) {
            input("vm.vlrl.info6").clearField().sendKeys(info6);
        }

        button("vm.save()").click();
    }

    /**
     * Vlrl update.
     *
     * @param impuesto
     *            the impuesto
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
    private void vlrlUpdate(final ParametroVO impuesto, final String info1, final String info2, final String info3,
            final String info4, final String info5, final String info6) {
        linkHref("#/facturacion/vlrl/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrl/edit/edit").click();

        if (impuesto != null) {
            select("vm.vlrl.impuesto.id").selectByValue("number:" + impuesto.getId());
        }

        if (info1 != null) {
            input("vm.vlrl.info1").clearField().sendKeys(info1);
        }
        if (info2 != null) {
            input("vm.vlrl.info2").clearField().sendKeys(info2);
        }
        if (info3 != null) {
            input("vm.vlrl.info3").clearField().sendKeys(info3);
        }
        if (info4 != null) {
            input("vm.vlrl.info4").clearField().sendKeys(info4);
        }
        if (info5 != null) {
            input("vm.vlrl.info5").clearField().sendKeys(info5);
        }
        if (info6 != null) {
            input("vm.vlrl.info6").clearField().sendKeys(info6);
        }

        button("vm.save()").click();
    }

    /**
     * Vlrl delete.
     */
    private void vlrlDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Vlrd insert.
     *
     * @param valorBase
     *            the valor base
     * @param importe
     *            the importe
     * @param ssrv
     *            the ssrv
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
     * @param cuant1
     *            the cuant1
     * @param cuant2
     *            the cuant2
     * @param cuant3
     *            the cuant3
     * @param cuant4
     *            the cuant4
     * @param cuant5
     *            the cuant5
     * @param cuant6
     *            the cuant6
     */
    private void vlrdInsert(final Double valorBase, final Double importe, final String ssrv, final String info1,
            final String info2, final String info3, final String info4, final String info5, final String info6,
            final Double cuant1, final Double cuant2, final Double cuant3, final Double cuant4, final Double cuant5,
            final Double cuant6) {
        linkHref("#/facturacion/vlrd/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrd/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        if (valorBase != null) {
            input("vm.vlrd.valorBase").clearField().sendKeys(valorBase.toString());
        }
        if (importe != null) {
            input("vm.vlrd.importe").clearField().sendKeys(importe.toString());
        }
        if (ssrv != null) {
            input("vm.vlrd.ssrv").clearField().sendKeys(ssrv);
            input("vm.vlrd.ssrv").sendKeys(Keys.ENTER);
        }
        if (info1 != null) {
            input("vm.vlrd.info1").clearField().sendKeys(info1);
        }
        if (info2 != null) {
            input("vm.vlrd.info2").clearField().sendKeys(info2);
        }
        if (info3 != null) {
            input("vm.vlrd.info3").clearField().sendKeys(info3);
        }
        if (info4 != null) {
            input("vm.vlrd.info4").clearField().sendKeys(info4);
        }
        if (info5 != null) {
            input("vm.vlrd.info5").clearField().sendKeys(info5);
        }
        if (info6 != null) {
            input("vm.vlrd.info6").clearField().sendKeys(info6);
        }

        if (cuant1 != null) {
            input("vm.vlrd.cuant1").clearField().sendKeys(cuant1.toString());
        }
        if (cuant2 != null) {
            input("vm.vlrd.cuant2").clearField().sendKeys(cuant2.toString());
        }
        if (cuant3 != null) {
            input("vm.vlrd.cuant3").clearField().sendKeys(cuant3.toString());
        }
        if (cuant4 != null) {
            input("vm.vlrd.cuant4").clearField().sendKeys(cuant4.toString());
        }
        if (cuant5 != null) {
            input("vm.vlrd.cuant5").clearField().sendKeys(cuant5.toString());
        }
        if (cuant6 != null) {
            input("vm.vlrd.cuant6").clearField().sendKeys(cuant6.toString());
        }

        button("vm.save()").click();
    }

    /**
     * Vlrd update.
     *
     * @param valorBase
     *            the valor base
     * @param importe
     *            the importe
     * @param ssrv
     *            the ssrv
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
     * @param cuant1
     *            the cuant1
     * @param cuant2
     *            the cuant2
     * @param cuant3
     *            the cuant3
     * @param cuant4
     *            the cuant4
     * @param cuant5
     *            the cuant5
     * @param cuant6
     *            the cuant6
     */
    private void vlrdUpdate(final Double valorBase, final Double importe, final String ssrv, final String info1,
            final String info2, final String info3, final String info4, final String info5, final String info6,
            final Double cuant1, final Double cuant2, final Double cuant3, final Double cuant4, final Double cuant5,
            final Double cuant6) {
        linkHref("#/facturacion/vlrd/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/facturacion/vlrd/edit/edit").click();

        input("vm.vlrd.importe").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        if (valorBase != null) {
            input("vm.vlrd.valorBase").clearField().sendKeys(valorBase.toString());
        }
        if (importe != null) {
            input("vm.vlrd.importe").clearField().sendKeys(importe.toString());
        }
        if (ssrv != null) {
            input("vm.vlrd.ssrv").clearField().sendKeys(ssrv);
            input("vm.vlrd.ssrv").sendKeys(Keys.ENTER);
        }
        if (info1 != null) {
            input("vm.vlrd.info1").clearField().sendKeys(info1);
        }
        if (info2 != null) {
            input("vm.vlrd.info2").clearField().sendKeys(info2);
        }
        if (info3 != null) {
            input("vm.vlrd.info3").clearField().sendKeys(info3);
        }
        if (info4 != null) {
            input("vm.vlrd.info4").clearField().sendKeys(info4);
        }
        if (info5 != null) {
            input("vm.vlrd.info5").clearField().sendKeys(info5);
        }
        if (info6 != null) {
            input("vm.vlrd.info6").clearField().sendKeys(info6);
        }

        if (cuant1 != null) {
            input("vm.vlrd.cuant1").clearField().sendKeys(cuant1.toString());
        }
        if (cuant2 != null) {
            input("vm.vlrd.cuant2").clearField().sendKeys(cuant2.toString());
        }
        if (cuant3 != null) {
            input("vm.vlrd.cuant3").clearField().sendKeys(cuant3.toString());
        }
        if (cuant4 != null) {
            input("vm.vlrd.cuant4").clearField().sendKeys(cuant4.toString());
        }
        if (cuant5 != null) {
            input("vm.vlrd.cuant5").clearField().sendKeys(cuant5.toString());
        }
        if (cuant6 != null) {
            input("vm.vlrd.cuant6").clearField().sendKeys(cuant6.toString());
        }

        button("vm.save()").click();
    }

    /**
     * Vlrd delete.
     */
    private void vlrdDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

}
