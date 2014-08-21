package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.Entidad;
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
    private List<EntidadVO> entis;

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
    @Action(value = "enti-hija-listado-content")
    public String hijaListado() {
        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        if (entiCriterio.getEntiPadreId() == null) {
            throw new Error("No se ha proporcionado una entidad padre");
        }

        entis = entiBO.selectList(entiCriterio);

        return SUCCESS;
    }

    /**
     * Padre listado.
     *
     * @return the string
     */
    @Action(value = "enti-padre-listado-content")
    public String padreListado() {
        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        if (entiCriterio.getEntiHijaId() == null) {
            throw new Error("No se ha proporcionado una entidad hija");
        }

        entis = entiBO.selectList(entiCriterio);

        return SUCCESS;
    }

    // get/set
    /**
     * Gets the list.
     *
     * @return the list
     */
    public List<EntidadVO> getEntis() {
        return entis;
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
