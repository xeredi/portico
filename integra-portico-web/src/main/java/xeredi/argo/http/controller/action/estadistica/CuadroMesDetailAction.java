package xeredi.argo.http.controller.action.estadistica;

import java.util.List;
import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.bo.CuadroMesBO;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.CuadroMesVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesAction.
 */
public final class CuadroMesDetailAction extends CrudDetailAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6080323896171314975L;

    /** The cdms map. */
    private Map<String, List<CuadroMesVO>> cdmsMap;

    // acciones web
    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final CuadroMesBO cdmsBO = new CuadroMesBO();

        model = peprBO.select(model.getId());
        cdmsMap = cdmsBO.selectMap(model.getId());
    }

    // get / set

    /**
     * Gets the cdms map.
     *
     * @return the cdms map
     */
    public Map<String, List<CuadroMesVO>> getCdmsMap() {
        return cdmsMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.cdms;
    }
}
