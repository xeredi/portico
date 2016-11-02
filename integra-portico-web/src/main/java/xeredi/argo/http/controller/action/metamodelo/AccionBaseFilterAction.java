package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseFilterAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionBaseFilterAction extends GridFilterAction<AccionBaseCriterioVO> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1615933316922788769L;

	/** The acpr list. */
	private ClassPrefix[] acprList;

	/** The acco list. */
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
		acprList = ClassPrefix.values();
    }
}
