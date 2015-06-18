package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.integra.http.page.metamodelo.TipoDatoDetailPage;
import xeredi.integra.http.page.metamodelo.TipoDatoEditPage;
import xeredi.integra.http.page.metamodelo.TipoDatoGridPage;
import xeredi.integra.http.page.seguridad.UsuarioAccesoPage;
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
     * {@inheritDoc}
     */
    @Override
    protected void doTest() {
        final UsuarioAccesoPage usuarioAccesoPage = new UsuarioAccesoPage(webDriver, fluentWebDriver);

        usuarioAccesoPage.gotoPage().setUsuario("admin").setContrasenia("admin").clickAcceso();
        usuarioAccesoPage.administracionMenu();

        final TipoDatoGridPage tipoDatoGridPage = new TipoDatoGridPage(webDriver, fluentWebDriver);

        tipoDatoGridPage.gotoPage();

        tipoDatoGridPage.clickOpenFilter().clickCloseFilter().clickOpenFilter();
        tipoDatoGridPage.setCriterioCodigo("ACUERDO").clickFilter();

        final TipoDatoDetailPage tipoDatoDetailPage = new TipoDatoDetailPage(webDriver, fluentWebDriver);

        tipoDatoDetailPage.gotoPage().back();

        final TipoDatoEditPage tipoDatoEditPage = new TipoDatoEditPage(webDriver, fluentWebDriver);

        tipoDatoEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(tipoDatoEditPage.gotoCreatePage().clickSave().hasErrors());

        tipoDatoEditPage.setCodigo("TPDT_BO_TEST").setTpel(TipoElemento.BO).setTpht(TipoHtml.CB).setI18n("TpdtBOTest")
                .clickSave();

        Assert.assertTrue(tipoDatoEditPage.gotoEditPage().setI18n(null).clickSave().hasErrors());

        tipoDatoEditPage.setI18n("TpdtBOTest Bis").clickSave();

        tipoDatoDetailPage.clickDelete().confirmCancel().clickDelete().confirmOk();

        // p("vm.tpdt.codigo").getText().shouldBe(codigo);

        tipoDatoEditPage.gotoCreatePage();
        tipoDatoEditPage.setCodigo("TPDT_PR_TEST").setTpel(TipoElemento.PR).setTpht(TipoHtml.S).setEnti(Entidad.ACUERDO)
                .setI18n("TpdtPRTest").clickSave();

        tipoDatoDetailPage.clickDelete().confirmCancel().clickDelete().confirmOk();
    }
}
