package xeredi.integra.http.controller.action.proceso;

import xeredi.integra.http.controller.action.comun.GridFilterAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoEstado;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoFilterAction.
 */
public final class ProcesoFilterAction extends GridFilterAction<ProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2346523384273947533L;

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

    /**
     * Gets the proceso tipos.
     *
     * @return the proceso tipos
     */
    public ProcesoTipo[] getProcesoTipos() {
        return procesoTipos;
    }

    /**
     * Gets the proceso modulos.
     *
     * @return the proceso modulos
     */
    public ProcesoModulo[] getProcesoModulos() {
        return procesoModulos;
    }

    /**
     * Gets the proceso estados.
     *
     * @return the proceso estados
     */
    public ProcesoEstado[] getProcesoEstados() {
        return procesoEstados;
    }
}
