package xeredi.argo.http.controller.action.estadistica;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.estadistica.bo.CuadroMesBO;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.CuadroMesVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CuadroMesAction.
 */
@Data
public final class CuadroMesDetailAction extends CrudDetailAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6080323896171314975L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.cdms;

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

        model = peprBO.select(model.getId(), getIdioma());
        cdmsMap = cdmsBO.selectMap(model.getId());
    }
}
