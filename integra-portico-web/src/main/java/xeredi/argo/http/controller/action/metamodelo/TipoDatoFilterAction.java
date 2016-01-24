/**
 *
 */
package xeredi.argo.http.controller.action.metamodelo;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

/**
 * The Class TipoDatoFilterAction.
 *
 * @author xeredi
 */
public final class TipoDatoFilterAction extends GridFilterAction<TipoDatoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1333107471340812199L;

    /** The tpht list. */
    @Getter
    private TipoHtml[] tphtList;

    /** The tpel list. */
    @Getter
    private TipoElemento[] tpelList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        tphtList = TipoHtml.values();
        tpelList = TipoElemento.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpdt;
    }
}
