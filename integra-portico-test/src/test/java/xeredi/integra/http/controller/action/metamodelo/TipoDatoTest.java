package xeredi.integra.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.test.comun.FluentBaseTest;
import xeredi.integra.http.page.metamodelo.TipoDatoDetailPage;
import xeredi.integra.http.page.metamodelo.TipoDatoEditPage;
import xeredi.integra.http.page.metamodelo.TipoDatoGridPage;
import xeredi.integra.http.page.seguridad.UsuarioAccesoPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoTest.
 */
public final class TipoDatoTest extends FluentBaseTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(TipoDatoTest.class);

    @Page
    private UsuarioAccesoPage usuarioAccesoPage;

    @Page
    private TipoDatoGridPage tpdtGridPage;

    @Page
    private TipoDatoEditPage tpdtEditPage;

    @Page
    private TipoDatoDetailPage tpdtDetailPage;

    @Test
    public void test() {
        maximizeWindow();

        goTo(usuarioAccesoPage).setUsuario("admin").setContrasenia("admin").loginSuccessful();

        click("a[translate='menu']");
        click("a[ng-href*='#/administracion']");

        goTo(tpdtGridPage);

        tpdtGridPage.openFilter();
        tpdtGridPage.closeFilter();
        tpdtGridPage.openFilter();

        final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

        tpdtCriterio.setCodigo(TipoDato.ACUERDO.name());
        tpdtCriterio.setTipoElemento(TipoElemento.PR);
        tpdtCriterio.setTpht(TipoHtml.S);

        tpdtGridPage.setTpdtCriterio(tpdtCriterio);
        tpdtGridPage.search();

        tpdtGridPage.gotoDetail();
        tpdtDetailPage.back();

        tpdtGridPage.gotoCreate();
        tpdtEditPage.cancel();
        tpdtGridPage.gotoCreate();

        final TipoDatoVO tpdt = new TipoDatoVO();
        final EntidadVO enti = new EntidadVO();

        enti.setId(Entidad.ACUERDO.getId());

        tpdt.setCodigo("TEST_ACUE");
        tpdt.setNombre("Test Acuerdo");
        tpdt.setEnti(enti);
        tpdt.setTpht(TipoHtml.F);
        tpdt.setTipoElemento(TipoElemento.PR);

        final Map<String, String> i18nMap = new HashMap<>();

        i18nMap.put("es", "Test Acuerdo");

        tpdtEditPage.setTpdtCreate(tpdt);
        tpdtEditPage.fillI18nMap(i18nMap);
        tpdtEditPage.save();

        tpdtDetailPage.gotoEdit();
        tpdtEditPage.back();

        tpdtDetailPage.remove();
        tpdtDetailPage.alert().dismiss();
        tpdtDetailPage.remove();
        tpdtDetailPage.alert().accept();
    }

    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // protected void doTest() {
    // final UsuarioAccesoPage usuarioAccesoPage = PageFactory.initElements(webDriver,
    // UsuarioAccesoPage.class);
    //
    // usuarioAccesoPage.setLogin("admin").setContrasenia("admin").clickAcceso();
    // usuarioAccesoPage.administracionMenu();
    //
    // final TipoDatoGridPage tpdtGridPage = PageFactory.initElements(webDriver, TipoDatoGridPage.class);
    //
    // tpdtGridPage.gotoPage();
    // tpdtGridPage.showFilter().hideFilter().showFilter();
    // tpdtGridPage.setCodigo("ACUERDO").setTipoElemento(TipoElemento.PR).setTpht(TipoHtml.S).search();
    //
    // final TipoDatoDetailPage tpdtDetailPage = PageFactory.initElements(webDriver,
    // TipoDatoDetailPage.class);
    //
    // tpdtDetailPage.gotoPage().back();
    //
    // final TipoDatoEditPage tpdtEditPage = PageFactory.initElements(webDriver, TipoDatoEditPage.class);
    //
    // tpdtEditPage.gotoCreatePage().cancel();
    // Assert.assertTrue(tpdtEditPage.gotoCreatePage().save().hasErrors());
    //
    // tpdtEditPage.setCodigo("TPDT_BO_TEST").setTpel(TipoElemento.BO).setTpht(TipoHtml.CB).setI18nText("TpdtBOTest")
    // .save();
    //
    // Assert.assertTrue(tpdtEditPage.gotoEditPage().setI18nText(null).save().hasErrors());
    //
    // tpdtEditPage.setI18nText("TpdtBOTest Bis").save();
    //
    // tpdtDetailPage.remove().confirmCancel().remove().confirmOk();
    //
    // // p("vm.tpdt.codigo").getText().shouldBe(codigo);
    //
    // tpdtEditPage.gotoCreatePage();
    // tpdtEditPage.setCodigo("TPDT_PR_TEST").setTpel(TipoElemento.PR).setTpht(TipoHtml.S).setEnti(Entidad.ACUERDO)
    // .setI18nText("TpdtPRTest").save();
    //
    // tpdtDetailPage.remove().confirmCancel().remove().confirmOk();
    // }
}
