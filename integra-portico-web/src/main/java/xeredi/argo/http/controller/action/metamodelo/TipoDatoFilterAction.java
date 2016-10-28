/**
 *
 */
package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;

/**
 * The Class TipoDatoFilterAction.
 *
 * @author xeredi
 */
@Data
public final class TipoDatoFilterAction extends GridFilterAction<TipoDatoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1333107471340812199L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpdt;

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
}
