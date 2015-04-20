/**
 *
 */
package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.GridFilterAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;

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
}
