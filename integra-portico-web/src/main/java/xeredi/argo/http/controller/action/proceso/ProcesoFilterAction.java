package xeredi.argo.http.controller.action.proceso;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoEstado;
import xeredi.argo.model.proceso.vo.ProcesoModulo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoFilterAction.
 */
@Data
public final class ProcesoFilterAction extends GridFilterAction<ProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2346523384273947533L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.prbt;

    /** The proceso tipos. */
    private ProcesoTipo[] procesoTipos;

    /** The proceso modulos. */
    private ProcesoModulo[] procesoModulos;

    /** The proceso estados. */
    private ProcesoEstado[] procesoEstados;

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
        procesoTipos = ProcesoTipo.values();
        procesoEstados = ProcesoEstado.values();
        procesoModulos = ProcesoModulo.values();
    }
}
