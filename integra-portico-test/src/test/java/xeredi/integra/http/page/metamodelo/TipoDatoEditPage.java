package xeredi.integra.http.page.metamodelo;

import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.integra.http.page.BaseFluentPage;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoEditPage.
 */
public final class TipoDatoEditPage extends BaseFluentPage {

    public void setTpdtCreate(final TipoDatoVO tpdt) {
        setCodigo(tpdt.getCodigo());
        // setNombre(tpdt.getNombre());
        setTipoElemento(tpdt.getTipoElemento());
        setTpht(tpdt.getTpht());
        setEnti(tpdt.getEnti());
    }

    public void setCodigo(final String value) {
        fill("input[ng-model='vm.tpdt.codigo']").with(value);
    }

    public void setNombre(final String value) {
        fill("input[ng-model='vm.tpdt.nombre']").with(value);
    }

    public void setTipoElemento(final TipoElemento tpel) {
        fillSelect("select[ng-model='vm.tpdt.tipoElemento']", tpel.name());
    }

    public void setTpht(final TipoHtml tpht) {
        fillSelect("select[ng-model='vm.tpdt.tpht']", tpht.name());
    }

    public void setEnti(final EntidadVO enti) {
        fillSelect("select[ng-model='vm.tpdt.enti.id']", enti.getId());
    }
}
