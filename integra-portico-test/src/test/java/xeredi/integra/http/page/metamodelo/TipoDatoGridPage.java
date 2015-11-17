package xeredi.integra.http.page.metamodelo;

import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.http.page.BaseFluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoGridPage.
 */
public final class TipoDatoGridPage extends BaseFluentPage {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUrl() {
        return "http://127.0.0.1:8080/web/#/metamodelo/tpdt/grid";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void isAt() {
        super.isAt();
    }

    public void setTpdtCriterio(final TipoDatoCriterioVO criterio) {
        if (criterio.getCodigo() != null) {
            fill("input[ng-model='vm.tpdtCriterio.codigo']").with(criterio.getCodigo());
        }
        if (criterio.getNombre() != null) {
            fill("input[ng-model='vm.tpdtCriterio.nombre']").with(criterio.getNombre());
        }
        if (criterio.getTipoElemento() != null) {
            fillSelect("select[ng-model='vm.tpdtCriterio.tipoElemento']", criterio.getTipoElemento().name());
        }
        if (criterio.getTpht() != null) {
            fillSelect("select[ng-model='vm.tpdtCriterio.tpht']", criterio.getTpht().name());
        }
    }

    public void gotoDetail() {
        click("a[ng-href*='#/metamodelo/tpdt/detail']");
    }

    public void gotoCreate() {
        click("a[ng-href*='#/metamodelo/tpdt/edit/create']");
    }
}
