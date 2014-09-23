package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadListadoAction.
 */
public final class EntidadListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1250990272188228335L;

    /** The entis. */
    private final List<EntidadVO> entiList = new ArrayList<>();

    /** The enti criterio form. */
    private EntidadCriterioVO entiCriterio;

    /**
     * Instantiates a new entidad listado action.
     */
    public EntidadListadoAction() {
        super();

        entiCriterio = new EntidadCriterioVO();
    }

    // Acciones Web
    /**
     * Listar.
     *
     * @return the string
     */
    @Action("enti-hija-list-content")
    public String hijaListado() {
        final EntidadBO entiBO = new EntidadBO();

        if (entiCriterio.getEntiPadreId() == null) {
            throw new Error("No se ha proporcionado una entidad padre");
        }

        entiList.addAll(entiBO.selectList(entiCriterio));

        return SUCCESS;
    }

    /**
     * Padre listado.
     *
     * @return the string
     */
    @Action("enti-padre-list-content")
    public String padreListado() {
        final EntidadBO entiBO = new EntidadBO();

        if (entiCriterio.getEntiHijaId() == null) {
            throw new Error("No se ha proporcionado una entidad hija");
        }

        entiList.addAll(entiBO.selectList(entiCriterio));

        return SUCCESS;
    }

    // get/set
    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<EntidadVO> getEntiList() {
        return entiList;
    }

    /**
     * Gets the enti criterio.
     *
     * @return the enti criterio
     */
    public EntidadCriterioVO getEntiCriterio() {
        return entiCriterio;
    }

    /**
     * Sets the enti criterio.
     *
     * @param value
     *            the new enti criterio
     */
    public void setEntiCriterio(final EntidadCriterioVO value) {
        entiCriterio = value;
    }

}
