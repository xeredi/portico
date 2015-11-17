package xeredi.integra.http.page.metamodelo;

import xeredi.integra.http.page.BaseFluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoDetailPage.
 */
public final class TipoDatoDetailPage extends BaseFluentPage {

    public void gotoEdit() {
        click("a[ng-href*='http://127.0.0.1:8080/web/#/metamodelo/tpdt/edit/edit']");
    }
}
