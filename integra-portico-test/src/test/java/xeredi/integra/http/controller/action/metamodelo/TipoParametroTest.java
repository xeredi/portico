package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.test.comun.AngularJsTest;
import xeredi.integra.http.page.metamodelo.EntidadAccionDetailPage;
import xeredi.integra.http.page.metamodelo.EntidadAccionEditPage;
import xeredi.integra.http.page.metamodelo.EntidadAccionGridDetailPage;
import xeredi.integra.http.page.metamodelo.EntidadAccionGridEditPage;
import xeredi.integra.http.page.metamodelo.EntidadGrupoDatoDetailPage;
import xeredi.integra.http.page.metamodelo.EntidadGrupoDatoEditPage;
import xeredi.integra.http.page.metamodelo.EntidadTipoDatoDetailPage;
import xeredi.integra.http.page.metamodelo.EntidadTipoDatoEditPage;
import xeredi.integra.http.page.metamodelo.TipoParametroDetailPage;
import xeredi.integra.http.page.metamodelo.TipoParametroEditPage;
import xeredi.integra.http.page.metamodelo.TipoParametroGridPage;
import xeredi.integra.http.page.metamodelo.TipoSubparametroDetailPage;
import xeredi.integra.http.page.metamodelo.TipoSubparametroEditPage;
import xeredi.integra.http.page.seguridad.UsuarioAccesoPage;

// TODO: Auto-generated Javadoc
/**
 * The Class MetamodeloTest.
 */
