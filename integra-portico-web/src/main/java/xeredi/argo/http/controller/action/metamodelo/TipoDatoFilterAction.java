/**
 *
 */
package xeredi.argo.http.controller.action.metamodelo;

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
    private TipoHtml[] tphtList;

    /** The tpel list. */
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
     * Gets the tpel list.
     *
     * @return the tpel list
     */
    public TipoElemento[] getTpelList() {
        return tpelList;
    }

    /**
     * Gets the tpht list.
     *
     * @return the tpht list
     */
    public TipoHtml[] getTphtList() {
        return tphtList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpdt;
    }
}
