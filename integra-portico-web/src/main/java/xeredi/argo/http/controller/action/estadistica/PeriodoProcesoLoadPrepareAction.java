package xeredi.argo.http.controller.action.estadistica;

import xeredi.argo.http.controller.action.comun.CrudLoadPrepareAction;
import xeredi.argo.http.view.estadistica.ProcesoEstadisticaVO;
import xeredi.argo.model.comun.exception.ApplicationException;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoLoadFileEditAction.
 */
public final class PeriodoProcesoLoadPrepareAction extends CrudLoadPrepareAction<ProcesoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1023266563069437275L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepare() throws ApplicationException {
        model = new ProcesoEstadisticaVO();
    }

}
