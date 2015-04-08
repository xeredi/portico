package xeredi.integra.http.controller.action.proceso;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoEstado;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListadoAction.
 */
public final class ProcesoListadoAction extends PaginableAction implements ModelDriven<ProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8194151847278687792L;

    /** The prbt criterio vo. */
    private ProcesoCriterioVO model;

    /** The prbt list. */
    private PaginatedList<ProcesoVO> prbtList;

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("prbt-list")
    public String listado() {
        final ProcesoBO prbtBO = new ProcesoBO();

        if (model == null) {
            model = new ProcesoCriterioVO();
        }

        prbtList = prbtBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("prbt-filter")
    public String filtro() {
        return SUCCESS;
    }

    // get / set

    /**
     * Gets the proceso tipos.
     *
     * @return the proceso tipos
     */
    public ProcesoTipo[] getProcesoTipos() {
        return ProcesoTipo.values();
    }

    /**
     * Gets the proceso modulos.
     *
     * @return the proceso modulos
     */
    public ProcesoModulo[] getProcesoModulos() {
        return ProcesoModulo.values();
    }

    /**
     * Gets the proceso estados.
     *
     * @return the proceso estados
     */
    public ProcesoEstado[] getProcesoEstados() {
        return ProcesoEstado.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProcesoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final ProcesoCriterioVO value) {
        model = value;
    }

    /**
     * Gets the prbt list.
     *
     * @return the prbt list
     */
    public PaginatedList<ProcesoVO> getPrbtList() {
        return prbtList;
    }

}
