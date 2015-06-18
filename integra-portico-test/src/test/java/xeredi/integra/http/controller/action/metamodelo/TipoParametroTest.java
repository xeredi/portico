package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import xeredi.integra.http.page.metamodelo.EntidadAccionEditPage;
import xeredi.integra.http.page.metamodelo.EntidadAccionGrupoEditPage;
import xeredi.integra.http.page.metamodelo.EntidadGrupoDatoEditPage;
import xeredi.integra.http.page.metamodelo.EntidadTipoDatoEditPage;
import xeredi.integra.http.page.metamodelo.TipoParametroEditPage;
import xeredi.integra.http.page.metamodelo.TipoParametroGridPage;
import xeredi.integra.http.page.seguridad.UsuarioAccesoPage;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.test.comun.AngularJsTest;

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
        tpprEditPage.setCodigo("TPPR_TEST").setMaxGrid("10000").setI18n("Tppr Test").clickSave();

        Assert.assertTrue(tpprEditPage.gotoEditPage().setI18n(null).clickSave().hasErrors());
        tpprEditPage.setMaxGrid("20000").setI18n("Tppr Test Bis").clickSave();

        final EntidadGrupoDatoEditPage engdEditPage = new EntidadGrupoDatoEditPage(webDriver, fluentWebDriver);

        engdEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(engdEditPage.gotoCreatePage().clickSave().hasErrors());
        engdEditPage.setNumero("1").setI18n("Tppr Test General").clickSave();

        Assert.assertTrue(engdEditPage.gotoEditPage().setI18n(null).clickSave().hasErrors());
        engdEditPage.setNumero("2").setI18n("Tppr Test General Bis").clickSave().back();

        final EntidadTipoDatoEditPage entdEditPage = new EntidadTipoDatoEditPage(webDriver, fluentWebDriver);

        entdEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(entdEditPage.gotoCreatePage().clickSave().hasErrors());
        entdEditPage.setTpdt(TipoDato.ACUERDO).setGrupo("1").setFila("1").setOrden("1").setSpan("3")
                .setObligatorio("true").setGridable("true").setFiltrable("true").setI18n("Acuerdo").clickSave();

        Assert.assertTrue(entdEditPage.gotoEditPage().setI18n(null).clickSave().hasErrors());
        entdEditPage.setFila("2").setObligatorio("false").setGridable("false").setFiltrable("false")
                .setI18n("Acuerdo Bis").clickSave().back();

        final EntidadAccionEditPage enacEditPage = new EntidadAccionEditPage(webDriver, fluentWebDriver);

        enacEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(enacEditPage.gotoCreatePage().clickSave().hasErrors());
        enacEditPage.setPath("tppr-enac-path").setOrden("1").setI18n("Tppr Action Test").clickSave();

        Assert.assertTrue(enacEditPage.gotoEditPage().setI18n(null).clickSave().hasErrors());
        enacEditPage.setOrden("2").setI18n("Tppr Action Test Bis").clickSave().back();

        final EntidadAccionGrupoEditPage enagEditPage = new EntidadAccionGrupoEditPage(webDriver, fluentWebDriver);

        enagEditPage.gotoCreatePage().clickCancel();
        Assert.assertTrue(enagEditPage.gotoCreatePage().clickSave().hasErrors());
        enagEditPage.setPath("tppr-enag-path").setOrden("1").setI18n("Tppr Action Grid Test").clickSave();

        Assert.assertTrue(enagEditPage.gotoEditPage().setI18n(null).clickSave().hasErrors());
        enagEditPage.setOrden("2").setI18n("Tppr Action Grid Test Bis").clickSave().back();

        // tpsp
        tpspInsert("TPSP_TEST", "100", Entidad.ACUERDO, "Tpsp Test");
        tpspUpdate("200", Entidad.BUQUE, "Tpsp Test New");
        back();
        tpspDetail();
        engdInsert("1", "Tpsp Test General");
        engdUpdate("2", "Tpsp Test General New");
        back();
        entdInsert(TipoDato.ACUERDO, null, "1", "1", "1", "3", "true", "true", "true", "Acuerdo");
        entdUpdate(null, "1", "2", "1", "3", "true", "false", "true", "Acuerdo New");
        back();
        enacInsert("tpsp-enac-path", "1", "Tpsp Action Test");
        enacUpdate("2", "Tpsp Action Test New");
        back();
        entdDetail();
        entdDelete();
        engdDetail();
        engdDelete();
        enacDetail();
        enacDelete();
        tpspDelete();

        // Borrado tppr
        entdDetail();
        entdDelete();
        engdDetail();
        engdDelete();
        enacDetail();
        enacDelete();
        enagDetail();
        enagDelete();
        tpprDelete();

        // driver.close();
        // driver.quit();
    }

    /**
     * Tppr detail.
     */
    private void tpprDetail() {
        linkHref("#/metamodelo/tppr/detail").click();
    }

    /**
     * Tppr delete.
     */
    private void tpprDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Tpsp detail.
     */
    private void tpspDetail() {
        linkHref("#/metamodelo/tpsp/detail").click();
    }

    /**
     * Tpsp insert.
     *
     * @param codigo
     *            the codigo
     * @param maxGrid
     *            the max grid
     * @param enti
     *            the enti
     * @param text
     *            the text
     */
    private void tpspInsert(final String codigo, final String maxGrid, final Entidad enti, final String text) {
        linkHref("#/metamodelo/tpsp/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/tpsp/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.enti.codigo").sendKeys(codigo);
        select("vm.enti.tpprAsociado.id").selectByValue("number:" + enti.getId());
        input("vm.enti.maxGrid").sendKeys(maxGrid);
        input("vm.i18nMap[default_language].text").sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Tpsp update.
     *
     * @param maxGrid
     *            the max grid
     * @param enti
     *            the enti
     * @param text
     *            the text
     */
    private void tpspUpdate(final String maxGrid, final Entidad enti, final String text) {
        linkHref("#/metamodelo/tpsp/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/tpsp/edit/edit").click();

        input("vm.i18nMap[default_language].text").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.enti.maxGrid").clearField().sendKeys(maxGrid);
        select("vm.enti.tpprAsociado.id").selectByValue("number:" + enti.getId());
        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Tpsp delete.
     */
    private void tpspDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Entd detail.
     */
    private void entdDetail() {
        linkHref("#/metamodelo/entd/detail").click();
    }

    /**
     * Entd insert.
     *
     * @param tpdt
     *            the tpdt
     * @param valorDefecto
     *            the valor defecto
     * @param grupo
     *            the grupo
     * @param fila
     *            the fila
     * @param orden
     *            the orden
     * @param span
     *            the span
     * @param obligatorio
     *            the obligatorio
     * @param gridable
     *            the gridable
     * @param filtrable
     *            the filtrable
     * @param etiqueta
     *            the etiqueta
     */
    private void entdInsert(final TipoDato tpdt, final String valorDefecto, final String grupo, final String fila,
            final String orden, final String span, final String obligatorio, final String gridable,
            final String filtrable, final String etiqueta) {
        linkHref("#/metamodelo/entd/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/entd/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        select("vm.entd.tpdt.id").selectByValue("number:" + tpdt.getId());
        input("vm.entd.valorDefecto").sendKeys(valorDefecto);
        input("vm.entd.grupo").sendKeys(grupo);
        input("vm.entd.fila").sendKeys(fila);
        input("vm.entd.orden").sendKeys(orden);
        input("vm.entd.span").sendKeys(span);
        select("vm.entd.obligatorio").selectByValue("boolean:" + obligatorio);
        select("vm.entd.gridable").selectByValue("boolean:" + gridable);
        select("vm.entd.filtrable").selectByValue("boolean:" + filtrable);

        input("vm.i18nMap[default_language].text").sendKeys(etiqueta);

        button("vm.save()").click();
    }

    private void entdUpdate(final String valorDefecto, final String grupo, final String fila, final String orden,
            final String span, final String obligatorio, final String gridable, final String filtrable,
            final String etiqueta) {
        linkHref("#/metamodelo/entd/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/entd/edit/edit").click();

        input("vm.entd.orden").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.entd.valorDefecto").clearField().sendKeys(valorDefecto);
        input("vm.entd.grupo").clearField().sendKeys(grupo);
        input("vm.entd.fila").clearField().sendKeys(fila);
        input("vm.entd.orden").clearField().sendKeys(orden);
        input("vm.entd.span").clearField().sendKeys(span);
        select("vm.entd.obligatorio").selectByValue("boolean:" + obligatorio);
        select("vm.entd.gridable").selectByValue("boolean:" + gridable);
        select("vm.entd.filtrable").selectByValue("boolean:" + filtrable);

        input("vm.i18nMap[default_language].text").clearField().sendKeys(etiqueta);

        button("vm.save()").click();
    }

    /**
     * Entd delete.
     */
    private void entdDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Engd detail.
     */
    private void engdDetail() {
        linkHref("#/metamodelo/engd/detail").click();
    }

    /**
     * Engd insert.
     *
     * @param numero
     *            the numero
     * @param text
     *            the text
     */
    private void engdInsert(final String numero, final String text) {
        linkHref("#/metamodelo/engd/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/engd/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.engd.numero").sendKeys(numero);
        input("vm.i18nMap[default_language].text").sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Engd update.
     *
     * @param numero
     *            the numero
     * @param text
     *            the text
     */
    private void engdUpdate(final String numero, final String text) {
        linkHref("#/metamodelo/engd/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/engd/edit/edit").click();

        input("vm.engd.numero").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.engd.numero").clearField().sendKeys(numero);
        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Engd delete.
     */
    private void engdDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Enac detail.
     */
    private void enacDetail() {
        linkHref("#/metamodelo/enac/detail").click();
    }

    /**
     * Enac insert.
     *
     * @param path
     *            the path
     * @param orden
     *            the orden
     * @param text
     *            the text
     */
    private void enacInsert(final String path, final String orden, final String text) {
        linkHref("#/metamodelo/enac/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/enac/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.enac.path").sendKeys(path);
        input("vm.enac.orden").sendKeys(orden);
        input("vm.i18nMap[default_language].text").sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Enac update.
     *
     * @param orden
     *            the orden
     * @param text
     *            the text
     */
    private void enacUpdate(final String orden, final String text) {
        linkHref("#/metamodelo/enac/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/enac/edit/edit").click();

        input("vm.enac.orden").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.enac.orden").clearField().sendKeys(orden);
        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Enac delete.
     */
    private void enacDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }

    /**
     * Enag detail.
     */
    private void enagDetail() {
        linkHref("#/metamodelo/enag/detail").click();
    }

    /**
     * Enag insert.
     *
     * @param path
     *            the path
     * @param orden
     *            the orden
     * @param text
     *            the text
     */
    private void enagInsert(final String path, final String orden, final String text) {
        linkHref("#/metamodelo/enag/edit/create").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/enag/edit/create").click();
        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.enag.path").sendKeys(path);
        input("vm.enag.orden").sendKeys(orden);
        input("vm.i18nMap[default_language].text").sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Enag update.
     *
     * @param orden
     *            the orden
     * @param text
     *            the text
     */
    private void enagUpdate(final String orden, final String text) {
        linkHref("#/metamodelo/enag/edit/edit").click();
        button("vm.cancel()").click();
        linkHref("#/metamodelo/enag/edit/edit").click();

        input("vm.enag.orden").clearField();

        button("vm.save()").click();

        Assert.assertTrue(span("span[translate='errorList']").isDisplayed().value());

        input("vm.enag.orden").clearField().sendKeys(orden);
        input("vm.i18nMap[default_language].text").clearField().sendKeys(text);

        button("vm.save()").click();
    }

    /**
     * Enag delete.
     */
    private void enagDelete() {
        button("vm.remove()").click();
        webDriver.switchTo().alert().dismiss();
        button("vm.remove()").click();
        webDriver.switchTo().alert().accept();
    }
}
