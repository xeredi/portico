package xeredi.argo.http.controller.action.metamodelo;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseFilterAction.
 */
public final class AccionBaseFilterAction extends GridFilterAction<TipoServicioCriterioVO> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1615933316922788769L;

	@Getter
	private AccionPrefix[] acprList;

	@Getter
	private AccionCodigo[] accoList;

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
		accoList = AccionCodigo.values();
		acprList = AccionPrefix.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.acbs;
    }
}