public final class TipoParametroTest extends AngularJsTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoParametroTest.class);

    /**
     * Instantiates a new metamodelo test.
     */
    public TipoParametroTest() {
        super(new FirefoxDriver());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doTest() {
        final UsuarioAccesoPage usuarioAccesoPage = new UsuarioAccesoPage(webDriver, fluentWebDriver);

        usuarioAccesoPage.gotoPage().setUsuario("admin").setContrasenia("admin").clickAcceso();
        usuarioAccesoPage.administracionMenu();

        final TipoParametroGridPage tpprGridPage = new TipoParametroGridPage(webDriver, fluentWebDriver);

        tpprGridPage.gotoPage();
        tpprGridPage.clickOpenFilter().clickCloseFilter();

        final TipoParametroEditPage tpprEditPage = new TipoParametroEditPage(webDriver, fluentWebDriver);

        tpprEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(tpprEditPage.gotoCreatePage().clickSave().hasErrors());
        tpprEditPage.setCodigo("TPPR_TEST").setMaxGrid("10000").setCmdAlta(false).setCmdBaja(false).setCmdEdicion(false)
                .setCmdDuplicado(false).setI18nText("Tppr Test").clickSave();

        Assert.assertTrue(tpprEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        tpprEditPage.setMaxGrid("20000").setCmdAlta(true).setCmdBaja(true).setCmdEdicion(true).setCmdDuplicado(true)
                .setI18nText("Tppr Test Bis").clickSave();

        final EntidadGrupoDatoEditPage engdEditPage = new EntidadGrupoDatoEditPage(webDriver, fluentWebDriver);

        engdEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(engdEditPage.gotoCreatePage().clickSave().hasErrors());
        engdEditPage.setNumero("1").setI18nText("Tppr Test General").clickSave();

        Assert.assertTrue(engdEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        engdEditPage.setNumero("2").setI18nText("Tppr Test General Bis").clickSave().back();

        final EntidadTipoDatoEditPage entdEditPage = new EntidadTipoDatoEditPage(webDriver, fluentWebDriver);

        entdEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(entdEditPage.gotoCreatePage().clickSave().hasErrors());
        entdEditPage.setTpdt(TipoDato.ACUERDO).setGrupo("1").setFila("1").setOrden("1").setSpan("3")
                .setObligatorio(true).setGridable(true).setFiltrable(true).setI18nText("Acuerdo").clickSave();

        Assert.assertTrue(entdEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        entdEditPage.setFila("2").setObligatorio(false).setGridable(false).setFiltrable(false)
                .setI18nText("Acuerdo Bis").clickSave().back();

        final EntidadAccionEditPage enacEditPage = new EntidadAccionEditPage(webDriver, fluentWebDriver);

        enacEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(enacEditPage.gotoCreatePage().clickSave().hasErrors());
        enacEditPage.setPath("tppr-enac-path").setOrden("1").setI18nText("Tppr Action Test").clickSave();

        Assert.assertTrue(enacEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        enacEditPage.setOrden("2").setI18nText("Tppr Action Test Bis").clickSave().back();

        final EntidadAccionGridEditPage enagEditPage = new EntidadAccionGridEditPage(webDriver, fluentWebDriver);

        enagEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(enagEditPage.gotoCreatePage().clickSave().hasErrors());
        enagEditPage.setPath("tppr-enag-path").setOrden("1").setI18nText("Tppr Action Grid Test").clickSave();

        Assert.assertTrue(enagEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        enagEditPage.setOrden("2").setI18nText("Tppr Action Grid Test Bis").clickSave().back();

        final TipoSubparametroEditPage tpspEditPage = new TipoSubparametroEditPage(webDriver, fluentWebDriver);

        tpspEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(tpspEditPage.gotoCreatePage().clickSave().hasErrors());
        tpspEditPage.setCodigo("TPSP_TEST").setMaxGrid("100").setTpprAsociado(Entidad.ACUERDO).setI18nText("Tpsp Test")
                .clickSave();

        Assert.assertTrue(tpspEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        tpspEditPage.setMaxGrid("200").setTpprAsociado(Entidad.BUQUE).setI18nText("Tpsp Test Bis").clickSave().back();

        // tpsp
        final TipoSubparametroDetailPage tpspDetailPage = new TipoSubparametroDetailPage(webDriver, fluentWebDriver);

        tpspDetailPage.gotoPage();

        // engd
        engdEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(engdEditPage.gotoCreatePage().clickSave().hasErrors());
        engdEditPage.setNumero("1").setI18nText("Tpsp Test General").clickSave();

        Assert.assertTrue(engdEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        engdEditPage.setNumero("2").setI18nText("Tpsp Test General Bis").clickSave().back();

        // entd
        entdEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(entdEditPage.gotoCreatePage().clickSave().hasErrors());
        entdEditPage.setTpdt(TipoDato.ACUERDO).setGrupo("1").setFila("1").setOrden("1").setSpan("3")
                .setObligatorio(true).setGridable(true).setFiltrable(true).setI18nText("Acuerdo").clickSave();

        Assert.assertTrue(entdEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        entdEditPage.setFila("2").setObligatorio(false).setGridable(false).setFiltrable(false)
                .setI18nText("Acuerdo Bis").clickSave().back();

        // enac
        enacEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(enacEditPage.gotoCreatePage().clickSave().hasErrors());
        enacEditPage.setPath("tpsp-enac-path").setOrden("1").setI18nText("Tpsp Action Test").clickSave();

        Assert.assertTrue(enacEditPage.gotoEditPage().setI18nText(null).clickSave().hasErrors());
        enacEditPage.setOrden("2").setI18nText("Tpsp Action Test Bis").clickSave().back();

        final EntidadTipoDatoDetailPage entdDetailPage = new EntidadTipoDatoDetailPage(webDriver, fluentWebDriver);

        entdDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();

        final EntidadGrupoDatoDetailPage engdDetailPage = new EntidadGrupoDatoDetailPage(webDriver, fluentWebDriver);

        engdDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();

        final EntidadAccionDetailPage enacDetailPage = new EntidadAccionDetailPage(webDriver, fluentWebDriver);

        enacDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();

        tpspDetailPage.clickDelete().confirmCancel().clickDelete().confirmOk();

        // Borrado tppr
        entdDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();
        engdDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();
        enacDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();

        final EntidadAccionGridDetailPage enagDetailPage = new EntidadAccionGridDetailPage(webDriver, fluentWebDriver);

        enagDetailPage.gotoPage().clickDelete().confirmCancel().clickDelete().confirmOk();

        final TipoParametroDetailPage tpprDetailPage = new TipoParametroDetailPage(webDriver, fluentWebDriver);

        tpprDetailPage.clickDelete().confirmCancel().clickDelete().confirmOk();

        // driver.close();
        // driver.quit();
    }
}
